import java.util.List;

import menu.AlcoholMenu;
import menu.FoodMenu;
import menu.MyMenu;
import parameter.Parameter;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Parameter params = new Parameter(args);

        List<MyMenu> menuList = new ArrayList<>();
        menuList.add(new AlcoholMenu());
        menuList.add(new FoodMenu());

        for(MyMenu menu: menuList){
            FizzBuzz.execute(menu, params);
        }
    }


}
