package hexlet.code;

import java.util.*;

public class TreeBuilder {
    public static List<Node> build(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());

        List<Node> nodes = new ArrayList<>();

        for (String key : allKeys) {
            boolean firstKey = data1.containsKey(key);
            boolean secondKey = data2.containsKey(key);

            if (firstKey && !secondKey) {
                nodes.add(new Node(key, "deleted", data1.get(key)));
            } else if (!firstKey && secondKey) {
                nodes.add(new Node(key, "added", data2.get(key)));
            } else {
                Object value1 = data1.get(key);
                Object value2 = data2.get(key);

                if (value1 == null && value2 == null) {
                    nodes.add(new Node(key, "unchanged", null));
                } else if (value1 == null) {
                    nodes.add(new Node(key, "changed", null, value2));
                } else if (value2 == null) {
                    nodes.add(new Node(key, "changed", value1, null));
                } else if (value1.equals(value2)) {
                    nodes.add(new Node(key, "unchanged", value1));
                } else {
                    nodes.add(new Node(key, "changed", value1, value2));
                }
            }
        }
        return nodes;
    }
}
