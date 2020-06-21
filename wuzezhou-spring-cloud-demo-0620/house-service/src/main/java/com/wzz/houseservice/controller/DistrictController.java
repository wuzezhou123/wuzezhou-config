package com.wzz.houseservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wzz.houseservice.pojo.District;
import com.wzz.houseservice.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 吴泽洲
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/district")
public class DistrictController {
    @Autowired
    private IDistrictService districtService;

    @GetMapping("area")
    public List<District> area(@RequestParam(defaultValue = "1") Integer pid){
        QueryWrapper wrapper=new QueryWrapper();
        wrapper.eq("parent",pid);
        List<District> list = districtService.list(wrapper);
        return list;
    }

}

