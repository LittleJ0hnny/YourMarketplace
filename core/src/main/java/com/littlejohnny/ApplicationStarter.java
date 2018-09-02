package com.littlejohnny;

import com.littlejohnny.domain.service.AttributeValueService;
import com.littlejohnny.domain.service.ProductAttributeService;
import com.littlejohnny.domain.service.ProductService;
import com.littlejohnny.domain.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class);
        System.out.println("CORE successfully started!");
    }
}
