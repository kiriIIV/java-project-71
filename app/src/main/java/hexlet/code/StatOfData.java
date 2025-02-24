package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StatOfData {
    public static final String SAME_DATA = "same data";
    public static final String REMOVED = "removed";
    public static final String ADDED = "added";
    public static final String UPDATED = "updated";
    public static final int SIZE_OF_UPDATED_ELEMENT = 4;
    public static final int INDEX_OF_STATUS_FOR_UPDATED = 3;
    public static final int INDEX_OF_STATUS_FOR_ELEMENT = 2;
    private static final ArrayList<List<Object>> STAT_OF_DATA = new ArrayList<>();

    public static ArrayList<List<Object>> getStatOfData(String firstFile, String secondFile) throws Exception {
        Map<String, Object> firstData = Parser.parseData(firstFile);
        Map<String, Object> secondData = Parser.parseData(secondFile);
        Set<String> setOfKeys = new TreeSet<>(firstData.keySet());
        setOfKeys.addAll(secondData.keySet());
        for (String key : setOfKeys) {
            boolean keyInBothData = firstData.containsKey(key) && secondData.containsKey(key);
            if (keyInBothData && (firstData.get(key) + "").equals(secondData.get(key) + "")) {
                addStatusOfKey(key, firstData.get(key), SAME_DATA);
            } else if (keyInBothData) {
                addStatusOfKey(key, firstData.get(key), secondData.get(key), UPDATED);
            } else if (firstData.containsKey(key)) {
                addStatusOfKey(key, firstData.get(key), REMOVED);
            } else if (secondData.containsKey(key)) {
                addStatusOfKey(key, secondData.get(key), ADDED);
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
