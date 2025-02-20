package hexlet.code;

import formatters.Plain;
import formatters.Stylish;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormaterTest {

    private static List<List<Object>> dataList;
    @BeforeAll
    public static void beforeAll() {
        dataList = new ArrayList<>();
        dataList.add(List.of("Item1", 3.14, "added"));
        dataList.add(List.of("Item2", true, "removed"));
        dataList.add(List.of("Item3", 45, "removed"));
    }

    @BeforeEach
    public void beforeEach() {
        Plain.cleanStringBuilder();
        Stylish.cleanStringBuilder();
    }

    @Test
    public void test1() {
        String actual = Formatter.chooseFormat(dataList, "stylish");
        Stylish.cleanStringBuilder();
        String expected = Stylish.stylishFormat(dataList);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String actual = Formatter.chooseFormat(dataList, "plain");
        Plain.cleanStringBuilder();
        String expected = Plain.plainFormat(dataList);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String actual = Formatter.chooseFormat(dataList, "12345");
        String expected = "Invalid format!";
        assertEquals(expected, actual);
    }
}
