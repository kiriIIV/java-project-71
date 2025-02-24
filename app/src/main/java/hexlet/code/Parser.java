package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    private static final String JSON_FORMAT = "json";
    private static final String YML_FORMAT = "yml";
    private static final String YAML_FORMAT = "yaml";

    public static Path getPath(String readFilePath) {
        return Paths.get(readFilePath).toAbsolutePath().normalize();
    }

    public static String readFile(String readFilePath) throws Exception {
        Path path = getPath(readFilePath);
        if (!Files.exists(path)) {
            throw new Exception("File " + path + " doesn't exists");
        }

        return Files.readString(path).trim();
    }

    public static Map<String, Object> parseData(String readFilePath) throws Exception {
        String data = readFile(readFilePath);
        if (data.trim().isEmpty()) {
            return new HashMap<String, Object>();
        }
        String getTypeOfFile = readFilePath.substring(readFilePath.lastIndexOf(".") + 1);
        return readData(data, getTypeOfFile);
    }

    public static Map<String, Object> readData(String data, String type) throws Exception {
        switch (type) {
            case JSON_FORMAT -> {
                return new ObjectMapper().readValue(data, new TypeReference<HashMap<String, Object>>() { });
            }
            case YAML_FORMAT, YML_FORMAT -> {
                return new ObjectMapper(new YAMLFactory())
                        .readValue(data, new TypeReference<HashMap<String, Object>>() { });
            }
            default -> throw new Exception("Invalid format!");
        }
    }
}
