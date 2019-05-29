package com.example.Hello.validator;

import com.example.Hello.model.StudentInfo;

public interface RequestValidators {
    boolean validateStudentInfo(StudentInfo studentInfo);
    boolean validateId(Integer id);
}
