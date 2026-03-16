package hexlet.code.formatters;

import hexlet.code.Node;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StylishFormatter implements Formatter {
    @Override
    public String format(List<Node> nodes) {
        StringBuilder result = new StringBuilder("{\n");

        for (Node node : nodes) {
            String key = node.getKey();

            switch (node.getStatus()) {
                case "deleted":
                    result.append("  - ").append(key).append(": ")
                            .append(stringify(node.getOldValue())).append("\n");
                    break;
                case "added":
                    result.append("  + ").append(key).append(": ")
                            .append(stringify(node.getNewValue())).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(key).append(": ")
                            .append(stringify(node.getOldValue())).append("\n");
                    break;
                case "changed":
                    result.append("  - ").append(key).append(": ")
                            .append(stringify(node.getOldValue())).append("\n");
                    result.append("  + ").append(key).append(": ")
                            .append(stringify(node.getNewValue())).append("\n");
                    break;
            }
        }

        result.append("}");
        return result.toString();
    }

    private String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return (String) value;
        }
        if (value instanceof List) {
            return "[" + ((List<?>) value).stream()
                    .map(this::stringifyElement)
                    .collect(Collectors.joining(", ")) + "]";
        }
        if (value instanceof Map) {
            return "{" + ((Map<?, ?>) value).entrySet().stream()
                    .map(e -> e.getKey() + "=" + stringifyElement(e.getValue()))
                    .collect(Collectors.joining(", ")) + "}";
        }
        return value.toString();
    }

    private String stringifyElement(Object element) {
        if (element instanceof String) {
            return (String) element;
        }
        return String.valueOf(element);
    }
}