package utils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class FileUtils {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    // parse csv file with lines of only 2 columns each e.g. size|price; 1 first column is key, 2nd column is value
    public HashMap<String, String> parse2Columns(String filePath) {
        HashMap<String, String> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //skip the header line
            bufferedReader.readLine();
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] parts = input.trim().split("\\|");
                output.put(parts[0], parts[1]);
            }
        } catch (Exception e) {
            System.out.println("File cannot be read. Please double check FilePath!\nError: " + e.toString());
        }
        return output;
    }

    // parse csv file with lines of multiple columns each e.g. size|basePrice|meat|extraMeat|cheese|extraCheese
    // HashMap 0: each column number is key, name of each column header is value
    // HashMap of n line (header line not included): each column header is a key, each column value is a value
    // HashMap output: each line's value of first column (header line not included) is a key, a hashmap of that line created above is a value
    public HashMap<String, HashMap<String, Double>> parseMultipleColumns(String filePath) {
        HashMap<String, String> headerField = new HashMap<>();
        HashMap<Integer, HashMap<String, Double>> priceChartMap = new HashMap<>();
        HashMap<String, HashMap<String, Double>> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            //parse header line
            int currentHeaderPart = 0;
            String partName;
            String partContent;
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

    public String getFileName(LocalDateTime orderDateTime){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = orderDateTime.format(format);
        String fileType = ".txt";
        return fileName + fileType;
    }
    public void createFile(LocalDateTime orderDateTime){
        String folderPath = "receipts";
        String fullPath = folderPath + File.separator + getFileName(orderDateTime);
        File receipt = new File(fullPath);
        try{
            FileWriter fileWriter = new FileWriter(receipt);
        }catch (Exception e){
            System.out.println("Error: " + e.toString());
        }
    }

    public void writeToFile(LocalDateTime orderDateTime, String orderInfo){
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(getFileName(orderDateTime)));
            bufferedWriter.write(orderInfo);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("Error: " + e.toString());
        }
    }
}
