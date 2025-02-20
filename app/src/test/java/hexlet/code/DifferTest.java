package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
    @BeforeEach
    public void beforeEach() {
        Stylish.cleanStringBuilder();
        Plain.cleanStringBuilder();
        Differ.clearData();
        Json.clearData();
    }

    @Test
    public void testJsonDiffer1() throws Exception {
        var actual = Differ.generate(jsonPath1, jsonPath2, "stylish");
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferStylish1.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonDiffer2() throws Exception {
        var actual = Differ.generate(jsonPath1, jsonEmptyPath, "stylish");
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferStylish2.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonDiffer3() throws Exception {
        var actual = Differ.generate(jsonEmptyPath, jsonPath2);
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferStylish3.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonDiffer4() throws Exception {
        var actual = Differ.generate(jsonEmptyPath, jsonEmptyPath);
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferStylish4.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testJYAMLDiffer1() throws Exception {
        var actual = Differ.generate(yamlPath1, yamlPath2, "plain");
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferPlain1.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testYAMLDiffer2() throws Exception {
        var actual = Differ.generate(yamlPath1, yamlEmptyPath, "plain");
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferPlain2.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testYAMLDiffer3() throws Exception {
        var actual = Differ.generate(yamlEmptyPath, yamlPath2, "plain");
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferPlain3.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testYAMLDiffer4() throws Exception {
        var actual = Differ.generate(yamlEmptyPath, yamlEmptyPath, "plain");
        Differ.clearData();
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultDifferPlain4.txt");
        assertEquals(expected, actual);
    }

}
