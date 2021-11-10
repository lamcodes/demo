package com.zkp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author admin
 */
@SpringBootApplication
@EnableDiscoveryClient //开启nacos注册中心
//@RibbonClient(name = "cloud-goods")
@EnableFeignClients(basePackages = {"com.api"})  //调用feign，告诉框架扫描所有使用注解@FeignClient定义的feign客户端
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate initRestTemplate(){

        return new RestTemplate();
    }
}
