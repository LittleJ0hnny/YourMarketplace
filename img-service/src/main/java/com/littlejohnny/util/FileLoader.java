package com.littlejohnny.util;

import com.littlejohnny.exception.FileNameException;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileLoader {
    @Value( "${fileStorage.path}" )
    public static String fileStoragePath = "C:\\image";

    public File getFile(Path path) {
        return path.toFile();
    }

    public void deleteFile(Path path) throws IOException {
        Files.delete(path);
    }

    public Path createFile(String fileName) throws IOException {
        if(fileName != null && fileName.length() > 0) {
            throw new FileNameException("");
        }
        return Files.createFile(Paths.get(new StringBuilder(fileStoragePath).append("\\").append(fileName).toString()));
    }

    public Path updateFile(String fileName) throws IOException {
        if(fileName != null && fileName.length() > 0) {
            throw new FileNameException("");
        }
        Path filePath = Paths.get(new StringBuilder(fileStoragePath).append("\\").append(fileName).toString());
        Files.delete(filePath);
        return Files.createFile(filePath);
    }
}
