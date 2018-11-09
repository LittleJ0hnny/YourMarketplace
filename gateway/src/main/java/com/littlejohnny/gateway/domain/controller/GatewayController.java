package com.littlejohnny.gateway.domain.controller;

import com.littlejohnny.gateway.domain.feign.ImgServiceClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Autowired
    private ImgServiceClient imgServiceClient;

    @GetMapping("/images/{fileName}")
    public @ResponseBody ResponseEntity<byte[]> getImageByName(@PathVariable("fileName") String fileName) {
        return imgServiceClient.getImageByName(fileName);
    }

    @GetMapping("/images/msg")
    public @ResponseBody ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(imgServiceClient.getMessage());
    }
}
