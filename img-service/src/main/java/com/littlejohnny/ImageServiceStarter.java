package com.littlejohnny;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class ImageServiceStarter {
    public static void main(String[] args) {
        SpringApplication.run(ImageServiceStarter.class);
        System.out.println("IMG_SERVICE successfully started!");
    }
}
