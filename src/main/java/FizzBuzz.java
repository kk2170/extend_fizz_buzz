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

    public void filterByCategory() {
        list = list.stream().filter(f -> f.category.equals(category))
                .collect(Collectors.toList());
    }

    public void execute() {

        for (Item item : list) {
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
