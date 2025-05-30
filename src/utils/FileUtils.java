package utils;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FileUtils {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    // parse csv file with a simple 1 line list, delimiter: comma (|)
    public ArrayList<String> parse1Line (String filepath){
        ArrayList<String> output = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filepath));
            String input;
            while (((input) = bufferedReader.readLine()) != null){
                String[] parts = input.trim().split("\\|");
                output.addAll(Arrays.asList(parts));
            }
        }catch (Exception e){
            System.out.println("File cannot be read. Please double check FilePath!\nError: " + e.toString());
        }
        return output;
    }

    // parse csv file with lines of only 2 columns each e.g. size|price; 1 first column is key, 2nd column is value, delimiter: pipe (|)
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

    // parse csv file with lines of only 2 columns each e.g. topping type|options; 1 first column is key, 2nd column is value
    // parse 2nd column value into an arraylist to access each of the value (options)
    // delimiters: pipe (|) then comma (,)
    public HashMap<String, ArrayList<String>> loadList(String filePath){
        HashMap<String, String> rawToppingsChart = parse2Columns(filePath);
        HashMap<String, ArrayList<String>> toppingChart = new HashMap<>();
        for (HashMap.Entry<String, String> entry : rawToppingsChart.entrySet()) {
            String type = entry.getKey();
            String option = entry.getValue();
            String[] eachOption = option.split(",");
            ArrayList<String> toppingOptions = new ArrayList<>(Arrays.asList(eachOption));
            toppingChart.put(type, toppingOptions);
        }
        return toppingChart;
    }

    // parse csv file with lines of multiple columns each e.g. size|basePrice|meat|extraMeat|cheese|extraCheese
    // delimiter: pipe (|)
    // HashMap 0: each column number is key, name of each column header is value
    // HashMap of n line (header line not included): each column header is a key, each column value is a value
    // HashMap output: each line's value of first column (header line not included) is a key, a hashmap of that line created above is a value
    public HashMap<String, HashMap<String, String>> parseMultipleColumns(String filePath) {
        HashMap<String, String> headerField = new HashMap<>();
        HashMap<Integer, HashMap<String, String>> priceChartMap = new HashMap<>();
        HashMap<String, HashMap<String, String>> output = new HashMap<>();
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
                HashMap<String, String> currentPriceChart = new HashMap<>();
                int partNumber = 0;
                for (String s : valueParts) {
                    currentPriceChart.put(headerField.get("part" + partNumber), valueParts[partNumber]);
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

    // create an ArrayList of just keys from the hashmap of keys and their list of options
    public ArrayList<String> getJustKeys(HashMap<String, HashMap<String, String>> chart){
        ArrayList<String> justKeysList = new ArrayList<>();
        for (HashMap.Entry<String, HashMap<String, String>> entry : chart.entrySet()) {
            String type = entry.getKey();
            justKeysList.add(type);
        }
        return justKeysList;
    }

    // create a filename string from a LocalDateTime value
    public String getFileName(LocalDateTime orderDateTime){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String fileName = orderDateTime.format(format);
        String fileType = ".txt";
        return fileName + fileType;
    }

    // create a new file into the folder in [folderPath]
    // using the getFileName to name the new file from a LocalDateTime value
    // write the order info into the file
    public void writeToFile(LocalDateTime orderDateTime, String orderInfo){
        String folderPath = "receipts";
        String fullPath = folderPath + File.separator + getFileName(orderDateTime);
        File receipt = new File(fullPath);
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(receipt));
            bufferedWriter.write(orderInfo);
            bufferedWriter.flush();
            bufferedWriter.close();
        }catch (Exception e){
            System.out.println("Error: " + e.toString());
        }
    }
}
