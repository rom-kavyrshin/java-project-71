package hexlet.code.differ;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testDiffer() throws Exception {
        var firstJson = readFixture("test_json", "test_addition_deletion_change", "first.json");
        var secondJson = readFixture("test_json", "test_addition_deletion_change", "second.json");
        var expectedJson = readFixture("test_json", "test_addition_deletion_change", "expected.txt");

        var firstYaml = readFixture("test_yaml", "test_addition_deletion_change", "first.yaml");
        var secondYaml = readFixture("test_yaml", "test_addition_deletion_change", "second.yaml");
        var expectedYaml = readFixture("test_yaml", "test_addition_deletion_change", "expected.txt");

        var actualJson = generate(firstJson, secondJson);
        var actualYaml = generate(firstYaml, secondYaml);

        assertEquals(expectedJson, actualJson);
        assertEquals(expectedYaml, actualYaml);
    }
}
