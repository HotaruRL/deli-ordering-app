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
        HashMap<String, Double> componentChart = new HashMap<>();
        HashMap<String, HashMap<String, Double>> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //parse header line
            HashMap<String, String> headerField = new HashMap<>();
            int currentHeaderPart = 0;
            String partName;
            String partContent = "";
            String[] headerParts = bufferedReader.readLine().trim().split("\\|");
            for (String s : headerParts){
                partName = "part" + currentHeaderPart;
                partContent = s;
                headerField.put(partName, partContent);
            }
            // parse pricing lines
            int partNumber = 0;
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] parts = input.trim().split("\\|");
                output.put(parts[0], componentChart.put(headerParts[partNumber],(parts[partNumber++])));
            }
        } catch (Exception e) {
            System.out.println("File cannot be read. Please double check FilePath!\nError: " + e.toString());
        }
        return output;
    }
}
