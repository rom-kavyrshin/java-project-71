package hexlet.code.differ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.createJsonNode;
import static hexlet.code.TestUtils.getFixturePath;
import static hexlet.code.TestUtils.readFixture;
import static hexlet.code.formatters.OutputFormatterFactory.JSON_OUTPUT_FORMAT_NAME;
import static hexlet.code.formatters.OutputFormatterFactory.PLAIN_OUTPUT_FORMAT_NAME;
import static hexlet.code.formatters.OutputFormatterFactory.STYLISH_OUTPUT_FORMAT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferEmptyFilesTest {

    private static String emptyContentJson;
    private static String hasContentJson;

    private static String emptyContentYaml;
    private static String hasContentYaml;

    @BeforeAll
    static void beforeAll() {
        emptyContentJson = getFixturePath("test_empty_file", "json", "empty_content.json").toString();
        hasContentJson = getFixturePath("test_empty_file", "json", "has_content.json").toString();

        emptyContentYaml = getFixturePath("test_empty_file", "yaml", "empty_content.yaml").toString();
        hasContentYaml = getFixturePath("test_empty_file", "yaml", "has_content.yaml").toString();
    }

    @Test
    void testDifferFirstFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "first_file_empty_expected.txt");
        var expectedPlain = readFixture("test_empty_file", "expected", "plain", "first_file_empty_expected.txt");
        var expectedJson = readFixture("test_empty_file", "expected", "json", "first_file_empty_expected.txt");

        assertEquals(expectedStylish, generate(emptyContentJson, hasContentJson, STYLISH_OUTPUT_FORMAT_NAME));
        assertEquals(expectedStylish, generate(emptyContentYaml, hasContentYaml, STYLISH_OUTPUT_FORMAT_NAME));

        assertEquals(expectedPlain, generate(emptyContentJson, hasContentJson, PLAIN_OUTPUT_FORMAT_NAME));
        assertEquals(expectedPlain, generate(emptyContentYaml, hasContentYaml, PLAIN_OUTPUT_FORMAT_NAME));

        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(emptyContentJson, hasContentJson, JSON_OUTPUT_FORMAT_NAME))
        );
        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(emptyContentYaml, hasContentYaml, JSON_OUTPUT_FORMAT_NAME))
        );
    }

    @Test
    void testDifferSecondFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "second_file_empty_expected.txt");
        var expectedPlain = readFixture("test_empty_file", "expected", "plain", "second_file_empty_expected.txt");
        var expectedJson = readFixture("test_empty_file", "expected", "json", "second_file_empty_expected.txt");

        assertEquals(expectedStylish, generate(hasContentJson, emptyContentJson, STYLISH_OUTPUT_FORMAT_NAME));
        assertEquals(expectedStylish, generate(hasContentYaml, emptyContentYaml, STYLISH_OUTPUT_FORMAT_NAME));

        assertEquals(expectedPlain, generate(hasContentJson, emptyContentJson, PLAIN_OUTPUT_FORMAT_NAME));
        assertEquals(expectedPlain, generate(hasContentYaml, emptyContentYaml, PLAIN_OUTPUT_FORMAT_NAME));

        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(hasContentJson, emptyContentJson, JSON_OUTPUT_FORMAT_NAME))
        );
        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(hasContentYaml, emptyContentYaml, JSON_OUTPUT_FORMAT_NAME))
        );
    }

    @Test
    void testDifferBothFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "both_file_empty_expected.txt");
        var expectedPlain = readFixture("test_empty_file", "expected", "plain", "both_file_empty_expected.txt");
        var expectedJson = readFixture("test_empty_file", "expected", "json", "both_file_empty_expected.txt");

        assertEquals(expectedStylish, generate(emptyContentJson, emptyContentJson, STYLISH_OUTPUT_FORMAT_NAME));
        assertEquals(expectedStylish, generate(emptyContentYaml, emptyContentYaml, STYLISH_OUTPUT_FORMAT_NAME));

        assertEquals(expectedPlain, generate(emptyContentJson, emptyContentJson, PLAIN_OUTPUT_FORMAT_NAME));
        assertEquals(expectedPlain, generate(emptyContentYaml, emptyContentYaml, PLAIN_OUTPUT_FORMAT_NAME));

        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(emptyContentJson, emptyContentJson, JSON_OUTPUT_FORMAT_NAME))
        );
        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(emptyContentYaml, emptyContentYaml, JSON_OUTPUT_FORMAT_NAME))
        );
    }

}
