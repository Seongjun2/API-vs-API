package com.gigamachim.APIvsAPIBack.Util;

import com.google.gson.JsonArray;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageDraw {

    static int black = new Color(0,0,0).getRGB();
    static int yellow = new Color(255,204,0).getRGB();
    static int green = new Color(102,255,51).getRGB();
    static int pink = new Color(255,0,255).getRGB();
    static int blue = new Color(0,0,204).getRGB();
    static int red = new Color(255,0,0).getRGB();

    static int[] colors = {black, yellow, green, pink, blue, red};

    public BufferedImage loadImage(String url){
        BufferedImage image = null;

        try{
            image = ImageIO.read(new File(url));
        }catch (Exception e){
            e.printStackTrace();
        }
        return image;
    }

    public void drawSquare(BufferedImage image, JsonArray detectionBoxes){

        //image size
        int width = image.getWidth();
        int height = image.getHeight();

        System.out.println("Image Size = Width : " + width + ", Height : " + height);
        //객체들의 좌표

        for (int i = 0; i < detectionBoxes.size(); i++) {
            JsonArray box = (JsonArray)detectionBoxes.get(i);

            //double 형의 좌표를 int 형으로 바꿔줌
            // 0~1 범위를 0~이미지 크기 까지로 변환
            int minHeight = (int)(box.get(0).getAsDouble()*height)-1;
            int minWidth = (int)(box.get(1).getAsDouble()*width)-1;
            int maxHeight = (int)(box.get(2).getAsDouble()*height)-1;
            int maxWidth = (int)(box.get(3).getAsDouble()*width)-1;

            if(minHeight == -1) minHeight++;
            if(minWidth == -1) minWidth++;

            System.out.println("Width : " +minWidth + " ~ " + maxWidth);
            System.out.println("Height : " +minHeight + " ~ " + maxHeight);

            //세로 줄
            for (int h = maxHeight; h >= minHeight ; h--) {
                image.setRGB(minWidth, h, colors[i%6]);
                image.setRGB(maxWidth, h, colors[i%6]);
            }
            //가로 줄
            for (int w = maxWidth; w >= minWidth ; w--) {
                image.setRGB(w, minHeight, colors[i%6]);
                image.setRGB(w, maxHeight, colors[i%6]);
            }
        }
    }

    public void fileOut(BufferedImage image, String formatName, String pathName){
        try{
            ImageIO.write(image, formatName, new File(pathName));
            System.out.println("Success image file out");
            //example
            //ImageIO.write(image, "jpg", new File("hello1.jpg"));
        }catch(Exception e){
            System.out.println("Fail image file out");
            e.printStackTrace();
        }
    }

}
