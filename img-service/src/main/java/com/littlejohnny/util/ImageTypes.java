package com.littlejohnny.util;

import org.springframework.http.MediaType;

public enum ImageTypes {
    JPEG(".jpg", MediaType.IMAGE_JPEG_VALUE),
    PNG(".png", MediaType.IMAGE_PNG_VALUE),
    GIF(".gif", MediaType.IMAGE_GIF_VALUE);

    private String extension;
    private String mediaType;

    ImageTypes(String extension, String mediaType) {
        this.extension = extension;
        this.mediaType = mediaType;
    }

    public String getExtension() {
        return extension;
    }

    public String getMediaType() {
        return mediaType;
    }
}
