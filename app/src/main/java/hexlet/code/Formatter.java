package hexlet.code;

import formatters.Plain;
import formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String chooseFormat(List<List<Object>> data, String format) {
        return switch (format) {
            case "stylish" -> Stylish.stylishFormat(data);
            case "plain" -> Plain.plainFormat(data);
            default -> "Invalid format!";
        };
    }
}
