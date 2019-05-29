package com.example.Hello.exception.handler;

import com.example.Hello.dto.response.StudentRespondeDto;
import com.example.Hello.exception.StudentException;
import com.example.Hello.exception.StudentInfoException;
import com.example.Hello.util.LogUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    /**
     * Handles the Student Exception.
     *
     * @param exception student exception
     * @return Response
     */
    @ExceptionHandler(value = StudentInfoException.class)
    public ResponseEntity handleStudentException(StudentException exception) {
        StudentRespondeDto studentResponseDto = StudentRespondeDto
                .builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.toString())
                .messages(exception.getMessage())
                .studentInfoDtos(null)
                .build();
        LogUtils.getErrorLogger().error("Student Exception: {}", exception.getMessage());
        return new ResponseEntity<>(studentResponseDto, HttpStatus.BAD_REQUEST);
    }
}
