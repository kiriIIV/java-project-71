package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import formatters.Json;
import formatters.Plain;
import formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String chooseFormat(List<List<Object>> data, String format) throws JsonProcessingException {
        return switch (format) {
            case "stylish" -> Stylish.stylishFormat(data);
            case "plain" -> Plain.plainFormat(data);
            case "json" -> Json.jsonFormat(data);
            default -> "Invalid format!";
        };
    }
}
