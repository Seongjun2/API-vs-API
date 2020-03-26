package com.gigamachim.APIvsAPIBack.Util;

import com.google.gson.*;

public class JsonConfig {

    private JsonObject jsonObject;
    private JsonArray predictions;
    private JsonObject elements;
    private int numDetections;
    private JsonArray detectionClasses;
    private JsonArray detectionNames;
    private JsonArray detectionScores;
    private JsonArray detectionBoxes;

    public JsonConfig(String JsonStr) {
        JsonParser jsonParser = new JsonParser();
        this.jsonObject = (JsonObject)jsonParser.parse(JsonStr);
        this.predictions = (JsonArray)jsonObject.get("predictions");
        this.elements = (JsonObject) predictions.get(0);
        this.numDetections = elements.get("num_detections").getAsInt();
        this.detectionClasses = (JsonArray) elements.get("detection_classes");
        this.detectionNames = (JsonArray)elements.get("detection_names");
        this.detectionScores = (JsonArray)elements.get("detection_scores");
        this.detectionBoxes = (JsonArray)elements.get("detection_boxes");
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public JsonArray getPredictions() {
        return predictions;
    }

    public JsonObject getElements() {
        return elements;
    }

    public int getNumDetections() {
        return numDetections;
    }

    public JsonArray getDetectionClasses() {
        return detectionClasses;
    }

    public JsonArray getDetectionNames() {
        return detectionNames;
    }

    public JsonArray getDetectionScores() {
        return detectionScores;
    }

    public JsonArray getDetectionBoxes() {
        return detectionBoxes;
    }

    public String jsonBeautify(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(jsonObject);

        return prettyJson;
    }
}
