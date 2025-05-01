package hexlet.code.differ;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.createFixtureFile;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    @Test
    void testDiffer() throws Exception {
        var expectedStylish = readFixture("test_addition_deletion_change", "expected", "stylish.txt");

        var firstJson = createFixtureFile("test_addition_deletion_change", "json", "first.json");
        var secondJson = createFixtureFile("test_addition_deletion_change", "json", "second.json");

        var firstYaml = createFixtureFile("test_addition_deletion_change", "yaml", "first.yaml");
        var secondYaml = createFixtureFile("test_addition_deletion_change", "yaml", "second.yaml");

        var actualJson = generate(firstJson, secondJson);
        var actualYaml = generate(firstYaml, secondYaml);

        assertEquals(expectedStylish, actualJson);
        assertEquals(expectedStylish, actualYaml);
    }
}
