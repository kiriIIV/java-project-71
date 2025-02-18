package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String jsonPath1 = "";
    private static String jsonPath2 = "";
    private static String jsonEmptyPath = "";
    private static String yamlPath1 = "";
    private static String yamlPath2 = "";
    private static String yamlEmptyPath = "";

    @BeforeAll
    public static void beforeAll() {
        jsonPath1 = "src/test/resources/fixtures/json/file1.json";
        jsonPath2 = "src/test/resources/fixtures/json/file2.json";
        jsonEmptyPath = "src/test/resources/fixtures/json/empty.json";
        yamlPath1 = "src/test/resources/fixtures/yaml/file1.yaml";
        yamlPath2 = "src/test/resources/fixtures/yaml/file2.yaml";
        yamlEmptyPath = "src/test/resources/fixtures/yaml/empty.yaml";
    }

    @Test
    public void testJsonDiffer1() throws Exception {
        var mapJson1 = Parser.parseData(jsonPath1);
        var mapJson2 = Parser.parseData(jsonPath2);
        var expected = Differ.generate(mapJson1, mapJson2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer1.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testJsonDiffer2() throws Exception {
        var mapJson1 = Parser.parseData(jsonPath1);
        var mapJson2 = Parser.parseData(jsonEmptyPath);
        var expected = Differ.generate(mapJson1, mapJson2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer2.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testJsonDiffer3() throws Exception {
        var mapJson1 = Parser.parseData(jsonEmptyPath);
        var mapJson2 = Parser.parseData(jsonPath2);
        var expected = Differ.generate(mapJson1, mapJson2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer3.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testJsonDiffer4() throws Exception {
        var mapJson1 = Parser.parseData(jsonEmptyPath);
        var mapJson2 = Parser.parseData(jsonEmptyPath);
        var expected = Differ.generate(mapJson1, mapJson2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer4.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testJYAMLDiffer1() throws Exception {
        var mapYAML1 = Parser.parseData(yamlPath1);
        var mapYAML2 = Parser.parseData(yamlPath2);
        var expected = Differ.generate(mapYAML1, mapYAML2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer1.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testYAMLDiffer2() throws Exception {
        var mapYAML1 = Parser.parseData(yamlPath1);
        var mapYAML2 = Parser.parseData(yamlEmptyPath);
        var expected = Differ.generate(mapYAML1, mapYAML2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer2.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testYAMLDiffer3() throws Exception {
        var mapYAML1 = Parser.parseData(yamlEmptyPath);
        var mapYAML2 = Parser.parseData(yamlPath2);
        var expected = Differ.generate(mapYAML1, mapYAML2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer3.txt");
        assertEquals(expected.toString(), actual);
    }

    @Test
    public void testYAMLDiffer4() throws Exception {
        var mapYAML1 = Parser.parseData(yamlEmptyPath);
        var mapYAML2 = Parser.parseData(yamlEmptyPath);
        var expected = Differ.generate(mapYAML1, mapYAML2);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDiffer4.txt");
        assertEquals(expected.toString(), actual);
    }

}
