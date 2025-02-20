package formatters;

import hexlet.code.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StylishTest {

    private static List<List<Object>> dataList;
    @BeforeAll
    public static void beforeAll() {
        dataList = new ArrayList<>();
        dataList.add(List.of("Item2", 3.14, "added"));
        dataList.add(List.of("Item3", true, "removed"));
    }

    @BeforeEach
    public void beforeEach() {
        Stylish.cleanStringBuilder();
    }

    @Test
    public void test1() throws Exception {
        String actual = Stylish.stylishFormat(dataList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultFormaterStylish.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        List<List<Object>> emptyList = List.of();
        String expected = Stylish.stylishFormat(emptyList);
        String actual = Parser.readFile("src/test/resources/fixtures/resultFiles/emptyFormaterStylish.txt");
        assertEquals(expected, actual);
    }
}
