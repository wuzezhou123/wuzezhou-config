package com.wzz.houseservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wzz.houseservice.config.ClientFeign;
import com.wzz.houseservice.entity.Decorate;
import com.wzz.houseservice.pojo.House;
import com.wzz.houseservice.service.IHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 吴泽洲
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private IHouseService houseService;

    @Autowired
    private ClientFeign clientFeign;

    private Logger logger= LoggerFactory.getLogger(HouseController.class);

    @HystrixCommand(fallbackMethod = "listFallBack")
    @GetMapping("list")
    public IPage<House> list(House house,
                                @RequestParam(defaultValue = "1")Integer pageNum,
                                @RequestParam(defaultValue = "3")Integer pageSize){
        String list = clientFeign.list();
         logger.info(list);
        QueryWrapper<House> wrapper=new QueryWrapper();
        BigDecimal lastRent = house.getLastRent();
        BigDecimal rent = house.getRent();

        if(lastRent!=null && rent!=null && !lastRent.toString().equals("0") && !lastRent.toString().equals("0")){
            logger.info(lastRent.toString()+"==="+rent.toString());
            wrapper.gt("rent",rent.subtract(new BigDecimal(0.1)));
            wrapper.lt("rent",lastRent.add(new BigDecimal(0.1)));
        }
        if(house.getRoom()!=null && house.getRoom()!=0)
        wrapper.eq("room",house.getRoom());
        if(house.getCity()!=null)
        wrapper.eq("city",house.getCity());
        Page<House> page=new Page<>(pageNum,pageSize);
        IPage info = houseService.page(page, wrapper);
//        info.getCurrent();
//        info.getTotal();
//        info.orders();
        List<House> records = info.getRecords();
        records.forEach(msg->{
            Integer decorate = msg.getDecorate();
            Decorate[] values = Decorate.values();
            for(int i=0;i<values.length;i++){
               if(values[i].getId()==decorate)
                   msg.setDecorateName(values[i].getName());
            }
        });
        return info;

    }
    public IPage<House> listFallBack(House house,
                                     Integer pageNum,
                                     Integer pageSize){
        return null;
    }


    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String originalFilename = file.getOriginalFilename();
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String name = UUID.randomUUID().toString();
        File f=new File("D:\\pic\\"+name+suffix);
        file.transferTo(f);
        return name+suffix;
    }

    @PostMapping("add")
    public Boolean add(@RequestBody House house){
        boolean save = houseService.save(house);
        return save;
    }

    @GetMapping("get")
    public Decorate[] get(){
        return Decorate.values();
    }
}

