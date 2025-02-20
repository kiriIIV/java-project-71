package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {

    public static final int SIZE_OF_UPDATED_ELEMENT = 4;
    public static final int INDEX_OF_STATUS_FOR_UPDATED = 3;
    public static final int SIZE_OF_ELEMENT = 3;
    public static final int INDEX_OF_STATUS_FOR_ELEMENT = 2;

    private static final ArrayList<List<Object>> STAT_OF_DATA = new ArrayList<>();

    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        ArrayList<List<Object>> statOfData = getStatOfData(filePath1, filePath2);
        return Formatter.chooseFormat(statOfData, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {

        ArrayList<List<Object>> statOfData = getStatOfData(filePath1, filePath2);
        return Formatter.chooseFormat(statOfData, "stylish");
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
                        addStatusOfKey(key, data1.get(key), data2.get(key), "updated");
                    }
                } else {
                    addStatusOfKey(key, data1.get(key), "removed");
                }
            } else {
                addStatusOfKey(key, data2.get(key), "added");
            }
        }

        ArrayList<List<Object>> result = new ArrayList<>(STAT_OF_DATA);
        clearData();
        return result;
    }

    public static void addStatusOfKey(Object key, Object value, String status) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add(status);
        STAT_OF_DATA.add(statOfElement);
    }

    public static void addStatusOfKey(Object key, Object oldValue, Object newValue, String status) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(oldValue);
        statOfElement.add(newValue);
        statOfElement.add(status);
        STAT_OF_DATA.add(statOfElement);
    }

    public static void clearData() {
        STAT_OF_DATA.clear();
    }

}
