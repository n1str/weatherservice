package n1str.client.service;

import n1str.Config;

public class WeatherAvgTemp {
    public static void getAvgTemp(String getLat, String getLon, String getLimit) {

        String responseData = WeatherData.getData(getLat, getLon, getLimit);
        String daySectionKey = Config.DAY_SECTION_KEY;
        String tempAvgKey = Config.TEMP_AVG_KEY;

        int daysLimit = Integer.parseInt(getLimit);
        double totalTemp = 0;
        int count = 0;


        int daySectionIndex = responseData.indexOf(daySectionKey);

        while (daySectionIndex != -1) {
            int tempAvgIndex = responseData.indexOf(tempAvgKey, daySectionIndex);

            if (tempAvgIndex != -1) {
                int startIndex = tempAvgIndex + tempAvgKey.length();
                int endIndex = responseData.indexOf(",", startIndex);
                String tempAvgValue = responseData.substring(startIndex, endIndex).trim();

                try {
                    totalTemp += Double.parseDouble(tempAvgValue);
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка при преобразовании температуры: " + tempAvgValue);
                }
            }

            daySectionIndex = responseData.indexOf(daySectionKey, daySectionIndex + daySectionKey.length());
        }

        if (count > 0) {
            double avgTemp = totalTemp / count;
            System.out.println("Средняя температура за " + count + " дней: " + Math.round(avgTemp) + "°C");
        } else {
            System.out.println("Не удалось найти значения temp_avg в секции 'day'");
        }
    }
}
