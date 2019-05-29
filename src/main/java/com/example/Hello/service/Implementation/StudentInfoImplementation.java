package com.example.Hello.service.Implementation;

import com.example.Hello.constants.ResponseConstants;
import com.example.Hello.dto.StudentInfoDto;
import com.example.Hello.exception.StudentException;
import com.example.Hello.mapper.StudentInfoDtoStudentInfoMapper;
import com.example.Hello.model.StudentInfo;
import com.example.Hello.repository.StudentInfoRepo;
import com.example.Hello.service.StudentInfoService;
import com.example.Hello.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class StudentInfoImplementation implements StudentInfoService {
    @Autowired
    StudentInfoRepo studentInfoRepo;

    @Autowired
    StudentInfoDtoStudentInfoMapper studentInfoDtoStudentInfoMapper;

    @Autowired
    ResponseConstants responseConstants;

    /**
     * list of all students
     *
     * @return
     */
    @Override
    public List<StudentInfoDto> getAllStudentsInfo() {
        try {
            List<StudentInfo> studentInfoArrayList = studentInfoRepo.findAll();
            if (studentInfoArrayList.isEmpty()) {
                LogUtils.getInfoLogger().info("No result");
                return null;
            } else {
                LogUtils.getInfoLogger().info("StudentsInfo found : {}", studentInfoArrayList.toString());
                return studentInfoArrayList.stream()
                        .map(studentInfo1 -> studentInfoDtoStudentInfoMapper.studentInfoToStudentInfoDto(studentInfo1))
                        .collect(Collectors.toList());
            }
        } catch (Exception exception) {
            throw new StudentException(exception.getMessage());
        }
    }

    /**
     * specific student
     *
     * @param id
     * @return
     */
    @Override
    public Optional<StudentInfoDto> getStudentInfo(Integer id) {
        try {
            Optional<StudentInfo> studentInfo = studentInfoRepo.findById(id);
            if (studentInfo.isPresent()) {
                Optional<StudentInfoDto> studentInfoDto = studentInfo.map(studentInfo1 -> studentInfoDtoStudentInfoMapper.studentInfoToStudentInfoDto(studentInfo1));
                LogUtils.getInfoLogger().info("result found" + studentInfoDto.toString());
                return Optional.of(studentInfoDtoStudentInfoMapper.studentInfoToStudentInfoDto(studentInfo.get()));
            } else {
                LogUtils.getInfoLogger().info("No result");
                return Optional.empty();
            }
        } catch (Exception exception) {
            throw new StudentException(exception.getMessage());
        }
    }

    /**
     * update student info
     *
     * @param id
     * @param studentInfo
     * @return
     */
    @Override
    public Optional<StudentInfo> updateStudentInfo(Integer id, StudentInfo studentInfo) {
//        try{
//            Optional studentInfoOptional = studentInfoRepo.findById(id);
//            if(studentInfoOptional.isPresent()){
//              // Optional<StudentInfo> updatedStudentInfo = studentInfoRepo.save(new  StudentInfo(id,student.getAddress(),student.getCollege(),student.getName(),student.getUsn()));
//               return updatedStudentInfo;
//                LogUtils.getInfoLogger().info("Student Updated: {}", updatedStudentInfo.toString());
//
//            }
//        }catch (Exception exception) {
//            LogUtils.getInfoLogger().info("Student Not updated");
//            throw new StudentException(exception.getMessage());
//        }
        return Optional.empty();
    }

    /**
     * add student info
     *
     * @param studentInfo
     * @return
     */
    @Override
    public String addStudentInfo(StudentInfo studentInfo) {
        try {
            studentInfoRepo.save(studentInfo);
            LogUtils.getInfoLogger().info("Student added");
        } catch (Exception exception) {
            throw new StudentException(exception.getMessage());
        }
        return "Student info added successfully" + responseConstants.SUCCESS_MESSAGE;
    }

    /**
     * delete student info
     *
     * @param id
     * @return
     */
    @Override
    public List<StudentInfoDto> deleteStudentInfo(Integer id) {
        try {
            Optional<StudentInfo> studentInfo = studentInfoRepo.findById(id);
            if (studentInfo.isPresent()) {
                studentInfoRepo.deleteById(id);
                LogUtils.getInfoLogger().info("Student deleted {}", id);
               StudentInfoDto studentInfoDto= studentInfoDtoStudentInfoMapper.studentInfoToStudentInfoDto(studentInfo.get());
                return new ArrayList<>(Arrays.asList(studentInfoDto));
            } else {
                LogUtils.getInfoLogger().info("Student not found {}", id);
                return new ArrayList<>();
            }
        } catch (Exception exception) {
            throw new StudentException(exception.getMessage());
        }
    }

    /**
     * count
     *
     * @return
     */
    @Override
    public String count() {
        long count = studentInfoRepo.count();
        if (count == 0) {
            LogUtils.getInfoLogger().info("Count is empty");
            return responseConstants.FAILED_MESSAGE;
        } else {
            return responseConstants.SUCCESS_MESSAGE + "\nCount is " + count;
        }
    }
}
