package hexlet.code.formatters;

import hexlet.code.exception.UnsupportedFormatException;

public final class OutputFormatterFactory {

    public static final String STYLISH_OUTPUT_FORMAT_NAME = "stylish";
    public static final String PLAIN_OUTPUT_FORMAT_NAME = "plain";
    public static final String JSON_OUTPUT_FORMAT_NAME = "json";
    public static final String UNSUPPORTED_FORMAT_MESSAGE = "Unsupported output format";

    private OutputFormatterFactory() {
    }

    public static OutputFormatter getOutputFormatter(String outputFormatName) {
        return switch (outputFormatName) {
            case STYLISH_OUTPUT_FORMAT_NAME -> new StylishFormatter();
            case PLAIN_OUTPUT_FORMAT_NAME -> new PlainFormatter();
            case JSON_OUTPUT_FORMAT_NAME -> new JsonFormatter();
            default -> throw new UnsupportedFormatException(UNSUPPORTED_FORMAT_MESSAGE + ": " + outputFormatName);
        };
    }

    public static OutputFormatter getDefault() {
        return getOutputFormatter(STYLISH_OUTPUT_FORMAT_NAME);
    }
}
