package hexlet.code;

import java.util.*;

public class StylishFormatter implements Formatter {
    @Override
    public String format(List<Node> nodes) {
        StringBuilder result = new StringBuilder("{\n");

        for (Node node : nodes) {
            String key = node.getKey();

            switch (node.getStatus()) {
                case "deleted":
                    result.append("  - ").append(key).append(": ")
                            .append(node.getOldValue()).append("\n");
                    break;
                case "added":
                    result.append("  + ").append(key).append(": ")
                            .append(node.getNewValue()).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(key).append(": ")
                            .append(node.getOldValue()).append("\n");
                    break;
                case "changed":
                    result.append("  - ").append(key).append(": ")
                            .append(node.getOldValue()).append("\n");
                    result.append("  + ").append(key).append(": ")
                            .append(node.getNewValue()).append("\n");
                    break;
            }
        }

        result.append("}");
        return result.toString();
    }
}
