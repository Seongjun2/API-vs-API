package com.gigamachim.APIvsAPIBack.TestPack;
/*
    요청 바디
    ______________________________________________________________
    | 필드명|  필수 여부 |   타입  |     제약 사항        |   설명       |
    | img |   yes    | Binary | 최대 2MB 이미지 지원   | 분석할 이미지  |
    ______________________________________________________________


    요청 예시

    [HTTP Request Header]
    POST /vision-obj/v1/detect HTTP/1.1
    Host: naveropenapi.apigw.ntruss.com
    Content-Type: multipart/form-data; boundary={boundary-text}
    X-NCP-APIGW-API-KEY-ID: {앱 등록 시 발급받은 Client ID}
    X-NCP-APIGW-API-KEY: {앱 등록 시 발급 받은 Client Secret}
    Content-Length: 96703

    --{boundary-text}
    Content-Disposition: form-data; name="image"; filename="test.jpg"
    Content-Type: image/jpeg

    {image binary data}
    --{boundary-text}--

    */

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class ObjectDetectionAPI {

    StringBuffer reqStr = new StringBuffer();
    final String clientId = "tayx9y3qhl";
    final String client_secret = "nDhUmCucfswlzH2AqiCsNrtKehSPpawTDBcJIbxh";

    public void request(){

        try{
            String paramName = "image";//파라미터 명
            String imgFile = "src/main/resources/img/img1.jpg";
            File uploadFile = new File(imgFile);
            System.out.println(uploadFile.getAbsolutePath());
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect"; // 객체 인식

            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);

            //multipart request
            String boundary = "---" + System.currentTimeMillis() + "---";
            con.setRequestProperty("Content-type", "multipart/form-data; boundary" + boundary);
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);

            OutputStream outputStream = con.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
            String LINE_FEED = "\r\n";

            //file 추가
            String fileName = uploadFile.getName();
            writer.append("---" + boundary).append(LINE_FEED);
            writer.append("Content-Disposition: form-data; name=\"" + paramName + "\"; filename=\"" + fileName + "\"").append(LINE_FEED);
            writer.append("Content-type: " + URLConnection.guessContentTypeFromName(fileName)).append(LINE_FEED);
            writer.append(LINE_FEED);
            writer.flush();

            FileInputStream inputStream = new FileInputStream(uploadFile);
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while((bytesRead= inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,bytesRead);
            }
            outputStream.flush();
            inputStream.close();
            writer.append(LINE_FEED).flush();
            writer.append("--"+boundary+"--").append(LINE_FEED);
            writer.close();

            BufferedReader br = null;
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {//정상
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            else{
                System.out.println("error. responseCode = " + responseCode);
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            }
            String inputLine;
            if(br != null){
                StringBuffer response = new StringBuffer();
                while((inputLine = br.readLine()) != null){
                    response.append(inputLine);
                }

                br.close();
                System.out.println(response.toString());
            }
            else{
                System.out.println("error");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
