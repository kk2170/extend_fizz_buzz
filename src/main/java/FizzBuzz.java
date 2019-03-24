import JSON.Item;
import menu.MyMenu;
import parameter.Parameter;

import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {
    public static void execute(MyMenu menu, Parameter params) {
        List<Item> list = menu.addFeeMenu().stream().filter(f -> f.category.equals(params.getCategory()))
                .collect(Collectors.toList());

        for (Item item : list) {
            boolean isDivisibleByX = item.price % params.getX() == 0;
            boolean isDivisibleByY = item.price % params.getY() == 0;

            if (isDivisibleByX && isDivisibleByY) {
                System.out.println("FizzBuzz");
                continue;
            }
            if (isDivisibleByX) {
                System.out.println(item.name);
                continue;
            }
            if (isDivisibleByY) {
                System.out.println(item.price);
                continue;
            }
        }
    }
}
