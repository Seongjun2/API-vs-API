package com.gigamachim.APIvsAPIBack;

import com.gigamachim.APIvsAPIBack.Util.ObjectDetectionAPI;

public class APITest {
    public static void main(String[] args) {
        ObjectDetectionAPI objectDetectionAPI = new ObjectDetectionAPI();

        String fileName = "hello.jpg";
        String filePath = "src/main/resources/img/"+fileName;
        objectDetectionAPI.request(filePath);
    }
}
