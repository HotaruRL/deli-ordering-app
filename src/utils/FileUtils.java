package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FileUtils {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    // parse csv file with lines of only 2 values each e.g. size|price
    public HashMap<String, Double> parse2Values(String filePath) {
        HashMap<String, Double> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //skip the header line
            bufferedReader.readLine();
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] parts = input.trim().split("\\|");
                output.put(parts[0], Double.parseDouble(parts[1]));
            }
        } catch (Exception e) {
            System.out.println("File cannot be read. Please double check FilePath!\nError: " + e.toString());
        }
        return output;
    }

    // parse csv file with lines of multiple values each e.g. size|basePrice|meat|extraMeat|cheese|extraCheese
    public HashMap<String, HashMap<String, Double>> parseMultipleValues(String filePath) {
        HashMap<String, String> headerField = new HashMap<>();
        HashMap<Integer, HashMap<String, Double>> priceChartMap = new HashMap<>();
        HashMap<String, HashMap<String, Double>> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //parse header line
            int currentHeaderPart = 0;
            String partName;
            String partContent = "";
            String[] headerParts = bufferedReader.readLine().trim().split("\\|");
            for (String s : headerParts){
                partName = "part" + currentHeaderPart;
                partContent = s;
                headerField.put(partName, partContent);
                currentHeaderPart++;
            }
            // parse pricing lines

            int priceChartID = 0;
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] valueParts = input.trim().split("\\|");
                HashMap<String, Double> currentPriceChart = new HashMap<>();
                int partNumber = 0;
                for (String s : valueParts) {
                    currentPriceChart.put(headerField.get("part" + partNumber), Double.parseDouble(valueParts[partNumber]));
                    partNumber++;
                }
                priceChartMap.put(priceChartID, currentPriceChart);
                output.put(valueParts[0], priceChartMap.get(priceChartID));
                priceChartID++;
            }
        } catch (Exception e) {
            System.out.println("File cannot be read. Please double check FilePath!\nError: " + e.toString());
        }
        return output;
    }
}
