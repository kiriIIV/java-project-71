package formatters;

import java.util.List;

public class Stylish {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static String stylishFormat(List<List<Object>> statOfData) {

        STRING_BUILDER.append("{").append("\n");

        if (statOfData.isEmpty()) {
            return STRING_BUILDER.append("}").toString();
        }

        for (List<Object> statOfElement: statOfData) {
            if (statOfElement.size() == 4) {
                updatedFrom(statOfElement);
                updatedTo(statOfElement);
            } else if (statOfElement.get(2).equals("same data")) {
                sameData(statOfElement);
            } else if (statOfElement.get(2).equals("removed")) {
                removed(statOfElement);
            } else if (statOfElement.get(2).equals("added")) {
                added(statOfElement);
            }
        }

        return STRING_BUILDER.append("}").toString();
    }

    public static void sameData(List<Object> statOfElement) {
        STRING_BUILDER.append(String.format("%s%s: %s", " ".repeat(4), statOfElement.get(0),
                statOfElement.get(1))).append("\n");
    }

    public static void updatedFrom(List<Object> statOfElement) {
        STRING_BUILDER.append(String.format("%s- %s: %s", " ".repeat(2), statOfElement.get(0),
                statOfElement.get(1))).append("\n");
    }

    public static void updatedTo(List<Object> statOfElement) {
        STRING_BUILDER.append(String.format("%s+ %s: %s", " ".repeat(2), statOfElement.get(0),
                statOfElement.get(2))).append("\n");
    }

    public static void removed(List<Object> statOfElement) {
        STRING_BUILDER.append(String.format("%s- %s: %s", " ".repeat(2), statOfElement.get(0),
                statOfElement.get(1))).append("\n");
    }

    public static void added(List<Object> statOfElement) {
        STRING_BUILDER.append(String.format("%s+ %s: %s", " ".repeat(2), statOfElement.get(0),
                statOfElement.get(1))).append("\n");
    }

    public static void cleanStringBuilder() {
        STRING_BUILDER.setLength(0);
    }
}
