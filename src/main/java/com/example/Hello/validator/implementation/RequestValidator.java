package com.example.Hello.validator.implementation;

import com.example.Hello.model.StudentInfo;
import com.example.Hello.validator.RequestValidators;
import org.springframework.stereotype.Service;

@Service
public class RequestValidator implements RequestValidators {
    /**
     * Validate request whether request is valid or not
     *
     * @param studentInfo
     * @return
     */
    @Override
    public boolean validateStudentInfo(StudentInfo studentInfo) {
        return studentInfo.getId() >= 1 && !studentInfo.getName().isEmpty() && !studentInfo.getUsn().isEmpty()
                && !studentInfo.getCollege().isEmpty() && !studentInfo.getAddress().isEmpty();
    }

    /**
     * Validate id is empty or not
     *
     * @param id
     * @return
     */
    @Override
    public boolean validateId(Integer id) {
        return id >= 1;
    }
}
