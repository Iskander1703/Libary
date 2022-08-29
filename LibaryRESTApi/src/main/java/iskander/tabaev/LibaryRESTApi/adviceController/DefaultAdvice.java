package iskander.tabaev.LibaryRESTApi.adviceController;

import iskander.tabaev.LibaryRESTApi.util.ErrorResponse;
import iskander.tabaev.LibaryRESTApi.util.NotFoundException;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ErrorResponse> handleException(NotFoundException notFoundException) {
        ErrorResponse errorResponse = new ErrorResponse(notFoundException.getMessage(), new Date(System.currentTimeMillis()));
        return  new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
