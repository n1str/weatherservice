package n1str.client.service;

import n1str.Config;

public class WeatherCurrentTemp {
    public static void getTemp(String getLat, String getLon) {

        String responseData = WeatherData.getData(getLat, getLon, "1");
        String currentTempKey = Config.CURRENT_TEMP_KEY;

        int currentTempIndex = responseData.indexOf(currentTempKey);

        if (currentTempIndex != -1) {
            int startIndex = currentTempIndex + currentTempKey.length();
            int endIndex = responseData.indexOf(",", startIndex);
            String currentTempValue = responseData.substring(startIndex, endIndex).trim();
            System.out.println("Текущая температура: " + currentTempValue + "°C");
        } else {
            System.out.println("Нет данных о текущей температуре");
        }
    }
}
