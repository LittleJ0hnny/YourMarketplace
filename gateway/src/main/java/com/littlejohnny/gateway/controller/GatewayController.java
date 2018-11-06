package com.littlejohnny.gateway.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private RestOperations restOperations;

    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient discoveryClient;

    @GetMapping("/message")
    @PreAuthorize("hasRole('ADMIN')")
    public String getMessage() {
        return restOperations.getForObject("http://localhost:8084/message", String.class);
    }
}
