package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatOfDataTest {

    @BeforeEach
    void setUp() {
        StatOfData.clearData();
    }

    @Test
    public void testSameData() throws Exception {
        ArrayList<List<Object>> result = StatOfData.getStatOfData("src/test/resources/fixtures/json/smallJson1.json",
                "src/test/resources/fixtures/json/smallJson1.json");
        assertEquals(1, result.size());
        assertEquals("same data", result.get(0).get(2));
    }

    @Test
    public void testAdded() throws Exception {
        ArrayList<List<Object>> result = StatOfData.getStatOfData("src/test/resources/fixtures/json/empty.json",
                "src/test/resources/fixtures/json/smallJson1.json");
        assertEquals(1, result.size());
        assertEquals("added", result.get(0).get(2));
    }

    @Test
    public void testRemoved() throws Exception {
        ArrayList<List<Object>> result = StatOfData.getStatOfData("src/test/resources/fixtures/json/smallJson1.json",
                "src/test/resources/fixtures/json/empty.json");
        assertEquals(1, result.size());
        assertEquals("removed", result.get(0).get(2));
    }

    @Test
    public void testUpdated() throws Exception {
        ArrayList<List<Object>> result = StatOfData.getStatOfData("src/test/resources/fixtures/json/smallJson1.json",
                "src/test/resources/fixtures/json/smallJson2.json");
        assertEquals(1, result.size());
        assertEquals("updated", result.get(0).get(3));
        assertEquals("Some value", result.get(0).get(1));
        assertEquals(true, result.get(0).get(2));
    }
}
