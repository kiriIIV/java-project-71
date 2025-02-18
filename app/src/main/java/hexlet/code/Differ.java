package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {
    public static List<List<String>> generate(Map<String, Object> data1, Map<String, Object> data2) {

        ArrayList<String> listOfKeys = new ArrayList<>();
        ArrayList<String> listOfValues = new ArrayList<>();

        Set<String> setOfKeys = new TreeSet<>(data1.keySet());
        setOfKeys.addAll(data2.keySet());

        for (String key : setOfKeys) {
            if (data1.containsKey(key)) {
                if (data2.containsKey(key)) {
                    if ((data1.get(key) + "").equals(data2.get(key) + "")) {
                        listOfKeys.add(key);
                        listOfValues.add(data1.get(key) + "");
                    } else {
                        listOfKeys.add("- " + key);
                        listOfValues.add(data1.get(key) + "");
                        listOfKeys.add("+ " + key);
                        listOfValues.add(data2.get(key) + "");
                    }
                } else {
                    listOfKeys.add("- " + key);
                    listOfValues.add(data1.get(key) + "");
                }
            } else {
                listOfKeys.add("+ " + key);
                listOfValues.add(data2.get(key) + "");
            }
        }

        return List.of(listOfKeys, listOfValues);
    }
}
