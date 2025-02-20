package formatters;

import hexlet.code.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    private static List<List<Object>> dataList;
    @BeforeAll
    public static void beforeAll() {
        dataList = new ArrayList<>();
        dataList.add(List.of("Item1", "rat", "added"));
        dataList.add(List.of("Item2", true, "removed"));
        dataList.add(List.of("Item3", "123", "removed"));
        dataList.add(List.of("Item4", true, false, "updated"));
    }

    @BeforeEach
    public final void beforeEach() {
        Json.clearData();
    }

    @Test
    public void test1() throws Exception {
        String actual = Json.jsonFormat(dataList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultFormaterJson.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        List<List<Object>> emptyList = List.of();
        String actual = Json.jsonFormat(emptyList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/emptyFormaterJson.txt");
        assertEquals(expected, actual);
    }
}
