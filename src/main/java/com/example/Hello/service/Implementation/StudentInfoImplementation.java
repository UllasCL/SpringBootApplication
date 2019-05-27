package com.example.Hello.service.Implementation;

import com.example.Hello.exception.StudentException;
import com.example.Hello.model.StudentInfo;
import com.example.Hello.repository.StudentInfoRepo;
import com.example.Hello.service.StudentInfoService;
import com.example.Hello.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class StudentInfoImplementation implements StudentInfoService {
    @Autowired
    StudentInfoRepo studentInfoRepo;

    /**
     * list of all students
     *
     * @return
     */
    @Override
    public List<StudentInfo> getAllStudentsInfo() {
        try {
            List<StudentInfo> studentInfoArrayList = studentInfoRepo.findAll();
            if (studentInfoArrayList.isEmpty()) {
                LogUtils.getInfoLogger().info("No result");
                return null;
            } else {
                return studentInfoArrayList;
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
    public Optional<StudentInfo> getStudentInfo(Integer id) {
        try {
            Optional studentInfo = studentInfoRepo.findById(id);
            if (studentInfo.isPresent()) {
                LogUtils.getInfoLogger().info("result found");
                return studentInfo;
            } else {
                LogUtils.getInfoLogger().info("No result");
                return null;
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
        return "Student info added";
    }

    /**
     * delete student info
     *
     * @param id
     * @return
     */
    @Override
    public String deleteStudentInfo(Integer id) {
        try {
            studentInfoRepo.deleteById(id);
            LogUtils.getInfoLogger().info("Student deleted");
        } catch (Exception exception) {
            throw new StudentException(exception.getMessage());
        }
        return "Student info deleted";
    }

    /**
     * count
     *
     * @return
     */
    @Override
    public long count() {
        long count = studentInfoRepo.count();
        if (count == 0) {
            LogUtils.getInfoLogger().info("Count is empty");
            return 0;
        } else {
            return count;
        }
    }
}
