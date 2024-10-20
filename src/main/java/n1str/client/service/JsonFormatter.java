package n1str.client.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonFormatter {
    public static void jsonToNormal(String weatherDataJSON) {

        String jsonString = weatherDataJSON;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String formattedJson = gson.toJson(gson.fromJson(jsonString, Object.class));
        System.out.println(formattedJson);
    }
}