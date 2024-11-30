package ua.edu.ucu.apps.Task3;

import okhttp3.*;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class OpenAIExample {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";

    public static void main(String[] args) {
        JSONArray messages = new JSONArray();

        // System message (context or instructions)
        messages.put(new JSONObject()
                .put("role", "system")
                .put("content", "You are a helpful assistant."));

        // User message (actual user query)
        messages.put(new JSONObject()
                .put("role", "user")
                .put("content", "Explain how Java memory management works."));

        // Set up the JSON body for the request
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("model", "gpt-3.5-turbo");
        jsonBody.put("messages", messages);
        jsonBody.put("max_tokens", 100);

        // Create the request
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(
                jsonBody.toString(),
                MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(API_URL)
                .header("Authorization", "Bearer " + API_KEY)
                .post(body)
                .build();

        // Send the request
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                System.out.println("Response: " + response.body().string());
            } else {
                System.out.println("Request failed: " + response.code());
                System.out.println(response.body().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
