package slackTest;

import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherControl {

    @RequestMapping("/weather")
    @ResponseBody
    public String getWeather(HttpEntity<String> httpEntity)  {
        String[] payload = httpEntity.getBody().split("&");
        String city="";
        for (String c: payload){
            if (c.contains("text=")){
                city=c;
                break;
            }
        }
        Weather w = new Weather(city.substring(5));
        return w.getContent();
    }
}