package formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plainFormat(List<List<Object>> statOfData) {
        StringBuilder stringBuilder = new StringBuilder();

        if (statOfData.isEmpty()) {
            return stringBuilder.toString();
        }

        for (int i = 0; i < statOfData.size(); i++) {

            List<Object> statOfElement = statOfData.get(i);


            if (statOfElement.get(2).equals("updated")) {
                if (statOfElement.get(1) instanceof Object[] || statOfElement.get(1) instanceof Map
                        || statOfElement.get(1) instanceof List) {
                    stringBuilder.append(String.format("Property '%s' was updated."
                            + " From [complex value] to ", statOfElement.getFirst()));
                } else {
                    stringBuilder.append(String.format("Property '%s' was updated."
                            + " From %s to ", statOfElement.getFirst(), statOfElement.get(1)));
                }
            } else if (statOfElement.get(2).equals("")) {
                if (statOfElement.get(1) instanceof Object[] || statOfElement.get(1) instanceof Map
                        || statOfElement.get(1) instanceof List) {
                    stringBuilder.append("[complex value]").append("\n");
                } else {
                    stringBuilder.append(String.format("%s", statOfElement.get(1))).append("\n");
                }
            } else if (statOfElement.get(2).equals("removed")) {
                stringBuilder.append(String.format("Property '%s' was removed", statOfElement.getFirst()))
                        .append("\n");
            } else if (statOfElement.get(2).equals("added")) {
                if (statOfElement.get(1) instanceof Object[] || statOfElement.get(1) instanceof Map
                        || statOfElement.get(1) instanceof List) {
                    stringBuilder.append(String.format("Property '%s' was added with value: [complex value]",
                            statOfElement.getFirst())).append("\n");
                } else {
                    stringBuilder.append(String.format("Property '%s' was added with value: %s",
                            statOfElement.getFirst(), statOfElement.get(1))).append("\n");
                }
            }
        }

        if (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) == '\n') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        return stringBuilder.toString();
    }
}
