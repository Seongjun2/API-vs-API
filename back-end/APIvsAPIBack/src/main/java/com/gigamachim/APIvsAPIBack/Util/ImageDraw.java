package com.gigamachim.APIvsAPIBack.Util;

import com.google.gson.JsonArray;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageDraw {

    static int black = new Color(0,0,0).getRGB();

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

            System.out.println("Width : " +minWidth + " ~ " + maxWidth);
            System.out.println("Height : " +minHeight + " ~ " + maxHeight);

            //세로 줄(왼쪽)
            for (int h = maxHeight; h >= minHeight ; h--) {
                image.setRGB(minWidth, h, black);
            }
            //세로 줄(오른쪽)
            for (int h = maxHeight; h >= minHeight ; h--) {
                image.setRGB(maxWidth, h, black);
            }
            //가로 줄(아래)
            for (int w = maxWidth; w >= minWidth ; w--) {
                image.setRGB(w, minHeight, black);
            }
            //가로 줄(위)
            for (int w = maxWidth; w >= minWidth ; w--) {
                image.setRGB(w, maxHeight, black);
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
