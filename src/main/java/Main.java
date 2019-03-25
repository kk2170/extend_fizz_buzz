import menu.AlcoholMenu;
import menu.FoodMenu;
import menu.MyMenu;
import parameter.Parameter;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Parameter params = new Parameter(args);
        params.check();
        if (params.isInvalid()) {
            System.exit(1);
        }
        List<MyMenu> menuList = new ArrayList<>();
        menuList.add(new AlcoholMenu());
        menuList.add(new FoodMenu());

        for (MyMenu menu : menuList) {
            if (menu != null) {
                FizzBuzz fizzBuzz = new FizzBuzz(menu, params);
                fizzBuzz.filterByCategory();
                fizzBuzz.execute();
            }
        }
    }

}
