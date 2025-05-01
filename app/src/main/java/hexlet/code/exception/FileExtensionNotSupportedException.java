package hexlet.code.exception;

public class FileExtensionNotSupportedException extends RuntimeException {

    public FileExtensionNotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
