import JSON.Item;
import menu.FoodMenu;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import parameter.Parameter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

class FizzBuzzTest {
    static String CHINESE = "中華";
    static String JAPANESE = "和食";
    static String FRIED_RICE = "チャーハン";
    static int PRICE = 10;


    @ParameterizedTest(name = "{0} & {1} & {2}")
    @CsvSource({
            "'中華',  '1',   '1'",
            "'洋食',  '1',   '1'",
            "'中華',  '5',   '3'",
            "'中華',  '3',   '5'",
    })
    void execute(String category, String x, String y) {

        FoodMenu foodMenu = mock(FoodMenu.class);

        List<Item> list = new ArrayList<>();
        Item item = new Item();
        item.category = CHINESE;
        item.price = 10;
        item.name = FRIED_RICE;
        list.add(item);
        when(foodMenu.addFeeMenu()).thenReturn(list);
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        String[] args = {category, x, y};
        Parameter parameter = new Parameter(args);
        parameter.checkAndSetValue();


        FizzBuzz fizzBuzz = new FizzBuzz(foodMenu, parameter);
        fizzBuzz.execute();

        if (category.equals(JAPANESE)) {
            verify(out, times(0));
        }

        if (category.equals(CHINESE)) {
            if (PRICE % parameter.getX() == 0 && PRICE % parameter.getY() == 0) {

                verify(out, times(1)).println("FizzBuzz");

            } else if (PRICE % parameter.getX() == 0) {

                verify(out, times(1)).println(FRIED_RICE);


            } else if (PRICE % parameter.getY() == 0) {
                verify(out, times(1)).println(PRICE);


            }
        }


    }

}