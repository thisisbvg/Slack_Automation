package slackTest;
import java.net.*;
import java.io.*;

import POJO.WeatherPOJO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Weather {

    private final String city;

    public Weather(String city) {
        this.city = city;
    }

    public String getContent() {
        StringBuffer response = new StringBuffer();
        try{
            String token= "b6907d289e10d714a6e88b30761fae22";
            String city = URLEncoder.encode(this.city, "UTF-8");
            String buildUrl = "https://openweathermap.org/data/2.5/weather?q=" + city+ ",US&appid="+ token;
            URL url = new URL(buildUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            System.out.println("Response Code : " + response);
            in.close();
            //more code goes here
        }catch(Exception ex){
//do exception handling here
        }
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(String.valueOf(response));
        WeatherPOJO weather = gson.fromJson(object, WeatherPOJO.class);

        return "Weather in "+ this.city.replace("+"," ")+ " is: "+ weather.getMain().getTemp().toString() + " degree C";
    }
}