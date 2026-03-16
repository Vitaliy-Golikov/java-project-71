package hexlet.code.formatters;

import hexlet.code.Node;
import java.util.List;

public interface Formatter {
    String format(List<Node> differences) throws Exception;
}