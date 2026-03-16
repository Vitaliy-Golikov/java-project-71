package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Node {
    private String key;
    private String status;
    private Object oldValue;
    private Object newValue;

    public Node(String key, String status, Object value) {
        this.key = key;
        this.status = status;
        this.oldValue = value;
        this.newValue = value;
    }

}
