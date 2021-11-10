package com.api;

import com.zkp.Jifen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @author admin
  * @FeignClient 可以被feign服务端调用
 */
@FeignClient("cloud-openfeign") // 开启feign客户端，可以被调用。
public interface api {

    @PostMapping(value = "/save")
    public Map save(@RequestBody Jifen jifen) ;

    @PostMapping(value = "/update")
    public Map update(@RequestBody Jifen jifen) ;

    @GetMapping(value = "/delete")
    public Map deleteById( Integer jifenId) ;

    @GetMapping(value = "find/{jifenId}")
    public Jifen findJifenById(@PathVariable Integer jifenId) ;
//
//    @GetMapping(value = "/search")
//    public Jifen search(Integer uid,String type) ;
//
//    @PostMapping(value = "/searchByEntity")
//    public List<Jifen> searchMap(@RequestBody Jifen jifen) ;

}
