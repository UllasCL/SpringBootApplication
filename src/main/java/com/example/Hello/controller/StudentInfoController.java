package com.example.Hello.controller;

import com.example.Hello.model.StudentInfo;
import com.example.Hello.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;


@Controller
@RequestMapping("Student")
public class StudentInfoController {

    @Autowired
    StudentInfoService studentInfoService;

    /**
     * Count the number of entries.
     * @return count
     */
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ResponseBody
    public long count() {
        return studentInfoService.count();
    }
    /**
     * @return value
     */
    @RequestMapping(value = "/getAllStudents",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllStudentsInfo() {
        return studentInfoService.getAllStudentsInfo();
    }

    /**
     *
     * @param id
     * @return save
     */
    @RequestMapping(value = "/getStudentInfo",method = RequestMethod.GET)
    @ResponseBody
    public Object getStudentInfo(@RequestParam Integer id) {
        return studentInfoService.getStudentInfo(id);
    }

    /**
     * add student info
     * @param studentInfo
     * @return
     */
    @RequestMapping(value = "/addStudentInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object addStudentInfo(@RequestBody StudentInfo studentInfo) {
        return studentInfoService.addStudentInfo(studentInfo);
    }

    /**
     * delete student info
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteStudentInfo",method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteStudentInfo(@RequestParam Integer id) {
        return studentInfoService.deleteStudentInfo(id);
    }

    /**
     * update student info
     * @param id
     * @param studentInfo
     * @return
     */
    @RequestMapping(value = "/updateStudentInfo",method = RequestMethod.POST)
    @ResponseBody
    public Object updateStudentInfo(@RequestParam Integer id,@RequestBody StudentInfo studentInfo) {
        return studentInfoService.updateStudentInfo(id,studentInfo);
    }
}
