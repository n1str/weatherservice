package n1str.client.menu;
import n1str.client.service.JsonFormatter;
import n1str.client.service.WeatherAvgTemp;
import n1str.client.service.WeatherCurrentTemp;
import n1str.client.service.WeatherData;

import java.util.Scanner;
public class ScriptMenuLogic {
    public static void getAvgTemp(Scanner scanner, String getLat, String getLon) {

        System.out.println("Укажите лимит: ");
        String getLimit = scanner.nextLine();

        String weatherDataJson = WeatherData.getData(getLat, getLon, getLimit);
        JsonFormatter.jsonToNormal(weatherDataJson);

        ScriptMenuInfo.visualSplitter();
        WeatherAvgTemp.getAvgTemp(getLat,getLon, getLimit);

        ScriptMenuInfo.script();
    }

    public static void getFactTemp(Scanner scanner, String getLat, String getLon) {

        String weatherDataJson = WeatherData.getData(getLat, getLon, "1");
        JsonFormatter.jsonToNormal(weatherDataJson);

        ScriptMenuInfo.visualSplitter();
        WeatherCurrentTemp.getTemp(getLat,getLon);
        ScriptMenuInfo.script();

    }
}
