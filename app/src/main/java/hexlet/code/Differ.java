package hexlet.code;

import hexlet.code.formatters.Formatter;
import hexlet.code.formatters.FormatterFactory;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        String content1 = Files.readString(Paths.get(filepath1));
        String content2 = Files.readString(Paths.get(filepath2));

        Format format1 = detectFormat(filepath1);
        Format format2 = detectFormat(filepath2);

        Map<String, Object> data1 = Parser.parse(content1, format1);
        Map<String, Object> data2 = Parser.parse(content2, format2);

        List<Node> differences = TreeBuilder.build(data1, data2);

        Formatter formatter = FormatterFactory.getFormatter(format);
        return formatter.format(differences);
    }

    private static Format detectFormat(String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            return Format.JSON;
        } else if (filePath.endsWith(".yml") || filePath.endsWith(".yaml")) {
            return Format.YAML;
        } else {
            throw new Exception("Unsupported file format: " + filePath);
        }
    }
}
