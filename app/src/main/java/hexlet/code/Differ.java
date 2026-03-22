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

        String extension1 = getFileExtension(filepath1);
        String extension2 = getFileExtension(filepath2);

        Format format1 = Parser.getFormatByExtension(extension1);
        Format format2 = Parser.getFormatByExtension(extension2);

        Map<String, Object> data1 = Parser.parse(content1, format1);
        Map<String, Object> data2 = Parser.parse(content2, format2);

        List<Node> differences = TreeBuilder.build(data1, data2);

        Formatter formatter = FormatterFactory.getFormatter(format);
        return formatter.format(differences);
    }

    /**
     * Извлекает расширение файла из пути.
     * Возвращает строку после последней точки, например "json", "yml", "yaml".
     * Если у файла нет расширения, возвращает null.
     */
    private static String getFileExtension(String filePath) {
        int lastDotIndex = filePath.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < filePath.length() - 1) {
            return filePath.substring(lastDotIndex + 1).toLowerCase();
        }
        return null;
    }
}
