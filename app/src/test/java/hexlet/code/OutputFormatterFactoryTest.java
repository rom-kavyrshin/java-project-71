package hexlet.code;

import hexlet.code.exception.UnsupportedFormatException;
import hexlet.code.formatters.OutputFormatterFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OutputFormatterFactoryTest {

    @Test
    void testOutputFormatterFactoryWithUnsupportedFormat() {
        assertThrows(
                UnsupportedFormatException.class,
                () -> OutputFormatterFactory.getOutputFormatter("unsupportedFormat")
        );
    }
}
