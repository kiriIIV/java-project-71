package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class Differ {
    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        ArrayList<List<Object>> statOfData = StatOfData.getStatOfData(filePath1, filePath2);
        return Formatter.chooseFormat(statOfData, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, Formatter.STYLISH);
    }
}
