package formatters;

import hexlet.code.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlainTest {

    private static List<List<Object>> dataList;
    @BeforeAll
    public static void beforeAll() {
        dataList = new ArrayList<>();
        dataList.add(List.of("Item1", false, "added"));
        dataList.add(List.of("Item2", true, "removed"));
        dataList.add(List.of("Item3", "house", "removed"));
    }

    @BeforeEach
    public final void beforeEach() {
        Plain.cleanStringBuilder();
    }

    @Test
    public void testData() throws Exception {
        String actual = Plain.plainFormat(dataList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultFormaterPlain.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyData() throws Exception {
        List<List<Object>> emptyList = List.of();
        String actual = Plain.plainFormat(emptyList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/emptyFormaterPlain.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void testString() {
        String actual = Plain.isString("House");
        String expected = "'House'";
        assertEquals(expected, actual);
    }

    @Test
    public void testNotString() {
        String actual = Plain.isString(true);
        String expected = "true";
        assertEquals(expected, actual);
    }

    @Test
    public void testObject() {
        boolean actual = Plain.isObject(new Integer[] {1, 2, 3});
        assertTrue(actual);
    }

    @Test
    public void testNotObject() {
        boolean actual = Plain.isObject("Cat");
        assertFalse(actual);
    }
}
