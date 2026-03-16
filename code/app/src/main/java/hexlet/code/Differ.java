package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");  // вызывает метод с форматом
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = Files.readString(Paths.get(filepath1));
        String content2 = Files.readString(Paths.get(filepath2));

        Map<String, Object> data1 = Parse.parse(content1, filepath1);
        Map<String, Object> data2 = Parse.parse(content2, filepath2);

        List<Node> differences = TreeBuilder.build(data1, data2);

        if ("stylish".equals(format)) {
            StylishFormatter formatter = new StylishFormatter();
            return formatter.format(differences);
        } else {
            throw new Exception("Unsupported format: " + format);
        }
    }
}
