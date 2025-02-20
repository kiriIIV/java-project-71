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

    @BeforeAll
    public static void beforeAll() {
        pathJson = "src/test/resources/fixtures/json/file1.json";
        pathYAML = "src/test/resources/fixtures/yaml/file1.yaml";
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
    public void testReadFile1() throws Exception {
        String actual = Parser.readFile(pathJson);
        String expected = Parser.readFile("src/test/resources/fixtures/json/jsonRead.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile2() throws Exception {
        assertThrows(Exception.class, () -> Parser.readFile("123/321.json"));
    }
    @Test
    public void testParseJsonData1() throws Exception {
        var actual = Parser.parseData("src/test/resources/fixtures/json/flat.json");
        Map<String, Object> expected = Map.of("host", "hexlet.io", "timeout", true,
                "proxy", "123.234.53.22", "follow", false);
        assertEquals(expected, actual);
    }
    @Test
    public void testParseJsonData2() throws Exception {
        var actual = Parser.parseData("src/test/resources/fixtures/json/empty.json");
        Map<String, Object> expected = Map.of();
        assertEquals(expected, actual);
    }
    @Test
    public void testParseJsonData3() throws Exception {
        assertThrows(Exception.class, () -> Parser.parseData("123/321.json"));
    }
    @Test
    public void testParseYAMLData1() throws Exception {
        var actual = Parser.parseData("src/test/resources/fixtures/yaml/flat.yaml");
        Map<String, Object> expected = Map.of("host", "hexlet.io", "timeout", false,
                "proxy", "123.234.53.22", "follow", false);
        assertEquals(expected, actual);
    }
    @Test
    public void testParseYAMLData2() throws Exception {
        var actual = Parser.parseData("src/test/resources/fixtures/yaml/empty.yaml");
        Map<String, Object> expected = Map.of();
        assertEquals(expected, actual);
    }
    @Test
    public void testParseYAMLData3() throws Exception {
        assertThrows(Exception.class, () -> Parser.parseData("123/321.yaml"));
    }
}
