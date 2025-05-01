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
        emptyContentJson = createFixtureFile("test_empty_file", "json", "empty_content.json");
        hasContentJson = createFixtureFile("test_empty_file", "json", "has_content.json");

        emptyContentYaml = createFixtureFile("test_empty_file", "yaml", "empty_content.yaml");
        hasContentYaml = createFixtureFile("test_empty_file", "yaml", "has_content.yaml");
    }

    @Test
    void testDifferFirstFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "first_file_empty_expected.txt");

        var actualJson = generate(emptyContentJson, hasContentJson);
        var actualYaml = generate(emptyContentYaml, hasContentYaml);

        assertEquals(expectedStylish, actualJson);
        assertEquals(expectedStylish, actualYaml);
    }

    @Test
    void testDifferSecondFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "second_file_empty_expected.txt");

        var actualJson = generate(hasContentJson, emptyContentJson);
        var actualYaml = generate(hasContentYaml, emptyContentYaml);

        assertEquals(expectedStylish, actualJson);
        assertEquals(expectedStylish, actualYaml);
    }

    @Test
    void testDifferBothFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "both_file_empty_expected.txt");

        var actualJson = generate(emptyContentJson, emptyContentJson);
        var actualYaml = generate(emptyContentYaml, emptyContentYaml);

        assertEquals(expectedStylish, actualJson);
        assertEquals(expectedStylish, actualYaml);
    }

}
