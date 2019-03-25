package menu;

import JSON.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public interface MyMenu {
    double getAddFeePriceScale();

    List<Item> addFeeMenu();

    default List<Item> addFee(List<Item> menu) {
        menu.stream().map(item -> {
            item.price = (int) (item.price * getAddFeePriceScale());
            return item;
        }).collect(Collectors.toList());

        return menu;
    }

    default List<Item> readJson(String pathName) {
        List<Item> menu = null;
        try {
            String jsonString;
            InputStream in = getClass().getResourceAsStream(pathName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            jsonString = reader.lines().collect(Collectors.joining());

            ObjectMapper mapper = new ObjectMapper();
            menu = mapper.readValue(jsonString, new TypeReference<List<Item>>() {
            });
            addFee(menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return menu;
    }
}
