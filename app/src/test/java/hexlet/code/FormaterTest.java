package hexlet.code;

import formatters.Json;
import formatters.Plain;
import formatters.Stylish;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FormaterTest {

    private static List<List<Object>> dataList;
    @BeforeAll
    public static void beforeAll() {
        dataList = new ArrayList<>();
        dataList.add(List.of("Item1", "123", "added"));
        dataList.add(List.of("Item2", true, "removed"));
        dataList.add(List.of("Item3", false, "removed"));
    }

    @BeforeEach
    public final void beforeEach() {
        Plain.cleanStringBuilder();
        Stylish.cleanStringBuilder();
        Json.clearData();
    }

    @Test
    public void testStylish() throws Exception {
        String actual = Formatter.chooseFormat(dataList, "stylish");

        String expected = Stylish.stylishFormat(dataList);

        assertEquals(expected, actual);
    }

    @Test
    public void testPlain() throws Exception {
        String actual = Formatter.chooseFormat(dataList, "plain");

        String expected = Plain.plainFormat(dataList);

        assertEquals(expected, actual);
    }

    @Test
    public void testJson() throws Exception {
        String actual = Formatter.chooseFormat(dataList, "json");

        String expected = Json.jsonFormat(dataList);

        assertEquals(expected, actual);
    }

    @Test
    public void testException()  throws Exception {
        assertThrows(Exception.class, () -> Formatter.chooseFormat(dataList, "12345"));
    }
}
