package com.littlejohnny.domain.service.impls;

import com.littlejohnny.domain.service.StorageService;
import com.littlejohnny.exception.NameDuplicationEx;
import com.littlejohnny.exception.NonExistentResourceEx;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class StorageServiceImpl implements StorageService {

    @Value("${fileStorage.path}")
    private String storagePath;

    @Override
    public void store(MultipartFile file) throws IOException {
        Path path = Paths.get(pathBuilder(file.getOriginalFilename()));
        if(Files.exists(path)) {
            throw new NameDuplicationEx("Resource with name " + file.getOriginalFilename() + " already exists");
        }
        Files.write(Paths.get(pathBuilder(file.getOriginalFilename())), file.getBytes());
    }

    @Override
    public Path load(String fileName) {
        Path path = new File(pathBuilder(fileName)).toPath();
        if (Files.notExists(path)) {
            throw new NonExistentResourceEx("Resource with name " + fileName + " does not exist");
        }
        return path;
    }

    @Override
    public Resource loadAsResource(String fileName) {
        return new FileSystemResource(pathBuilder(fileName));
    }

    @Override
    public void delete(String fileName) throws IOException {
        Path path = Paths.get(pathBuilder(fileName));
        if (Files.notExists(path)) {
            throw new NonExistentResourceEx("Resource with name " + fileName + " does not exist");
        }
        Files.delete(path);
    }

    private String pathBuilder(String fileName) {
        return new StringBuilder(storagePath)
                .append("/")
                .append(fileName)
                .toString();
    }
}
