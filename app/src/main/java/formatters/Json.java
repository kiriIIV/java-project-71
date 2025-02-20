package formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Json {

    private static final List<PrepareDataForJson> DATA_FOR_JSON = new ArrayList<>();

    public static String jsonFormat(List<List<Object>> statOfData) throws JsonProcessingException {
        if (statOfData.isEmpty()) {
            return "{\n}";
        }

        for (List<Object> statOfElement : statOfData) {
            if (statOfElement.size() == 4 && !statOfElement.get(3).equals("same data")) {
                DATA_FOR_JSON.add(new PrepareDataForJson(statOfElement.get(0), statOfElement.get(1),
                        statOfElement.get(2), statOfElement.get(3)));
            } else if (!statOfElement.get(2).equals("same data")) {
                DATA_FOR_JSON.add(new PrepareDataForJson(statOfElement.get(0), statOfElement.get(1),
                        statOfElement.get(2)));
            }
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<PrepareDataForJson> result = new ArrayList<>(DATA_FOR_JSON);
        clearData();
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);

    }

    public static void clearData() {
        DATA_FOR_JSON.clear();
    }
}
