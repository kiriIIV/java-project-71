package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {

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
        ObjectMapper objectMapper = null;
        String data = "";
        if (readFilePath.endsWith(".json")) {
            data = readFile(readFilePath);
            if (data.trim().isEmpty()) {
                return new LinkedHashMap<String, Object>();
            }
            objectMapper = new ObjectMapper();
        } else if (readFilePath.endsWith(".yml") || readFilePath.endsWith(".yaml")) {
            data = readFile(readFilePath);
            if (data.trim().isEmpty()) {
                return new LinkedHashMap<String, Object>();
            }
            objectMapper = new ObjectMapper(new YAMLFactory());
        } else {
            throw new Exception("Invalid format");
        }

        return objectMapper.readValue(data, new TypeReference<Map<String, Object>>() { });
    }

}
