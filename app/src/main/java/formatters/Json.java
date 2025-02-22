package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.StatOfData;

import java.util.ArrayList;
import java.util.List;

public class Json {
    private static final List<PrepareDataForJson> DATA_FOR_JSON = new ArrayList<>();

    public static String jsonFormat(List<List<Object>> statOfData) throws JsonProcessingException {
        if (statOfData.isEmpty()) {
            return "{\n}";
        }
        for (List<Object> statOfElement : statOfData) {
            filterElements(statOfElement);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<PrepareDataForJson> result = new ArrayList<>(DATA_FOR_JSON);
        clearData();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

    }

    public static void filterElements(List<Object> statOfElement) {
        if (statOfElement.size() == StatOfData.SIZE_OF_UPDATED_ELEMENT
                && !statOfElement.get(StatOfData.INDEX_OF_STATUS_FOR_UPDATED).equals(StatOfData.SAME_DATA)) {
            DATA_FOR_JSON.add(new PrepareDataForJson(statOfElement.getFirst(), statOfElement.get(1),
                    statOfElement.get(2), statOfElement.get(StatOfData.INDEX_OF_STATUS_FOR_UPDATED)));
        } else if (!statOfElement.get(StatOfData.INDEX_OF_STATUS_FOR_ELEMENT).equals(StatOfData.SAME_DATA)) {
            DATA_FOR_JSON.add(new PrepareDataForJson(statOfElement.getFirst(), statOfElement.get(1),
                    statOfElement.get(StatOfData.INDEX_OF_STATUS_FOR_ELEMENT)));
        }
    }

    public static void clearData() {
        DATA_FOR_JSON.clear();
    }
}
