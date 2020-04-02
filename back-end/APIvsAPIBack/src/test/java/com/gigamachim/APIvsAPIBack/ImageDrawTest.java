package com.gigamachim.APIvsAPIBack;

import com.gigamachim.APIvsAPIBack.Util.ImageDraw;
import com.gigamachim.APIvsAPIBack.Util.JsonConfig;
import com.gigamachim.APIvsAPIBack.Util.ObjectDetectionAPI;
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

        String fileName = "cat.jpg";
        String filePath = "src/main/resources/img/"+fileName;

        ObjectDetectionAPI api = new ObjectDetectionAPI();
        String jsonString = api.request(filePath);

//        String jsonString = "{\"predictions\": [{\"num_detections\": 10, \"detection_classes\": [1.0, 1.0, 1.0, 1.0, 73.0, 1.0, 1.0, 65.0, 76.0, 65.0], \"detection_names\": [\"person\", \"person\", \"person\", \"person\", \"laptop\", \"person\", \"person\", \"bed\", \"keyboard\", \"bed\"], \"detection_scores\": [0.975995, 0.928603, 0.914046, 0.879579, 0.752147, 0.586898, 0.548609, 0.46889, 0.40082, 0.387301], \"detection_boxes\": [[0.129505, 0.474313, 0.947161, 0.975323], [0.230775, 0.234226, 0.970481, 0.93966], [0.204904, 0.00132984, 0.918014, 0.398666], [0.137909, 0.0, 0.963646, 0.797721], [0.0, 0.266897, 0.477342, 0.85637], [0.00259084, 0.546077, 0.807436, 1.0], [0.0183261, 0.0448731, 0.849227, 0.974884], [0.770602, 0.204509, 0.996092, 0.762467], [0.0, 0.377416, 0.292548, 0.794378], [0.691064, 0.0561362, 0.995949, 0.885257]]}]}";
//        String jsonString = "{\"predictions\": [{\"num_detections\": 1, \"detection_classes\": [1.0], \"detection_names\": [\"person\"], \"detection_scores\": [0.999369], \"detection_boxes\": [[0.141612, 0.283656, 1.0, 0.793158]]}]}";

        JsonConfig jsonConfig = new JsonConfig(jsonString);

        JsonArray detectionBoxes = jsonConfig.getDetectionBoxes();


        ImageDraw imageDraw = new ImageDraw();
        BufferedImage image = imageDraw.loadImage(filePath);//filepath

        imageDraw.drawSquare(image, detectionBoxes);

        imageDraw.fileOut(image, "jpg", "resultImage/"+fileName);

        /*

        hello.jpg -> width : 320, height : 213
         */
    }
}
