package com.gigamachim.APIvsAPIBack;

import com.gigamachim.APIvsAPIBack.Util.ImageDraw;

import java.awt.image.BufferedImage;

public class ImageDrawTest {

    public static void main(String[] args) {

        ImageDraw imageDraw = new ImageDraw();
        BufferedImage image = imageDraw.loadImage("src/main/resources/img/hello.jpg");//filepath

        int x = image.getWidth();
        int y = image.getHeight();

        System.out.println("width = " + x + ", height = " + y);


    }
}
