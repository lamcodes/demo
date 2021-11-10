package com.zkp.controller;

import com.zkp.Goods;
import com.zkp.Jifen;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class OpenfeignController {

    @PostMapping(value = "/save")
    public Map save(@RequestBody Jifen jifen) {

        System.out.println("调⽤了积分保存接⼝");
        System.out.println(jifen);
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","save success");
        }};
    }
    @PostMapping(value = "/update")
    public Map update(@RequestBody Jifen jifen) {
        System.out.println(jifen);
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","update success");
        }};
    }
    @GetMapping(value = "/delete")
    public Map deleteById(@RequestParam Integer jifenId) {
        System.out.println("删除id为"+jifenId+"的积分信息");
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","delete success");
        }};
    }
    @GetMapping(value = "find/{jifenId}")
    public Jifen findJifenById(@PathVariable Integer jifenId) {
        System.out.println("已经查询到"+jifenId+"积分数据");
        return new Jifen(jifenId, 12,jifenId+"号积分");
    }
    @GetMapping(value = "/search")
    public Jifen search(Integer uid,String type) {
        System.out.println("uid:"+uid+"type:"+type);
        return new Jifen(uid, 12,type);
    }
    @PostMapping(value = "/searchByEntity")
    public List<Jifen> searchMap(@RequestBody Jifen jifen) {
        System.out.println(jifen);
        List<Jifen> jifens = new ArrayList<Jifen>();
        jifens.add(new Jifen(110,12,"下单积分"));
        jifens.add(new Jifen(111,18,"⽀付积分"));
        return jifens;
    }

    @PostMapping(value = "/t")
    public String t(@RequestBody Goods goods){
        System.out.println(goods);
        return String.valueOf(goods);
    }
    @PostMapping(value = "/t1")
    public String t1(int x){
        System.out.println("------"+x);
        return String.valueOf(x);
    }
    @GetMapping(value = "/t2")
    public String t2( String x){
        System.out.println("------"+x+"++++++");
        return x;
    }
    @GetMapping(value = "/t3")
    public String t3( @RequestBody Goods x){
        System.out.println("------"+x+"++++++");
        return String.valueOf(x);
    }
}

