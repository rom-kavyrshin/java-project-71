package hexlet.code.exception;

public class FileExtensionNotSupportedException extends Exception {

    public FileExtensionNotSupportedException() {
        this("Unable to parse this file");
    }

    public FileExtensionNotSupportedException(String message) {
        super(message);
    }

    public FileExtensionNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
