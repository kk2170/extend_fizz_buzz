package menu;

import JSON.Item;

import java.util.List;

public class FoodMenu implements MyMenu {
    public static final double addFeePriceScale = 1.0;
    public static final String pathName = "src/main/resources/food.json";
    private List<Item> menu;

    public FoodMenu() {
        menu = readJson(pathName);
    }

    @Override
    public double getAddFeePriceScale() {
        return addFeePriceScale;
    }

    @Override
    public List<Item> addFeeMenu() {
        return menu;
    }
}
