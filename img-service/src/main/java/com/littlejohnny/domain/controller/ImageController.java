package com.littlejohnny.domain.controller;

import com.littlejohnny.domain.service.StorageService;
import com.littlejohnny.exception.NonExistentResourceEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class ImageController {
    @Autowired
    private StorageService storageService;

    @GetMapping("/images/download/{fileName}")
    public @ResponseBody ResponseEntity<byte[]> loadImageByName(@PathVariable String fileName) throws IOException {
        Path path = storageService.load(fileName);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + path.getFileName() + "\"").body(Files.readAllBytes(path));
    }

    @GetMapping("/images/message")
    public @ResponseBody ResponseEntity<String> getMessage() {
        return ResponseEntity.ok("Hello World !");
    }

    @GetMapping("/images/{fileName}")
    public @ResponseBody ResponseEntity<byte[]> getImageByName(@PathVariable String fileName) throws IOException {
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_JPEG_VALUE).body(Files.readAllBytes(storageService.load(fileName)));
    }

    @PostMapping("/images")
    public ResponseEntity saveImage(@RequestParam MultipartFile file) throws IOException {
        storageService.store(file);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(("/images/{filename}"))
    public ResponseEntity deleteImage(@PathVariable String fileName) throws IOException {
        storageService.delete(fileName);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
