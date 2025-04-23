package hexlet.code;

import org.junit.jupiter.api.Test;



import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTestEmptyFiles {

    @Test
    public void testDifferFirstFileEmpty() throws Exception {
        var first = readFixture("test_json", "test_empty_file", "empty_content.json");
        var second = readFixture("test_json", "test_empty_file", "has_content.json");
        var expected = readFixture("test_json", "test_empty_file", "first_file_empty_expected.txt");

        var actual = generate(first, second);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferSecondFileEmpty() throws Exception {
        var first = readFixture("test_json", "test_empty_file", "has_content.json");
        var second = readFixture("test_json", "test_empty_file", "empty_content.json");
        var expected = readFixture("test_json", "test_empty_file", "second_file_empty_expected.txt");

        var actual = generate(first, second);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferBothFileEmpty() throws Exception {
        var first = readFixture("test_json", "test_empty_file", "empty_content.json");
        var second = readFixture("test_json", "test_empty_file", "empty_content.json");
        var expected = readFixture("test_json", "test_empty_file", "both_file_empty_expected.txt");

        var actual = generate(first, second);

        assertEquals(expected, actual);
    }

}
