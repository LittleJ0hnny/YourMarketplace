package com.littlejohnny.gateway.domain.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("image-service")
public interface ImgServiceClient {

    @GetMapping("/images/{fileName}")
    ResponseEntity<byte[]> getImageByName(@PathVariable("fileName") String fileName);

    @GetMapping("/images/message")
    String getMessage();
}
