package hexlet.code.differ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.createFixtureFile;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferEmptyFilesTest {

    private static File emptyContentJson;
    private static File hasContentJson;

    private static File emptyContentYaml;
    private static File hasContentYaml;

    @BeforeAll
    static void beforeAll() {
        emptyContentJson = createFixtureFile("test_json", "test_empty_file", "empty_content.json");
        hasContentJson = createFixtureFile("test_json", "test_empty_file", "has_content.json");

        emptyContentYaml = createFixtureFile("test_yaml", "test_empty_file", "empty_content.yaml");
        hasContentYaml = createFixtureFile("test_yaml", "test_empty_file", "has_content.yaml");
    }

    @Test
    void testDifferFirstFileEmpty() throws Exception {
        var expectedJson = readFixture("test_json", "test_empty_file", "first_file_empty_expected.txt");
        var expectedYaml = readFixture("test_yaml", "test_empty_file", "first_file_empty_expected.txt");

        var actualJson = generate(emptyContentJson, hasContentJson);
        var actualYaml = generate(emptyContentYaml, hasContentYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }

    @Test
    void testDifferSecondFileEmpty() throws Exception {
        var expectedJson = readFixture("test_json", "test_empty_file", "second_file_empty_expected.txt");
        var expectedYaml = readFixture("test_yaml", "test_empty_file", "second_file_empty_expected.txt");

        var actualJson = generate(hasContentJson, emptyContentJson);
        var actualYaml = generate(hasContentYaml, emptyContentYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }

    @Test
    void testDifferBothFileEmpty() throws Exception {
        var expectedJson = readFixture("test_json", "test_empty_file", "both_file_empty_expected.txt");
        var expectedYaml = readFixture("test_yaml", "test_empty_file", "both_file_empty_expected.txt");

        var actualJson = generate(emptyContentJson, emptyContentJson);
        var actualYaml = generate(emptyContentYaml, emptyContentYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }

}
