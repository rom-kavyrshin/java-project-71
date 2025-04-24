package hexlet.code.differ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTestEmptyFiles {

    private static String emptyContentJson;
    private static String hasContentJson;

    private static String emptyContentYaml;
    private static String hasContentYaml;

    @BeforeAll
    public static void beforeAll() throws Exception {
        emptyContentJson = readFixture("test_json", "test_empty_file", "empty_content.json");
        hasContentJson = readFixture("test_json", "test_empty_file", "has_content.json");

        emptyContentYaml = readFixture("test_yaml", "test_empty_file", "empty_content.yaml");
        hasContentYaml = readFixture("test_yaml", "test_empty_file", "has_content.yaml");
    }

    @Test
    public void testDifferFirstFileEmpty() throws Exception {
        var expectedJson = readFixture("test_json", "test_empty_file", "first_file_empty_expected.txt");
        var expectedYaml = readFixture("test_yaml", "test_empty_file", "first_file_empty_expected.txt");

        var actualJson = generate(emptyContentJson, hasContentJson);
        var actualYaml = generate(emptyContentYaml, hasContentYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }

    @Test
    public void testDifferSecondFileEmpty() throws Exception {
        var expectedJson = readFixture("test_json", "test_empty_file", "second_file_empty_expected.txt");
        var expectedYaml = readFixture("test_yaml", "test_empty_file", "second_file_empty_expected.txt");

        var actualJson = generate(hasContentJson, emptyContentJson);
        var actualYaml = generate(hasContentYaml, emptyContentYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }

    @Test
    public void testDifferBothFileEmpty() throws Exception {
        var expectedJson = readFixture("test_json", "test_empty_file", "both_file_empty_expected.txt");
        var expectedYaml = readFixture("test_yaml", "test_empty_file", "both_file_empty_expected.txt");

        var actualJson = generate(emptyContentJson, emptyContentJson);
        var actualYaml = generate(emptyContentYaml, emptyContentYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }

}
