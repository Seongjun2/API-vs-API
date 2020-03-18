package com.gigamachim.APIvsAPIBack.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonConfig {

    public JsonObject StringToJson(String JsonStr) {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(JsonStr);

        return jsonObject;
    }

    public String jsonBeautify(String JsonStr){
        JsonObject jsonObject = StringToJson(JsonStr);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(jsonObject);

        return prettyJson;
    }
}
