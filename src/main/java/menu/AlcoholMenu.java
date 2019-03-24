package menu;

import java.util.List;
import JSON.Item;

public class AlcoholMenu implements MyMenu {
    public static final double addFeePriceScale = 1.1;
    public static final String pathName = "src/main/resources/alcohol.json";
    private List<Item> menu;

    public AlcoholMenu() {
        menu = readJson(pathName);
    }

    @Override
    public double getAddFeePriceScale(){
        return addFeePriceScale;
    }

    @Override
    public List<Item> addFeeMenu() {
        return menu;
    }
}
