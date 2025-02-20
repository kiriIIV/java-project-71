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
                        sameValue(key, data1.get(key));

                    } else {
                        updatedFrom(key, data1.get(key));
                        updatedTo(key, data2.get(key));
                    }
                } else {
                    removedValue(key, data1.get(key));
                }
            } else {
                addedValue(key, data2.get(key));
            }
        }

        return STAT_OF_DATA;
    }

    public static void sameValue(Object key, Object value) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add("same data");
        STAT_OF_DATA.add(statOfElement);
    }

    public static void updatedFrom(Object key, Object value) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add("updatedFrom");
        STAT_OF_DATA.add(statOfElement);
    }

    public static void updatedTo(Object key, Object value) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add("updatedTo");
        STAT_OF_DATA.add(statOfElement);
    }

    public static void addedValue(Object key, Object value) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add("added");
        STAT_OF_DATA.add(statOfElement);
    }

    public static void removedValue(Object key, Object value) {
        ArrayList<Object> statOfElement = new ArrayList<>();
        statOfElement.add(key);
        statOfElement.add(value);
        statOfElement.add("removed");
        STAT_OF_DATA.add(statOfElement);
    }

    public static void clearData() {
        STAT_OF_DATA.clear();
    }

}
