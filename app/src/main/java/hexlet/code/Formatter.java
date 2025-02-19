package hexlet.code;

import formatters.Plain;
import formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String chooseFormat(List<List<Object>> data, String format) {
        switch (format) {
            case "stylish":
                return Stylish.stylishFormat(data);
            case "plain":
                return Plain.plainFormat(data);
            default:
                return "Invalid format!";
        }
    }
}
