import java.io.*;
import java.util.*;

public class WeatherModel {

    private static final double HEAT_WARNING_TEMP = 30.0; 
    private static final int HUMIDITY_WARNING = 70;      
    private static final int WIND_WARNING = 20;           

    public static void main(String[] args) {
        String inputFile = "weather_data.txt";  

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            System.out.println("Weather Report:\n");

            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                if (parts.length != 4) continue;

                String date = parts[0];
                double temp = Double.parseDouble(parts[1]);
                int humidity = Integer.parseInt(parts[2]);
                int wind = Integer.parseInt(parts[3]);

        
                System.out.println("Date: " + date);
                System.out.println("  Temperature: " + temp + " °C");
                System.out.println("  Humidity: " + humidity + " %");
                System.out.println("  Wind Speed: " + wind + " km/h");

                if (temp >= HEAT_WARNING_TEMP) {
                    System.out.println("   Heat Warning");
                }
                if (humidity >= HUMIDITY_WARNING) {
                    System.out.println("   High Humidity");
                }
                if (wind >= WIND_WARNING) {
                    System.out.println("   Strong Winds");
                }

                System.out.println(); 
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
