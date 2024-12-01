package ua.edu.ucu.apps.Task3;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class OpenAIReader {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private static final String API_KEY = "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";

    public static String getCompanyDescription(String companyName) throws IOException {
        JSONArray messages = new JSONArray();
        messages.put(new JSONObject()
                .put("role", "system")
                .put("content", "You are a helpful assistant."));

        messages.put(new JSONObject()
                .put("role", "user")
                .put("content", "Provide a short description of the company " + companyName));

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("model", "gpt-3.5-turbo");
        jsonBody.put("messages", messages);
        jsonBody.put("max_tokens", 100);

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

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                JSONObject responseBody = new JSONObject(response.body().string());
                return responseBody.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content")
                        .trim();
            } else {
                throw new IOException("OpenAI request failed: " + response.code());
            }
        }
    }
}
