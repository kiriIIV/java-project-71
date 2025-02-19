package formatters;

import java.util.List;

public class Stylish {

    public static String stylishFormat(List<List<Object>> statOfData) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{").append("\n");

        if (statOfData.isEmpty()) {
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        for (List<Object> statOfElement: statOfData) {
            if (statOfElement.get(2).equals("same data")) {
                stringBuilder.append(String.format("%s%s: %s", " ".repeat(4), statOfElement.get(0),
                        statOfElement.get(1))).append("\n");
            } else if (statOfElement.get(2).equals("updated")) {
                stringBuilder.append(String.format("%s- %s: %s", " ".repeat(2), statOfElement.get(0),
                        statOfElement.get(1))).append("\n");
            } else if (statOfElement.get(2).equals("")) {
                stringBuilder.append(String.format("%s+ %s: %s", " ".repeat(2), statOfElement.get(0),
                        statOfElement.get(1))).append("\n");
            } else if (statOfElement.get(2).equals("removed")) {
                stringBuilder.append(String.format("%s- %s: %s", " ".repeat(2), statOfElement.get(0),
                        statOfElement.get(1))).append("\n");
            } else if (statOfElement.get(2).equals("added")) {
                stringBuilder.append(String.format("%s+ %s: %s", " ".repeat(2), statOfElement.get(0),
                        statOfElement.get(1))).append("\n");
            }
        }

        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
