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
    private static ObjectMapper objectMapper;
    private static String data;

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
        if (readFilePath.endsWith(".json")) {
            jsonFormat(readFilePath);
        } else if (readFilePath.endsWith(".yml") || readFilePath.endsWith(".yaml")) {
            yamlFormat(readFilePath);
        } else {
            throw new Exception("Invalid format");
        }

        if (data.trim().isEmpty()) {
            return new HashMap<String, Object>();
        }

        return objectMapper.readValue(data, new TypeReference<HashMap<String, Object>>() { });
    }

    public static void jsonFormat(String readFilePath) throws Exception {
        data = readFile(readFilePath);
        objectMapper = new ObjectMapper();
    }

    public static void yamlFormat(String readFilePath) throws Exception {
        data = readFile(readFilePath);
        objectMapper = new ObjectMapper(new YAMLFactory());
    }

}
