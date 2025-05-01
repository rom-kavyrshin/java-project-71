package hexlet.code.formatters;

public class OutputFormatterFactory {

    public static final String STYLISH_OUTPUT_FORMAT_NAME = "stylish";
    public static final String UNSUPPORTED_FORMAT_MESSAGE = "Unsupported output format";

    public static OutputFormatter getOutputFormatter(String outputFormatName) {
        if (outputFormatName.equals(STYLISH_OUTPUT_FORMAT_NAME)) {
            return new StylishFormatter();
        } else {
            throw new UnsupportedOperationException(UNSUPPORTED_FORMAT_MESSAGE + ": " + outputFormatName);
        }
    }

    public static OutputFormatter getDefault() {
        return getOutputFormatter(STYLISH_OUTPUT_FORMAT_NAME);
    }
}
