package screens;

import utils.TextUtils;

public class HomeScreen extends Screen{
    private TextUtils textUtils;

    public HomeScreen(){
        this.textUtils = new TextUtils();
    }
    @Override
    public void display() {
        System.out.println(textUtils.headerWithPadding("Home Screen","*","-",3));
        System.out.println(textUtils.header("Home Screen", "*"));
    }
}
