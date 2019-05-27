//package com.example.Hello.exception.handler;
//
//import com.example.Hello.exception.StudentException;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class CustomExceptionHandler {
//
//    /**
//     * Handles the Student Exception.
//     *
//     * @param exception student exception
//     * @return Response
//     */
//    @ExceptionHandler(value = StudentException.class)
//    public ResponseEntity handleStudentException(StudentException exception) {
//        return null;
//    }
//
//    /**
//     * Handles the Book Exception.
//     *
//     * @param exception book exception
//     * @return Response
//     */
//    @ExceptionHandler(value = StudentException.class)
//    public ResponseEntity handleBookException(StudentException exception) {
//        return null;
//    }
//
//}
