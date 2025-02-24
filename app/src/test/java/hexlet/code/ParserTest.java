package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    private static String pathJson = "";
    private static String pathYAML = "";
    private static String jsonData = "";
    private static String yamlData = "";
    private static String jsonFormat = "";
    private static String yamlFormat = "";
    private static String ymlFormat = "";

    @BeforeAll
    public static void beforeAll() {
        pathJson = "src/test/resources/fixtures/json/file1.json";
        pathYAML = "src/test/resources/fixtures/yaml/file1.yaml";
        jsonData = "{ \"key\": \"value\" }";
        yamlData = "key: value";
        jsonFormat = "json";
        yamlFormat = "yaml";
        ymlFormat = "yml";
    }

    @Test
    public void testGetPathJson() {
        Path actual = Parser.getPath(pathJson);

        Path expected = Path.of(pathJson).toAbsolutePath().normalize();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetPathYAML() {
        Path actual = Parser.getPath(pathYAML);

        Path expected = Path.of(pathYAML).toAbsolutePath().normalize();

        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile() throws Exception {
        String actual = Parser.readFile(pathJson);

        String expected = Parser.readFile("src/test/resources/fixtures/json/jsonRead.txt");

        assertEquals(expected, actual);
    }

    @Test
    public void testReadEmptyFile() throws Exception {
        assertThrows(Exception.class, () -> Parser.readFile("123/321.json"));
    }
    @Test
    public void testParseJsonData() throws Exception {
        Map<String, Object> actual = Parser.parseData("src/test/resources/fixtures/json/flat.json");

        Map<String, Object> expected = Map.of("host", "hexlet.io", "timeout", true,
                "proxy", "123.234.53.22", "follow", false);

        assertEquals(expected, actual);
    }
    @Test
    public void testParseJsonEmptyData() throws Exception {
        Map<String, Object> actual = Parser.parseData("src/test/resources/fixtures/json/empty.json");

        Map<String, Object> expected = Map.of();

        assertEquals(expected, actual);
    }
    @Test
    public void testParseJsonDataException() throws Exception {
        assertThrows(Exception.class, () -> Parser.parseData("123/321.json"));
    }
    @Test
    public void testParseYAMLData() throws Exception {
        Map<String, Object> actual = Parser.parseData("src/test/resources/fixtures/yaml/flat.yaml");

        Map<String, Object> expected = Map.of("host", "hexlet.io", "timeout", false,
                "proxy", "123.234.53.22", "follow", false);

        assertEquals(expected, actual);
    }
    @Test
    public void testParseYAMLEmptyData() throws Exception {
        Map<String, Object> actual = Parser.parseData("src/test/resources/fixtures/yaml/empty.yaml");

        Map<String, Object> expected = Map.of();

        assertEquals(expected, actual);
    }
    @Test
    public void testParseYAMLDataException() throws Exception {
        assertThrows(Exception.class, () -> Parser.parseData("123/321.yaml"));
    }

    @Test
    public void testReadDataJson() throws Exception {
        Map<String, Object> result = Parser.readData(jsonData, jsonFormat);

        assertEquals("value", result.get("key"));
    }

    @Test
    public void testReadDataYaml() throws Exception {
        Map<String, Object> result = Parser.readData(yamlData, yamlFormat);

        assertEquals("value", result.get("key"));
    }

    @Test
    public void testReadDataYml() throws Exception {
        Map<String, Object> result = Parser.readData(yamlData, ymlFormat);

        assertEquals("value", result.get("key"));
    }

    @Test
    public void testReadDataInvalidFormat() {
        Exception exception = assertThrows(Exception.class, () -> Parser.readData(jsonData, "123"));

        assertEquals("Invalid format!", exception.getMessage());
    }

    @Test
    public void testReadDataInvalidJson() {
        String invalidJson = "{ invalid json ";

        assertThrows(Exception.class, () -> Parser.readData(invalidJson, jsonFormat));
    }
}
