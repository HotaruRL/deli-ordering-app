package screens;

import utils.MenuUtils;
import utils.OptionsList;
import utils.OrderManager;

public abstract class Screen {
    protected OrderManager orderManager;
    protected OptionsList optionsList = new OptionsList();;
    protected MenuUtils menuUtils = new MenuUtils();

    public Screen(OrderManager orderManager){
        this.orderManager = orderManager;
    }

    public abstract void display();
}
