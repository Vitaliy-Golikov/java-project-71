package hexlet.code.formatters;

import hexlet.code.Node;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlainFormatter implements Formatter {
    @Override
    public String format(List<Node> nodes) {
        return nodes.stream()
                .map(this::formatNode)
                .filter(line -> !line.isEmpty())
                .collect(Collectors.joining("\n"));
    }

    private String formatNode(Node node) {
        String key = node.getKey();
        String status = node.getStatus();

        switch (status) {
            case "added":
                return String.format("Property '%s' was added with value: %s",
                        key, stringify(node.getNewValue()));
            case "deleted":
                return String.format("Property '%s' was removed", key);
            case "changed":
                return String.format("Property '%s' was updated. From %s to %s",
                        key, stringify(node.getOldValue()), stringify(node.getNewValue()));
            case "unchanged":
                return "";
            default:
                throw new IllegalArgumentException("Unknown status: " + status);
        }
    }

    private String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof List || value instanceof Map) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }
}