package com.example.Hello.service;

import com.example.Hello.dto.StudentInfoDto;
import com.example.Hello.model.StudentInfo;

import java.util.List;
import java.util.Optional;

public interface StudentInfoService {
    List<StudentInfoDto> getAllStudentsInfo();

    Optional<StudentInfoDto> getStudentInfo(Integer id);

    Optional<StudentInfo> updateStudentInfo(Integer id, StudentInfo studentInfo);

    String addStudentInfo(StudentInfo studentInfoDto);

    String deleteStudentInfo(Integer id);

    String count();
}
