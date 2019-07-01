package slackTest;

import POJO.ReactionPOJO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

@RestController
public class ActionControl {

    @RequestMapping(value = "/actions", produces = "application/json")
    @ResponseBody
    public void getActions(HttpEntity<String> httpEntity) throws IOException {

        System.out.print(httpEntity.getBody());
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(String.valueOf(httpEntity.getBody()));
        ReactionPOJO reaction = gson.fromJson(object, ReactionPOJO.class);
        if (reaction.getEvent().getReaction().equals("+1::skin-tone-4")){
            System.out.print("inside");

            URL urlObj = new URL("https://hooks.slack.com/services/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");
            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();
            httpCon.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            httpCon.setRequestProperty("Accept", "application/json");
            httpCon.setConnectTimeout(5000);
            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");

            String json = "{'text':'Message liked'}";

            DataOutputStream wr = new DataOutputStream(httpCon.getOutputStream());
            wr.writeBytes(json);
            wr.flush();
            wr.close();
            int responseCode = httpCon.getResponseCode();
            System.out.println("nSending 'POST' request to URL : " + urlObj);
            System.out.println("Post Data : " + json);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();

            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();

            //printing result from response
            System.out.println(response.toString());
        }

    }

}
