package models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TrafficChecker {

    private static final String API_KEY = "YOUR_API_KEY";

    public static void main(String[] args) throws IOException {
        String startPoint = "Start address";
        String endPoint = "End address";
        String response = getTrafficData(startPoint, endPoint);
        System.out.println(response);

        analyzeTraffic(response);
    }

    public static String getTrafficData(String startPoint, String endPoint) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/directions/json?origin=" + startPoint +
                "&destination=" + endPoint + "&key=" + API_KEY;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static void analyzeTraffic(String response) {
        JSONObject jsonResponse = new JSONObject(response);

        String status = jsonResponse.getString("status");
        if (!status.equals("OK")) {
            System.out.println("Помилка: " + status);
            return;
        }

        JSONArray routes = jsonResponse.getJSONArray("routes");
        JSONObject route = routes.getJSONObject(0);
        JSONArray legs = route.getJSONArray("legs");
        JSONObject leg = legs.getJSONObject(0);

        JSONArray steps = leg.getJSONArray("steps");
        for (int i = 0; i < steps.length(); i++) {
            JSONObject step = steps.getJSONObject(i);
            String trafficStatus = step.optString("traffic_condition", "unknown");

            if (!trafficStatus.equals("unknown")) {
                String instruction = step.getString("html_instructions");
                System.out.println("Інструкція: " + instruction);
                System.out.println("Статус трафіку: " + trafficStatus);
            }
        }
    }
}
