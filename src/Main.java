import screens.HomeScreen;
import screens.Screen;
import utils.MenuUtils;
import utils.OrderManager;

public class Main {
    public static void main(String[] args) {

//        //test readPriceWithHeader
//        utils.FileUtils fileUtils = new utils.FileUtils();
//        HashMap<String, Double> list = fileUtils.parse2Values("drinkPrice.csv");
//        System.out.println(list.get("small"));

//        //test parseMultipleValues
//        utils.FileUtils fileUtils = new utils.FileUtils();
//        HashMap<String, HashMap<String, Double>> list = fileUtils.parseMultipleValues("sandwichPrice.csv");
//        HashMap<String, Double> priceChart = list.get("4");
//        for (HashMap.Entry<String, Double> entry : priceChart.entrySet()) {
//            String key = entry.getKey();
//            Double value = entry.getValue();
//            System.out.println("Key: " + key + ", Value: " + value);
//        }
//
//        //test createFile
//        LocalDateTime now = LocalDateTime.now();
//        utils.FileUtils fileUtils = new utils.FileUtils();
//        fileUtils.createFile(now);

//        System.out.println("---------10--------20--------30--------40--------50--------60--------70--------80");
        OrderManager sharedOrderManager = new OrderManager();
        HomeScreen homeScreen = new HomeScreen(sharedOrderManager);
        homeScreen.display();
    }
}