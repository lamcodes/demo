package com.zkp.controller;

import com.api.api;
import com.zkp.Goods;
import com.zkp.Jifen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("save")
    public Map save(){
        //远程调用goods服务，获取goods信息，发动http请求(httpclient)=>restTemplate spring封装好的
        String service = "cloud-goods";
        String url  = "http://"+service+"/findById/3";

        Goods goods = restTemplate.getForObject(url, Goods.class);
        System.out.println(goods);

        //保存订单
        System.out.println("订单保存成功");

        return new HashMap(){
            {
                put("code","200");
                put("msg","成功");
            }
        };
    }

    @RequestMapping("test")
    public String test(){
        String service = "cloud-goods";
        String url  = "http://"+service+"/save";
        Goods goods = new Goods("华为",4);
        HashMap hashMap = restTemplate.postForObject(url, goods, HashMap.class);
        System.out.println(hashMap);

        return "success";
    }
    @RequestMapping("test1")
    public String test1(){
        String service = "cloud-goods";
        String url  = "http://"+service+"/save";
        Goods goods = new Goods("华为",4);
        ResponseEntity<HashMap> result = restTemplate.postForEntity(url, goods, HashMap.class);
        System.out.println(result.getBody());
        System.out.println(result.getStatusCode());
        return "success";
    }
    @RequestMapping("test2")
    public Map test2(){
        //远程调用goods服务，获取goods信息，发动http请求(httpclient)=>restTemplate spring封装好的
        String service = "cloud-goods";
        String url  = "http://"+service+"/findById/3";

        ResponseEntity<Goods> forEntity = restTemplate.getForEntity(url, Goods.class);
        System.out.println(forEntity.getBody());
        System.out.println(forEntity.getStatusCode());

        //保存订单
        System.out.println("订单保存成功");

        return new HashMap(){
            {
                put("code","200");
                put("msg","成功");
            }
        };
    }
    @Autowired
    private com.api.api api;

    @RequestMapping("feign1")
    public Map feign1(){

        Jifen jifen = new Jifen(1,10,"2");
        Map save = api.save(jifen);
        return save;
    }
    @RequestMapping("feign2")
    public Map update() {
        Jifen jifen = new Jifen(10,11,"update");
        Map update = api.update(jifen);
        return update;
    }
    @GetMapping(value = "/feign3")
    public Map deleteById() {
        //url  http://cloud-jifen/jifen/delete?jifenId=1
        int jifenId = 99;
        Map deleteById =api.deleteById(jifenId);

        return  deleteById;
    }

    @RequestMapping("test4")
    public Jifen test4(){

        int jifenId = 10;
        Jifen jifenById = api.findJifenById(100);

        return  jifenById;
    }

}
