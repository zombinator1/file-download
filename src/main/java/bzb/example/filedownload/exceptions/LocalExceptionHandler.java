package bzb.example.filedownload.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LocalExceptionHandler {

    @ExceptionHandler
    ResponseEntity<ExceptionResponse> handleException(CustomException ex) {
        return ResponseEntity.status(500).body(exceptionResponseOf(ex));
    }

    private ExceptionResponse exceptionResponseOf(CustomException ex) {
        return new ExceptionResponse(ex.getMessage(), ex.exceptionClass);
    }
}
