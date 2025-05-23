package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.HashMap;

public class FileUtils {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    // parse csv file with lines of only 2 values each e.g. Size|Price
    public HashMap<String, Double> readPriceWithHeader(String filePath) {
        HashMap<String, Double> output = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
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
}
