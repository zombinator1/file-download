package bzb.example.filedownload.exceptions;

public class ExceptionResponse {

    String message;
    String exceptionClass;

    public ExceptionResponse(String message, String exceptionClass) {
        this.message = message;
        this.exceptionClass = exceptionClass;
    }
}
