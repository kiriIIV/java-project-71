package hexlet.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormaterTest {

    @Test
    public void test1() throws Exception {
        Map<String, Object> yamlData1 = Parser.parseData("src/test/resources/fixtures/yaml/file1.yaml");
        Map<String, Object> yamlData2 = Parser.parseData("src/test/resources/fixtures/yaml/file1.yaml");
        List<List<String>> listOfKeysAndValues = Differ.generate(yamlData1, yamlData2);
        String expected = Formater.stylishFormat(listOfKeysAndValues);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/resultFormater.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        List<List<String>> emptyList = List.of();
        String expected = Formater.stylishFormat(emptyList);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/emptyFormater.txt");
        assertEquals(expected, actual);
    }
}
