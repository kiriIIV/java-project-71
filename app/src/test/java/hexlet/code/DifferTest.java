package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DifferTest {

    private static String path1 = "";
    private static String path2 = "";
    private static String emptyPath = "";

    @BeforeAll
    public static void beforeAll() {
        path1 = "src/test/resources/fixtures/file1.json";
        path2 = "src/test/resources/fixtures/file2.json";
        emptyPath = "src/test/resources/fixtures/empty.json";
    }

    @Test
    public void testDiffer1() throws Exception {
    var mapJson1 = ReadAndParse.parseJsonData(path1);
    var mapJson2 = ReadAndParse.parseJsonData(path2);
    String expected = Differ.generate(mapJson1, mapJson2);
    String actual = ReadAndParse.readFile("src/test/resources/fixtures/resultDiffer1.txt");
    assertEquals(expected, actual);
    }

    @Test
    public void testDiffer2() throws Exception {
        var mapJson1 = ReadAndParse.parseJsonData(path1);
        var mapJson2 = ReadAndParse.parseJsonData(emptyPath);
        String expected = Differ.generate(mapJson1, mapJson2);
        String actual = ReadAndParse.readFile("src/test/resources/fixtures/resultDiffer2.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testDiffer3() throws Exception {
        var mapJson1 = ReadAndParse.parseJsonData(emptyPath);
        var mapJson2 = ReadAndParse.parseJsonData(path2);
        String expected = Differ.generate(mapJson1, mapJson2);
        String actual = ReadAndParse.readFile("src/test/resources/fixtures/resultDiffer3.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testDiffer4() throws Exception {
        var mapJson1 = ReadAndParse.parseJsonData(emptyPath);
        var mapJson2 = ReadAndParse.parseJsonData(emptyPath);
        String expected = Differ.generate(mapJson1, mapJson2);
        String actual = ReadAndParse.readFile("src/test/resources/fixtures/resultDiffer4.txt");
        assertEquals(expected, actual);
    }

}
