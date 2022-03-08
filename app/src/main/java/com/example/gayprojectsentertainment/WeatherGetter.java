package com.example.gayprojectsentertainment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class WeatherGetter {
    private static double temp_c;
    private static double feelslike_c;
    private static double wind_kph;

    private static double temp_f;
    private static double feelslike_f;
    private static double wind_mph;

    private static String condition;
    private static boolean correct;


    private static void parse(String ResponseBody)
    {
        try {
            JSONObject weather = new JSONObject(ResponseBody);
            JSONObject current = weather.getJSONObject("current");

            // metric system
            temp_c = current.getDouble("temp_c");
            feelslike_c = current.getDouble("feelslike_c");
            wind_kph = current.getDouble("wind_kph");


            // gay system
            temp_f = current.getDouble("temp_f");
            feelslike_f = current.getDouble("feelslike_f");
            wind_mph = current.getDouble("wind_mph");

            // wtf man
            condition = current.getJSONObject("condition").getString("text");

            correct = true;
        }
        catch (JSONException ex) {
            correct = false;
        }
    }

    public static String getWeatherMetric(String Response) {
        parse(Response);
        if (correct) {
            return "Now is " + condition + ".\n" +
                    "Temperature: " + temp_c + "\n" +
                    "Feels like: " + feelslike_c + "\n" +
                    "Wind speed: " + wind_kph + "kph.";
        }
        return "There is no such city";
    }
}
