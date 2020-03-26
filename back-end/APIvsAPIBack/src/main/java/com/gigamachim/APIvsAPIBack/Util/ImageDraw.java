package com.gigamachim.APIvsAPIBack.Util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageDraw {

    public static BufferedImage loadImage(String url){
        BufferedImage image = null;

        try{
            image = ImageIO.read(new File(url));
        }catch (Exception e){
            e.printStackTrace();
        }
        return image;
    }

}
