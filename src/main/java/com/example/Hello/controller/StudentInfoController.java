package com.example.Hello.controller;

import com.example.Hello.constants.ResponseConstants;
import com.example.Hello.dto.response.StudentRespondeDto;
import com.example.Hello.exception.StudentException;
import com.example.Hello.model.StudentInfo;
import com.example.Hello.service.StudentInfoService;
import com.example.Hello.validator.implementation.RequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping("Student")
public class StudentInfoController {

    @Autowired
    StudentInfoService studentInfoService;

    @Autowired
    RequestValidator requestValidator;

    @Autowired
    ResponseConstants responseConstants;

    /**
     * Count the number of entries.
     *
     * @return count
     */
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public String count() {
        return studentInfoService.count();
    }

    /**
     * @return value
     */
    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllStudentsInfo() {
        if (studentInfoService.getAllStudentsInfo().isEmpty()) {
            throw new StudentException(responseConstants.EMPTY_MESSAGE);
        }
        else return studentInfoService.getAllStudentsInfo();
    }

    /**
     * @param id
     * @return save
     */
    @RequestMapping(value = "/getStudentInfo", method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentInfo(@RequestParam Integer id) {
        if (requestValidator.validateId(id))
            if (studentInfoService.getStudentInfo(id).isPresent())
                return studentInfoService.getStudentInfo(id);
            else {
                throw new StudentException(responseConstants.EMPTY_MESSAGE);
            }
        else {
            throw new StudentException(responseConstants.FAILED_MESSAGE);
        }
    }

    /**
     * add student info
     *
     * @param studentInfo
     * @return
     */
    @RequestMapping(value = "/addStudentInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object addStudentInfo(@RequestBody StudentInfo studentInfo) {
        if (requestValidator.validateStudentInfo(studentInfo)) {
            return studentInfoService.addStudentInfo(studentInfo);
        } else {
            return StudentRespondeDto.builder()
                    .studentInfoDtos(null)
                    .code(HttpStatus.OK.value())
                    .status(HttpStatus.OK.toString())
                    .messages(responseConstants.FAILED_MESSAGE)
                    .build();
        }
    }

    /**
     * delete student info
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteStudentInfo", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStudentInfo(@RequestParam Integer id) {
        if (requestValidator.validateId(id)) {
            return
                    StudentRespondeDto.builder()
                            .studentInfoDtos(null)
                            .code(HttpStatus.OK.value())
                            .status(HttpStatus.OK.toString())
                            .messages(responseConstants.DELETED_MESSAGE)
                            .studentInfoDtos(studentInfoService.deleteStudentInfo(id))
                            .build();
        } else {
            return StudentRespondeDto.builder()
                    .studentInfoDtos(null)
                    .code(HttpStatus.BAD_REQUEST.value())
                    .status(HttpStatus.BAD_REQUEST.toString())
                    .messages(responseConstants.FAILED_MESSAGE)
                    .build();
        }
    }

    /**
     * update student info
     *
     * @param id
     * @param studentInfo
     * @return
     */
    @RequestMapping(value = "/updateStudentInfo", method = RequestMethod.POST)
    @ResponseBody
    public Object updateStudentInfo(@RequestParam Integer id, @RequestBody StudentInfo studentInfo) {
        if (requestValidator.validateId(id) && requestValidator.validateStudentInfo(studentInfo)) {
            return studentInfoService.updateStudentInfo(id, studentInfo);
        } else {
            return Optional.of(responseConstants.FAILED_MESSAGE);
        }
    }
}
