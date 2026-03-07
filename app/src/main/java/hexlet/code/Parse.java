package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parse {

    public static Map<String, Object> parse(String content, String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            return parseJson(content);
        } else if (filePath.endsWith(".yml") || filePath.endsWith(".yaml"))  {
            return parseYaml(content);
        } else {
            throw new Exception("Unsupported file format: " + filePath);
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