package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadAndParse {

    public static Path getPath(String readFilePath) {
        return Paths.get(readFilePath).toAbsolutePath().normalize();
    }

    public static String readFile(Path pathToFile) throws Exception {
        if (!Files.exists(pathToFile)) {
            throw new Exception("File" + pathToFile + "does not exists");
        }

        return Files.readString(pathToFile).trim();
    }

    public static Map<String, Object> parseJsonData(String jsonData) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonData, new TypeReference<Map<String,Object>>(){});
    }

}
