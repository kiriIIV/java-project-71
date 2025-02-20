package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {

    private static final ArrayList<List<Object>> STAT_OF_DATA = new ArrayList<>();

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        ArrayList<List<Object>> statOfData = getStatOfData(filePath1, filePath2);
        return Formatter.chooseFormat(statOfData, format);
    }

    public static ArrayList<List<Object>> getStatOfData(String filePath1, String filePath2) throws Exception {

        Map<String, Object> data1 = Parser.parseData(filePath1);
        Map<String, Object> data2 = Parser.parseData(filePath2);

        Set<String> setOfKeys = new TreeSet<>(data1.keySet());
        setOfKeys.addAll(data2.keySet());

        for (String key : setOfKeys) {
            if (data1.containsKey(key)) {
                if (data2.containsKey(key)) {
                    if ((data1.get(key) + "").equals(data2.get(key) + "")) {
                        addStatusOfKey(key, data1.get(key), "same data");

                    } else {
                        addStatusOfKey(key, data1.get(key), "updatedFrom");
                        addStatusOfKey(key, data2.get(key), "updatedTo");
                    }
                } else {
                    addStatusOfKey(key, data1.get(key), "removed");
                }
            } else {
                addStatusOfKey(key, data2.get(key), "added");
            }
        }

        return STAT_OF_DATA;
    }

    public static void addStatusOfKey(Object key, Object value, String status) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add(status);
        STAT_OF_DATA.add(statOfElement);
    }

    public static void clearData() {
        STAT_OF_DATA.clear();
    }

}
