package weather;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherPL {

        public void weatherLogicPL() throws IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            // Prompt the user for the location
            System.out.println("*----------- Ash's Apka Pogodowa ----------*");
            System.out.println("Wpisz lokalizację (nazwa miasta, kod kraju): ");
            String location = reader.readLine();
            System.out.println("Wpisz jednostkę temperatury: (c/f/k)");
            String tempUnit = reader.readLine();
            String tempConv = tempUnit.toLowerCase();
            if (tempConv.equals("celsjusz") || tempConv.equals("c")) {
                tempConv = "units=metric";
            } else if (tempConv.equals("fahrenheita") || tempConv.equals("f")) {
                tempConv = "units=imperial";
            } else {
                tempConv = "";
            }

            // Set up the API URL and API key
            String apiKey = "79f4d0dd8d46dedb331b5a20527be020";
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&lang=pl" + "&appid=" + apiKey + "&" + tempConv;

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
            System.out.println("Pogoda w " + formattedLocation + ":");
            if (tempConv.equals("units=metric")){
                System.out.println("Temperature: " + temperature + "ºC");
            } else if (tempConv.equals("units=imperial")) {
                System.out.println("Temperatura: " + temperature + "ºF");
            } else {
                System.out.println("Temperatura: " + temperature + "K");
            }
            System.out.println("Wilgotnosc: " + humidity + "%");
            System.out.println("Predkosc wiatru: " + windSpeed + " m/s");

            System.out.println("*-----------------------------------*");
            System.out.println("Szukac ponownie? (t/n)");
            String searchAgain = reader.readLine();
            if (searchAgain.equals("t")){
                weatherLogicPL();
            } else {
                System.out.println("Goodbye :)");
            }
        }
    }
