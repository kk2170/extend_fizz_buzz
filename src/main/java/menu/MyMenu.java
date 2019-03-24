package menu;

import JSON.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import parameter.SystemProvider;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            String jsonString = Files.lines(Paths.get(pathName), StandardCharsets.UTF_8).collect(Collectors.joining(System.getProperty("line.separator")));
            ObjectMapper mapper = new ObjectMapper();
            menu = mapper.readValue(jsonString, new TypeReference<List<Item>>() {
            });
            addFee(menu);
        } catch (IOException e) {
            e.printStackTrace();
            new SystemProvider().errorExit();
        }
        return menu;
    }
}
