package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testDiffer() throws Exception {
        var first = readFixture("test_json", "test_addition_deletion_change", "first.json");
        var second = readFixture("test_json", "test_addition_deletion_change", "second.json");
        var expected = readFixture("test_json", "test_addition_deletion_change", "expected.txt");

        var actual = generate(first, second);

        assertEquals(expected, actual);
    }
}
