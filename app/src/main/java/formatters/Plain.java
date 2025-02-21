package formatters;

import hexlet.code.Differ;

import java.util.List;
import java.util.Map;

public class Plain {

    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    public static String plainFormat(List<List<Object>> statOfData) {

        if (statOfData.isEmpty()) {
            return STRING_BUILDER.toString();
        }

        for (List<Object> statOfElement : statOfData) {

            if (statOfElement.size() == Differ.SIZE_OF_UPDATED_ELEMENT) {
                updatedFrom(statOfElement);
                updatedTo(statOfElement);
            } else if (statOfElement.get(2).equals("removed")) {
                removedElement(statOfElement);
            } else if (statOfElement.get(2).equals("added")) {
                addedElement(statOfElement);
            }
        }
        if (!STRING_BUILDER.isEmpty() && STRING_BUILDER.charAt(STRING_BUILDER.length() - 1) == '\n') {
            STRING_BUILDER.deleteCharAt(STRING_BUILDER.length() - 1);
        }

        String result = STRING_BUILDER.toString();
        cleanStringBuilder();
        return result;
    }

    public static String getType(Object object) {
        if (object instanceof String) {
            return String.format("'%s'", object);
        }

        return "" + object;
    }

    public static void updatedFrom(List<Object> statOfElement) {
        if (statOfElement.get(1) instanceof Object[] || statOfElement.get(1) instanceof Map
                || statOfElement.get(1) instanceof List) {
            STRING_BUILDER.append(String.format("Property '%s' was updated."
                    + " From [complex value] to ", statOfElement.getFirst()));
        } else {
            STRING_BUILDER.append(String.format("Property '%s' was updated."
                    + " From %s to ", statOfElement.getFirst(), getType(statOfElement.get(1))));
        }
    }

    public static void updatedTo(List<Object> statOfElement) {
        if (statOfElement.get(2) instanceof Object[] || statOfElement.get(2) instanceof Map
                || statOfElement.get(2) instanceof List) {
            STRING_BUILDER.append("[complex value]").append("\n");
        } else {
            STRING_BUILDER.append(String.format("%s", getType(statOfElement.get(2)))).append("\n");
        }
    }

    public static void removedElement(List<Object> statOfElement) {
        STRING_BUILDER.append(String.format("Property '%s' was removed", statOfElement.getFirst()))
                .append("\n");
    }

    public static void addedElement(List<Object> statOfElement) {
        if (statOfElement.get(1) instanceof Object[] || statOfElement.get(1) instanceof Map
                || statOfElement.get(1) instanceof List) {
            STRING_BUILDER.append(String.format("Property '%s' was added with value: [complex value]",
                    statOfElement.getFirst())).append("\n");
        } else {
            STRING_BUILDER.append(String.format("Property '%s' was added with value: %s",
                    statOfElement.getFirst(), getType(statOfElement.get(1)))).append("\n");
        }
    }

    public static void cleanStringBuilder() {
        STRING_BUILDER.setLength(0);
    }
}
