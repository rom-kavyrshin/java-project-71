package hexlet.code.exception;

public class FileExtensionNotSupportedException extends Exception {

    public FileExtensionNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
