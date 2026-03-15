package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.util.Map;

public class Parse {
    public static Map<String, Object> parse(String content, String filePath) throws Exception {
        if (filePath.endsWith(".json")) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(content, Map.class);
        } else if (filePath.endsWith(".yml") || filePath.endsWith(".yaml")) {
            YAMLMapper mapper = new YAMLMapper();
            return mapper.readValue(content, Map.class);
        } else {
            throw new Exception("Unsupported file format: " + filePath);
        }
    }
}
