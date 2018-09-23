package com.littlejohnny.util;

public class IMGUtill {
    public static ImageTypes verifyImageType(String fileName) throws Exception {
        ImageTypes imageType;
        if (fileName.contains(ImageTypes.JPEG.getExtension())) {
            imageType = ImageTypes.JPEG;
        } else if (fileName.contains(ImageTypes.JPEG.getExtension())) {
            imageType = ImageTypes.PNG;
        } else if (fileName.contains(ImageTypes.JPEG.getExtension())) {
            imageType = ImageTypes.GIF;
        } else {
            throw new Exception("Unsupported image type");
        }
        return imageType;
    }
}
