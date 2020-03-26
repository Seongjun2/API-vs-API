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
            System.out.println( (i+1) +" "+firstList.get(i));
        }

        for (int w = 0; w < x; w++) {
            for (int h = 0; h < y; h++) {
                image.setRGB(firstList.get(0).getAsInt()*320, firstList.get(1).getAsInt()*213, black);
            }
        }


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
