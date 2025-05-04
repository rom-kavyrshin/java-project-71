package hexlet.code.differ;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.createFixtureFile;
import static hexlet.code.TestUtils.createJsonNode;
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
        var expectedPlain = readFixture("test_empty_file", "expected", "plain", "first_file_empty_expected.txt");
        var expectedJson = readFixture("test_empty_file", "expected", "json", "first_file_empty_expected.txt");

        assertEquals(expectedStylish, generate(emptyContentJson, hasContentJson, new StylishFormatter()));
        assertEquals(expectedStylish, generate(emptyContentYaml, hasContentYaml, new StylishFormatter()));

        assertEquals(expectedPlain, generate(emptyContentJson, hasContentJson, new PlainFormatter()));
        assertEquals(expectedPlain, generate(emptyContentYaml, hasContentYaml, new PlainFormatter()));

        assertEquals(createJsonNode(expectedJson), createJsonNode(generate(emptyContentJson, hasContentJson, new JsonFormatter())));
        assertEquals(createJsonNode(expectedJson), createJsonNode(generate(emptyContentYaml, hasContentYaml, new JsonFormatter())));
    }

    @Test
    void testDifferSecondFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "second_file_empty_expected.txt");
        var expectedPlain = readFixture("test_empty_file", "expected", "plain", "second_file_empty_expected.txt");
        var expectedJson = readFixture("test_empty_file", "expected", "json", "second_file_empty_expected.txt");

        assertEquals(expectedStylish, generate(hasContentJson, emptyContentJson, new StylishFormatter()));
        assertEquals(expectedStylish, generate(hasContentYaml, emptyContentYaml, new StylishFormatter()));

        assertEquals(expectedPlain, generate(hasContentJson, emptyContentJson, new PlainFormatter()));
        assertEquals(expectedPlain, generate(hasContentYaml, emptyContentYaml, new PlainFormatter()));

        assertEquals(createJsonNode(expectedJson), createJsonNode(generate(hasContentJson, emptyContentJson, new JsonFormatter())));
        assertEquals(createJsonNode(expectedJson), createJsonNode(generate(hasContentYaml, emptyContentYaml, new JsonFormatter())));
    }

    @Test
    void testDifferBothFileEmpty() throws Exception {
        var expectedStylish = readFixture("test_empty_file", "expected", "stylish", "both_file_empty_expected.txt");
        var expectedPlain = readFixture("test_empty_file", "expected", "plain", "both_file_empty_expected.txt");
        var expectedJson = readFixture("test_empty_file", "expected", "json", "both_file_empty_expected.txt");

        assertEquals(expectedStylish, generate(emptyContentJson, emptyContentJson, new StylishFormatter()));
        assertEquals(expectedStylish, generate(emptyContentYaml, emptyContentYaml, new StylishFormatter()));

        assertEquals(expectedPlain, generate(emptyContentJson, emptyContentJson, new PlainFormatter()));
        assertEquals(expectedPlain, generate(emptyContentYaml, emptyContentYaml, new PlainFormatter()));

        assertEquals(createJsonNode(expectedJson), createJsonNode(generate(emptyContentJson, emptyContentJson, new JsonFormatter())));
        assertEquals(createJsonNode(expectedJson), createJsonNode(generate(emptyContentYaml, emptyContentYaml, new JsonFormatter())));
    }

}
