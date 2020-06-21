package com.wzz.houseservice.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "wuzezhou-demo")
@RequestMapping("demo")
public interface ClientFeign {

    @GetMapping("list")
    public String list();
}
