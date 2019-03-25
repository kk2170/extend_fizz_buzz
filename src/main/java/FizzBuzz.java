import JSON.Item;
import menu.MyMenu;
import parameter.Parameter;

import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz {
    private List<Item> list;
    private String category;
    private int x;
    private int y;

    public FizzBuzz(MyMenu menu, Parameter parameter) {
        list = menu.addFeeMenu();
        category = parameter.getCategory();
        x = parameter.getX();
        y = parameter.getY();
    }

    private List<Item> filterByCategory() {
         return list.stream().filter(f -> f.category.equals(category))
                .collect(Collectors.toList());
    }

    public void execute() {
        List<Item> filteredList = filterByCategory();
        for (Item item : filteredList) {
            boolean isDivisibleByX = item.price % x == 0;
            boolean isDivisibleByY = item.price % y == 0;

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
