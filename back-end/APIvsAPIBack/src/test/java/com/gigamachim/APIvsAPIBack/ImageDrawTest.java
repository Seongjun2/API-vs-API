package com.gigamachim.APIvsAPIBack;

import com.gigamachim.APIvsAPIBack.Util.ImageDraw;
import com.gigamachim.APIvsAPIBack.Util.JsonConfig;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class ImageDrawTest {
    static int black = new Color(0,0,0).getRGB();

    public static void main(String[] args) {

        ImageDraw imageDraw = new ImageDraw();
        BufferedImage image = imageDraw.loadImage("src/main/resources/img/hello.jpg");//filepath

        int x = image.getWidth();
        int y = image.getHeight();

        System.out.println("width = " + x + ", height = " + y);


        String jsonString = "{\"predictions\": [{\"num_detections\": 1, \"detection_classes\": [1.0], \"detection_names\": [\"person\"], \"detection_scores\": [0.999369], \"detection_boxes\": [[0.141612, 0.283656, 1.0, 0.793158]]}]}";
        JsonConfig jsonConfig = new JsonConfig();
        JsonObject jsonObject = jsonConfig.StringToJson(jsonString);

        JsonArray predictions = (JsonArray)jsonObject.get("predictions");

        JsonObject elements = (JsonObject) predictions.get(0);
        int numDetections = elements.get("num_detections").getAsInt();
        JsonArray detectionClasses = (JsonArray) elements.get("detection_classes");
        JsonArray detectionNames = (JsonArray)elements.get("detection_names");
        JsonArray detectionScores = (JsonArray)elements.get("detection_scores");
        JsonArray detectionBoxes = (JsonArray)elements.get("detection_boxes");

        JsonArray firstList = (JsonArray)detectionBoxes.get(0);

        for (int i = 0; i < firstList.size(); i++) {
            System.out.println(firstList.get(i));
        }

//        int a = (int)(firstList.get(0).getAsDouble()*320);
//        int b = (int)(firstList.get(1).getAsDouble()*213);
//        int c = (int)(firstList.get(2).getAsDouble()*320);
//        int d = (int)(firstList.get(3).getAsDouble()*213);

        int a = (int)(firstList.get(0).getAsDouble()*213)-1;
        int b = (int)(firstList.get(1).getAsDouble()*320)-1;
        int c = (int)(firstList.get(2).getAsDouble()*213)-1;
        int d = (int)(firstList.get(3).getAsDouble()*320)-1;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);


        for (int w = c; w >= a ; w--) {
            image.setRGB(b, w, black);
        }

        for (int w = c; w >= a ; w--) {
            image.setRGB(d, w, black);
        }

        for (int h = d; h >= b ; h--) {
            image.setRGB(h, a, black);
        }

        for (int h = d; h >= b ; h--) {
            image.setRGB(h, c, black);
        }

        //file 로 저장.
        try{
            ImageIO.write(image, "jpg", new File("hello1.jpg"));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println();

        /*

        hello.jpg -> width : 320, height : 213
         */
    }
}
