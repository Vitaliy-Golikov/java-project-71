package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerateJson() throws Exception {
        String expected = "{\n" +
                "  - follow: false\n" +
                "    host: hexlet.io\n" +
                "  - proxy: 123.234.53.22\n" +
                "  - timeout: 50\n" +
                "  + timeout: 20\n" +
                "  + verbose: true\n" +
                "}";

        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.json",
                "src/test/resources/fixtures/testFile2.json"
        );

        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYaml() throws Exception {
        String expected = "{\n" +
                "  - follow: false\n" +
                "    host: hexlet.io\n" +
                "  - proxy: 123.234.53.22\n" +
                "  - timeout: 50\n" +
                "  + timeout: 20\n" +
                "  + verbose: true\n" +
                "}";

        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.yml",
                "src/test/resources/fixtures/testFile2.yml"
        );

        assertEquals(expected, actual);
    }
}