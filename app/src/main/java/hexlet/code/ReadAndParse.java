package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadAndParse {

    public static Path getPath(String readFilePath) {
        return Paths.get(readFilePath).toAbsolutePath().normalize();
    }

    public static String readFile(String readFilePath) throws Exception {
        Path path = getPath(readFilePath);
        if (!Files.exists(path)) {
            throw new Exception("File " + path + " does not exists");
        }

        return Files.readString(path).trim();
    }

    public static Map<String, Object> parseJsonData(String readFilePath) throws Exception {
        String jsonData = readFile(readFilePath);
        if (jsonData.trim().isEmpty()) { // Проверяем пустой контент
            return new LinkedHashMap<String, Object>();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, new TypeReference<Map<String, Object>>() { });
    }

}
