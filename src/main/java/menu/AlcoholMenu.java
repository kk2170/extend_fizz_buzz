package menu;

import JSON.Item;

import java.util.List;

public class AlcoholMenu implements MyMenu {
    public static final double addFeePriceScale = 1.1;
    public static final String pathName = "/alcohol.json";
    private List<Item> menu;

    public AlcoholMenu() {
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
