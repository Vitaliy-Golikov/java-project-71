package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String content, Format format) throws Exception {
        if (format == null) {
            throw new Exception("Unable to determine file format. Supported formats: JSON, YAML");
        }
        switch (format) {
            case JSON:
                return parseJson(content);
            case YAML:
                return parseYaml(content);
            default:
                throw new Exception("Unsupported format: " + format);
        }
    }

    public static Format getFormatByExtension(String extension) throws Exception {
        if (extension == null) {
            throw new Exception("Unable to determine file format: file has no extension");
        }
        switch (extension) {
            case "json":
                return Format.JSON;
            case "yml":
            case "yaml":
                return Format.YAML;
            default:
                throw new Exception("Unsupported file extension: " + extension + ". Supported: json, yml, yaml");
        }
    }

    private static Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }

    private static Map<String, Object> parseYaml(String content) throws Exception {
        YAMLMapper mapper = new YAMLMapper();
        return mapper.readValue(content, Map.class);
    }
}
