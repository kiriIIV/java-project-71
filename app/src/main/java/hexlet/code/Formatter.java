package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;

import java.util.List;

public class Formatter {
    public static final String STYLISH = "stylish";
    public static final String PLAIN = "plain";
    public static final String JSON = "json";

    public static String chooseFormat(List<List<Object>> data, String format) throws Exception {
        return switch (format) {
            case STYLISH -> Stylish.stylishFormat(data);
            case PLAIN -> Plain.plainFormat(data);
            case JSON -> Json.jsonFormat(data);
            default -> throw new Exception("Invalid format!");
        };
    }
}
