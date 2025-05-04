package hexlet.code.differ;

import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;
import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.createFixtureFile;
import static hexlet.code.TestUtils.createJsonNode;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testDiffer() throws Exception {
        var expectedStylish = readFixture("test_addition_deletion_change", "expected", "stylish.txt");
        var expectedPlain = readFixture("test_addition_deletion_change", "expected", "plain.txt");
        var expectedJson = readFixture("test_addition_deletion_change", "expected", "json.txt");

        var firstJson = createFixtureFile("test_addition_deletion_change", "json", "first.json");
        var secondJson = createFixtureFile("test_addition_deletion_change", "json", "second.json");

        var firstYaml = createFixtureFile("test_addition_deletion_change", "yaml", "first.yaml");
        var secondYaml = createFixtureFile("test_addition_deletion_change", "yaml", "second.yaml");

        assertEquals(expectedStylish, generate(firstJson, secondJson, new StylishFormatter()));
        assertEquals(expectedStylish, generate(firstYaml, secondYaml, new StylishFormatter()));

        assertEquals(expectedPlain, generate(firstJson, secondJson, new PlainFormatter()));
        assertEquals(expectedPlain, generate(firstYaml, secondYaml, new PlainFormatter()));

        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(firstJson, secondJson, new JsonFormatter()))
        );
        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(firstYaml, secondYaml, new JsonFormatter()))
        );
    }
}
