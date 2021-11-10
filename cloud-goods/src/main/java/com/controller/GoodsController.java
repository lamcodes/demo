package com.controller;

import com.zkp.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@RestController
public class GoodsController {

    @Value("${server.port}")
    public String port;

    @RequestMapping("findById/{id}")
    public Goods findById(@PathVariable String id){
        System.out.println("id: "+id);
        return new Goods("小米"+port,99);
    }

    @RequestMapping("save")
    public Map save(@RequestBody Goods goods){

        System.out.println(goods);
        return new HashMap(){
            {
                put("code",200);
                put("msg","goods save success");
            }
        };
    }
}
