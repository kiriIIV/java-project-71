package hexlet.code;

import java.util.List;

public class Formater {

    public static String stylishFormat(List<List<String>> listOfKeyAndValues) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("\n");

        if (listOfKeyAndValues.isEmpty()) {
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        List<String> listOfKeys =  listOfKeyAndValues.get(0);
        List<String> listOfValues =  listOfKeyAndValues.get(1);

        for (int i = 0; i < listOfKeys.size(); i++) {
            if (listOfKeys.get(i).charAt(0) == '+' || listOfKeys.get(i).charAt(0) == '-') {
                stringBuilder.append(String.format("%s%s: %s", " ".repeat(2), listOfKeys.get(i),
                        listOfValues.get(i))).append("\n");
            } else {
                stringBuilder.append(String.format("%s%s: %s", " ".repeat(4), listOfKeys.get(i),
                        listOfValues.get(i))).append("\n");
            }
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
