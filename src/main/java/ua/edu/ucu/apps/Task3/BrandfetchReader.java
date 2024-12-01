package ua.edu.ucu.apps.Task3;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BrandfetchReader {
    private static final String API_KEY = "1Z0pSI7TwYmF3OpDsUN6GK8/SfaxIycVmbJ1lGjhGe8=";

    public static Company getCompanyInfo(String domain) throws IOException {
        URL url = new URL("https://api.brandfetch.io/v2/company/" + domain);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
        connection.connect();

        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);

        String name = jsonObject.optString("name");
        String logo = jsonObject.optJSONObject("logos")
                .optJSONArray("icons").getJSONObject(0).optString("url");
        String description = jsonObject.optString("description");

        return new Company(name, description, logo);
    }
}
