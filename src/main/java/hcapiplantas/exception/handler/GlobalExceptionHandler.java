package hcapiplantas.exception.handler;

import hcapiplantas.exception.DataAlreadyExistsException;
import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.model.dto.StandardErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final StandardErrorResponse standardErrorResponse = new StandardErrorResponse();

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, DataAlreadyExistsException.class})
    public ResponseEntity<StandardErrorResponse> handleBadRequestException(Exception ex){
        standardErrorResponse.setTimestamp(LocalDateTime.now());
        standardErrorResponse.setStatus(HttpStatus.BAD_REQUEST);
        standardErrorResponse.setErrors(List.of(ex.getMessage()));
        return new ResponseEntity<>(standardErrorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<StandardErrorResponse> handleNotFoundException(Exception ex){
        standardErrorResponse.setTimestamp(LocalDateTime.now());
        standardErrorResponse.setStatus(HttpStatus.NOT_FOUND);
        standardErrorResponse.setErrors(List.of(ex.getMessage()));
        return new ResponseEntity<>(standardErrorResponse, HttpStatus.NOT_FOUND);
    }

}
