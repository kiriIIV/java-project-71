package formatters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PrepareDataForJsonTest {

    @Test
    public void test1() {
        PrepareDataForJson prepareDataForJson = new PrepareDataForJson("key", true,
                false, "updated");
        assertEquals("key", prepareDataForJson.getKey());
        assertEquals(true, prepareDataForJson.getOldValue());
        assertEquals(false, prepareDataForJson.getNewValue());
        assertEquals("updated", prepareDataForJson.getStatusKey());
    }

    @Test
    public void test2() {
        PrepareDataForJson prepareDataForJson = new PrepareDataForJson("key", null, "removed");
        assertEquals("key", prepareDataForJson.getKey());
        assertNull(prepareDataForJson.getValue());
        assertEquals("removed", prepareDataForJson.getStatusKey());
    }
}
