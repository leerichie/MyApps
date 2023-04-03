package weather;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Weather {
    public void weatherLogic() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Prompt the user for the location
        System.out.println("*----------- Ash's Weather App ----------*");
        System.out.println("Enter location (city name, country code): ");
        String location = reader.readLine();
        System.out.println("Enter unit of temperature:");
        String tempUnit = reader.readLine();
        String tempConv = tempUnit.toLowerCase();
        if (tempConv.equals("celsius") || tempConv.equals("c")) {
            tempConv = "units=metric";
        } else if (tempConv.equals("fahrenheit") || tempConv.equals("f")) {
            tempConv = "units=imperial";
        } else {
            tempConv = "";
        }

        // Set up the API URL and API key
        String apiKey = "79f4d0dd8d46dedb331b5a20527be020";
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&" + tempConv;

        // Make an HTTP request to the API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse the JSON response using GSON
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);

        // Extract the relevant weather data
        double temperature = jsonObject.getAsJsonObject("main").get("temp").getAsDouble();
        double humidity = jsonObject.getAsJsonObject("main").get("humidity").getAsDouble();
        double windSpeed = jsonObject.getAsJsonObject("wind").get("speed").getAsDouble();

        // Capitalise city first initial and country code
        String[] locationArray = location.split(", ");
        String city = locationArray[0].substring(0, 1).toUpperCase() + locationArray[0].substring(1);
        String countryCode = locationArray[1].toUpperCase();
        String formattedLocation = city + ", " + countryCode;

        // Display the weather data
        System.out.println("Weather in " + formattedLocation + ":");
        if (tempConv.equals("units=metric")){
            System.out.println("Temperature: " + temperature + "ºC");
        } else if (tempConv.equals("units=imperial")) {
            System.out.println("Temperature: " + temperature + "ºF");
        } else {
            System.out.println("Temperature: " + temperature + "K");
        }
        System.out.println("Humidity: " + humidity + "%");
        System.out.println("Wind Speed: " + windSpeed + " m/s");

        System.out.println("*-----------------------------------*");
        System.out.println("Would you like to search again? (y/n)");
        String searchAgain = reader.readLine();
        if (searchAgain.equals("y")){
            weatherLogic();
        } else {
            System.out.println("Goodbye :)");
        }
    }
}
