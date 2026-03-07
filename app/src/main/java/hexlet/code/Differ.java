package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        // Читаем содержимое файлов
        String content1 = Files.readString(Paths.get(filepath1));
        String content2 = Files.readString(Paths.get(filepath2));

        Map<String, Object> data1 = Parse.parse(content1, filepath1);
        Map<String, Object> data2 = Parse.parse(content2, filepath2);

        StringBuilder result = new StringBuilder("{\n");

        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        for (String key : allKeys) {
            boolean firstKey = data1.containsKey(key);
            boolean secondKey = data2.containsKey(key);

            if (firstKey && !secondKey) {
                result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
            } else if (!firstKey && secondKey) {
                result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
            } else {
                Object value1 = data1.get(key);
                Object value2 = data2.get(key);

                if (value1.equals(value2)) {
                    result.append("    ").append(key).append(": ").append(data1.get(key)).append("\n");
                } else {
                    result.append("  - ").append(key).append(": ").append(data1.get(key)).append("\n");
                    result.append("  + ").append(key).append(": ").append(data2.get(key)).append("\n");
                }
            }
        }

        result.append("}");

        return result.toString();
    }
}