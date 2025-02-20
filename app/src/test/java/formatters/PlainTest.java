package formatters;

import hexlet.code.Parser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void test1() throws Exception {
        String actual = Plain.plainFormat(dataList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/resultFormaterPlain.txt");
        assertEquals(expected, actual);
    }

    @Test
    public void test2() throws Exception {
        List<List<Object>> emptyList = List.of();
        String actual = Plain.plainFormat(emptyList);
        String expected = Parser.readFile("src/test/resources/fixtures/resultFiles/emptyFormaterPlain.txt");
        assertEquals(expected, actual);
    }
}
