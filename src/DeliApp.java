import screens.HomeScreen;
import utils.OrderManager;

public class DeliApp {
    public static void main(String[] args) {
        OrderManager sharedOrderManager = new OrderManager();
        HomeScreen homeScreen = new HomeScreen(sharedOrderManager);
        homeScreen.display();
    }
}