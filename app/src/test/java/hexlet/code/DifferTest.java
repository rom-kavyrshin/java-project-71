package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testDiffer() throws Exception {
        var first = readFixture("first.json");
        var second = readFixture("second.json");
        var expected = readFixture("expected.txt");

        var actual = generate(first, second);

        assertEquals(expected, actual);
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "test_json", "test_addition_deletion_change", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        var path = getFixturePath(fileName);
        return Files.readString(path).trim();
    }
}
