package bzb.example.filedownload.exceptions;

public class CustomException extends RuntimeException {

    String exceptionClass;

    public CustomException(String message, String exceptionClass) {
        super(message);
        this.exceptionClass = exceptionClass;
    }
}
