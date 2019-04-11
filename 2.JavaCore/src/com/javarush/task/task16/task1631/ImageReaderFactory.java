package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes types) {
        ImageReader imageReader = null;
        try {
            if (types.equals(ImageTypes.BMP)) {
                imageReader = new BmpReader();
            }
            else if (types.equals(ImageTypes.JPG)) {
                imageReader = new JpgReader();
            }
            else if (types.equals(ImageTypes.PNG)) {
                imageReader = new PngReader();
            }
        }
        catch (Exception e){
            throw new IllegalArgumentException();
        }

        return imageReader;
    }
}
