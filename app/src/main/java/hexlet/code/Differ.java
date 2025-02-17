package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(Map<String, Object> json1, Map<String, Object> json2) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("\n");

        Set<String> setOfKeys = new TreeSet<>(json1.keySet());
        setOfKeys.addAll(json2.keySet());

        for (String key : setOfKeys) {
            if (json1.containsKey(key)) {
                if (json2.containsKey(key)) {
                    if (json1.get(key).equals(json2.get(key))) {
                        stringBuilder.append(String.format("%s%s: %s", " ".repeat(4), key, json1.get(key)))
                                .append("\n");
                    } else {
                        stringBuilder.append(String.format("%s- %s: %s", " ".repeat(2), key, json1.get(key)))
                                .append("\n");
                        stringBuilder.append(String.format("%s+ %s: %s", " ".repeat(2), key, json2.get(key)))
                                .append("\n");
                    }
                } else {
                    stringBuilder.append(String.format("%s- %s: %s", " ".repeat(2), key, json1.get(key)))
                            .append("\n");
                }
            } else {
                stringBuilder.append(String.format("%s+ %s: %s", " ".repeat(2), key, json2.get(key)))
                        .append("\n");
            }
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
