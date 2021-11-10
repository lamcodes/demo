package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author admin
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启服务注册与发现

public class GoodsApp {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApp.class,args);
    }
}
