package menu;

import JSON.Item;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        String jsonString;
        InputStream in = getClass().getResourceAsStream("/" + pathName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        jsonString = reader.lines().collect(Collectors.joining());

        menu = translateJsonToList(jsonString);

        addFee(menu);

        return menu;
    }

    default List<Item> translateJsonToList(String jsonString) {
        List<Item> itemList = new ArrayList<>();
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        try {
            ScriptObjectMirror json = (ScriptObjectMirror) engine.eval("JSON");
            Map<String, Map<String, Object>> result = ((Map<String, Map<String, Object>>) json.callMember("parse", jsonString));

            for(String key:result.keySet()){
                Map<String, Object> map = result.get(key);
                Item item = new Item();
                item.category = String.valueOf(map.get("category"));
                item.price = (Integer) map.get("price");
                item.name = String.valueOf(map.get("name"));
                itemList.add(item);
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return itemList;
    }
}
