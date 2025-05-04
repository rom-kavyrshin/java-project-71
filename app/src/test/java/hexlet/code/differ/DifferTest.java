package hexlet.code.differ;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.createJsonNode;
import static hexlet.code.TestUtils.getFixturePath;
import static hexlet.code.TestUtils.readFixture;
import static hexlet.code.formatters.OutputFormatterFactory.JSON_OUTPUT_FORMAT_NAME;
import static hexlet.code.formatters.OutputFormatterFactory.PLAIN_OUTPUT_FORMAT_NAME;
import static hexlet.code.formatters.OutputFormatterFactory.STYLISH_OUTPUT_FORMAT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testDiffer() throws Exception {
        var expectedStylish = readFixture("test_addition_deletion_change", "expected", "stylish.txt");
        var expectedPlain = readFixture("test_addition_deletion_change", "expected", "plain.txt");
        var expectedJson = readFixture("test_addition_deletion_change", "expected", "json.txt");

        var firstJson = getFixturePath("test_addition_deletion_change", "json", "first.json").toString();
        var secondJson = getFixturePath("test_addition_deletion_change", "json", "second.json").toString();

        var firstYaml = getFixturePath("test_addition_deletion_change", "yaml", "first.yaml").toString();
        var secondYaml = getFixturePath("test_addition_deletion_change", "yaml", "second.yaml").toString();

        assertEquals(expectedStylish, generate(firstJson, secondJson, STYLISH_OUTPUT_FORMAT_NAME));
        assertEquals(expectedStylish, generate(firstYaml, secondYaml, STYLISH_OUTPUT_FORMAT_NAME));

        assertEquals(expectedPlain, generate(firstJson, secondJson, PLAIN_OUTPUT_FORMAT_NAME));
        assertEquals(expectedPlain, generate(firstYaml, secondYaml, PLAIN_OUTPUT_FORMAT_NAME));

        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(firstJson, secondJson, JSON_OUTPUT_FORMAT_NAME))
        );
        assertEquals(
                createJsonNode(expectedJson),
                createJsonNode(generate(firstYaml, secondYaml, JSON_OUTPUT_FORMAT_NAME))
        );
    }
}
