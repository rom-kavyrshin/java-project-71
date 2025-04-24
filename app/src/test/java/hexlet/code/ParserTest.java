package hexlet.code;

import hexlet.code.exception.FileExtensionNotSupportedException;
import org.junit.jupiter.api.Test;

import static hexlet.code.TestUtils.createFixtureFile;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    @Test
    public void testParserWithUnsupportedFileExtension() throws Exception {
        assertThrows(
                FileExtensionNotSupportedException.class,
                () -> Parser.parse(createFixtureFile("test_parser", "unsupported.extension"))
        );
    }
}
