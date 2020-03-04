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

import java.io.File;
import java.net.URL;

public class APITest {

    StringBuffer reqStr = new StringBuffer();
    final String clientId = "tayx9y3qhl";
    final String api_client_secret = "nDhUmCucfswlzH2AqiCsNrtKehSPpawTDBcJIbxh";

    public void request(){

        try{
            String paramName = "img1.jpg";
            String imgFile = "../../../../resources/";
            File uploadFile = new File(imgFile);
            String apiURL = "https://naveropenapi.apigw.ntruss.com/vision-obj/v1/detect"; // 객체 인식
            URL url = new URL(apiURL);
            
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

}
