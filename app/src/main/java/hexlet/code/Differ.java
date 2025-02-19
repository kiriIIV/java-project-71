package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {

        Map<String, Object> data1 = Parser.parseData(filePath1);
        Map<String, Object> data2 = Parser.parseData(filePath2);

        ArrayList<List<Object>> statOfData = new ArrayList<>();

        Set<String> setOfKeys = new TreeSet<>(data1.keySet());
        setOfKeys.addAll(data2.keySet());

        for (String key : setOfKeys) {
            if (data1.containsKey(key)) {
                if (data2.containsKey(key)) {
                    if ((data1.get(key) + "").equals(data2.get(key) + "")) {
                        ArrayList<Object> statOfElement = new ArrayList<>();
                        statOfElement.add(key);
                        statOfElement.add(data1.get(key));
                        statOfElement.add("same data");
                        statOfData.add(statOfElement);

                    } else {
                        ArrayList<Object> statOfElement1 = new ArrayList<>();
                        statOfElement1.add(key);
                        statOfElement1.add(data1.get(key));
                        statOfElement1.add("updated");
                        statOfData.add(statOfElement1);
                        ArrayList<Object> statOfElement2 = new ArrayList<>();
                        statOfElement2.add(key);
                        statOfElement2.add(data2.get(key));
                        statOfElement2.add("");
                        statOfData.add(statOfElement2);
                    }
                } else {
                    ArrayList<Object> statOfElement = new ArrayList<>();
                    statOfElement.add(key);
                    statOfElement.add(data1.get(key));
                    statOfElement.add("removed");
                    statOfData.add(statOfElement);
                }
            } else {
                ArrayList<Object> statOfElement = new ArrayList<>();
                statOfElement.add(key);
                statOfElement.add(data2.get(key));
                statOfElement.add("added");
                statOfData.add(statOfElement);
            }
        }

        return Formatter.chooseFormat(statOfData, format);
    }
}
