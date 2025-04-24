package hexlet.code.differ;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static hexlet.code.Differ.generate;
import static hexlet.code.TestUtils.readFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTestEmptyFiles {

    private static String emptyContentJson;
    private static String hasContentJson;

    @BeforeAll
    public static void beforeAll() throws Exception {
        emptyContentJson = readFixture("test_json", "test_empty_file", "empty_content.json");
        hasContentJson = readFixture("test_json", "test_empty_file", "has_content.json");
    }

    @Test
    public void testDifferFirstFileEmpty() throws Exception {
        var expected = readFixture("test_json", "test_empty_file", "first_file_empty_expected.txt");

        var actual = generate(emptyContentJson, hasContentJson);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferSecondFileEmpty() throws Exception {
        var expected = readFixture("test_json", "test_empty_file", "second_file_empty_expected.txt");

        var actual = generate(hasContentJson, emptyContentJson);

        assertEquals(expected, actual);
    }

    @Test
    public void testDifferBothFileEmpty() throws Exception {
        var expected = readFixture("test_json", "test_empty_file", "both_file_empty_expected.txt");

        var actual = generate(emptyContentJson, emptyContentJson);

        assertEquals(expected, actual);
    }

}
