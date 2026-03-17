package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public final class JsonFormatter implements Formatter {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String format(List<Node> nodes) throws Exception {
        List<Map<String, Object>> diffList = nodes.stream()
                .map(this::nodeToMap)
                .collect(Collectors.toList());

        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(diffList);
    }

    private Map<String, Object> nodeToMap(Node node) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", node.getKey());
        map.put("status", node.getStatus());
        map.put("oldValue", node.getOldValue());
        map.put("newValue", node.getNewValue());
        return map;
    }
}
