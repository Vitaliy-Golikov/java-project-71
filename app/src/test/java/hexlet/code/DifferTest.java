package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class DifferTest {

    private String readExpected(String filename) throws Exception {
        Path path = Path.of("src/test/resources/fixtures/" + filename);
        return Files.readString(path)
                .replace("\r\n", "\n")
                .trim();
    }

    @Test
    public void testGenerateJsonStylish() throws Exception {
        String expected = readExpected("expected_stylish_simple.txt");
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.json",
                "src/test/resources/fixtures/testFile2.json"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlStylish() throws Exception {
        String expected = readExpected("expected_stylish_simple.txt");
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.yml",
                "src/test/resources/fixtures/testFile2.yml"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateAttachJsonStylish() throws Exception {
        String expected = readExpected("expected_stylish_attach.txt");
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFileAttach1.json",
                "src/test/resources/fixtures/testFileAttach2.json"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testGeneratePlain() throws Exception {
        String expected = readExpected("expected_plain_simple.txt");
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.json",
                "src/test/resources/fixtures/testFile2.json",
                "plain"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateAttachPlain() throws Exception {
        String expected = readExpected("expected_plain_attach.txt");
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFileAttach1.json",
                "src/test/resources/fixtures/testFileAttach2.json",
                "plain"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJsonFormat() throws Exception {
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.json",
                "src/test/resources/fixtures/testFile2.json",
                "json"
        );

        assertTrue(actual != null && !actual.isEmpty());
        assertTrue(actual.contains("follow"));
        assertTrue(actual.contains("timeout"));
        assertTrue(actual.contains("verbose"));
    }

    @Test
    public void testGenerateAttachJsonFormat() throws Exception {
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFileAttach1.json",
                "src/test/resources/fixtures/testFileAttach2.json",
                "json"
        );

        assertTrue(actual != null && !actual.isEmpty());
        assertTrue(actual.contains("setting1"));
        assertTrue(actual.contains("chars2"));
        assertTrue(actual.contains("obj1"));
    }

    @Test
    public void testGenerateYamlPlain() throws Exception {
        String expected = readExpected("expected_plain_simple.txt");
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.yml",
                "src/test/resources/fixtures/testFile2.yml",
                "plain"
        );
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYamlJson() throws Exception {
        String actual = Differ.generate(
                "src/test/resources/fixtures/testFile1.yml",
                "src/test/resources/fixtures/testFile2.yml",
                "json"
        );

        assertTrue(actual != null && !actual.isEmpty());
        assertTrue(actual.contains("follow"));
        assertTrue(actual.contains("timeout"));
    }

    @Test
    public void testDefaultFormat() throws Exception {
        String expectedStylish = readExpected("expected_stylish_simple.txt");

        String actualWithoutFormat = Differ.generate(
                "src/test/resources/fixtures/testFile1.json",
                "src/test/resources/fixtures/testFile2.json"
        );

        String actualStylish = Differ.generate(
                "src/test/resources/fixtures/testFile1.json",
                "src/test/resources/fixtures/testFile2.json",
                "stylish"
        );

        assertEquals(expectedStylish, actualWithoutFormat);
        assertEquals(actualStylish, actualWithoutFormat);
    }

    @Test
    public void testUnsupportedFormat() {
        try {
            Differ.generate(
                    "src/test/resources/fixtures/testFile1.json",
                    "src/test/resources/fixtures/testFile2.json",
                    "unsupported"
            );
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Unsupported format: unsupported", e.getMessage());
        }
    }
}
