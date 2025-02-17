package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReadAndParseTest {

    private static String path = "";

    @BeforeAll
    public static void beforeAll() {
        path = "src/test/resources/fixtures/file1.json";
    }

    @Test
    public void testGetPath() {
        Path expected = ReadAndParse.getPath(path);
        Path actual = Path.of(path).toAbsolutePath().normalize();
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile1() throws Exception {
        String expected = ReadAndParse.readFile(path);
        String actual = ReadAndParse.readFile("src/test/resources/fixtures/jsonRead.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testReadFile2() throws Exception {
        assertThrows(Exception.class, () -> ReadAndParse.readFile("123/321.json"));
    }
    @Test
    public void testParseJsonData1() throws Exception {
        var expected = ReadAndParse.parseJsonData(path);
        Map<String, Object> actual = Map.of("host", "hexlet.io", "timeout", 50,
                "proxy", "123.234.53.22", "follow", false);
        assertEquals(expected, actual);
    }
    @Test
    public void testParseJsonData2() throws Exception {
        var expected = ReadAndParse.parseJsonData("src/test/resources/fixtures/empty.json");
        Map<String, Object> actual = Map.of();
        assertEquals(expected, actual);
    }
    @Test
    public void testParseJsonData3() throws Exception {
        assertThrows(Exception.class, () -> ReadAndParse.parseJsonData("123/321.json"));
    }
}
