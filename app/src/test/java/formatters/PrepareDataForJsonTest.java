package formatters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrepareDataForJsonTest {

    @Test
    public void test1() {
        PrepareDataForJson prepareDataForJson = new PrepareDataForJson("key", 123,
                456, "updated");
        assertEquals("key", prepareDataForJson.getKey());
        assertEquals(123, prepareDataForJson.getOldValue());
        assertEquals(456, prepareDataForJson.getNewValue());
        assertEquals("updated", prepareDataForJson.getStatusKey());
    }

    @Test
    public void test2() {
        PrepareDataForJson prepareDataForJson = new PrepareDataForJson("key", 123, "removed");
        assertEquals("key", prepareDataForJson.getKey());
        assertEquals(123, prepareDataForJson.getValue());
        assertEquals("removed", prepareDataForJson.getStatusKey());
    }
}
