package com.example.Hello.mapper;

import com.example.Hello.dto.StudentInfoDto;
import com.example.Hello.model.StudentInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentInfoDtoStudentInfoMapper {

    /**
     * Converts StudentEntity To StudentDto.
     *
     * @param studentInfo To be converted.
     * @return Converted Form
     */
    StudentInfoDto studentInfoToStudentInfoDto(StudentInfo studentInfo);

    /**
     * Converts StudentDto To StudentEntity
     *
     * @param studentInfoDto To be converted.
     * @return Converted Form
     */
    StudentInfo studentInfoDtoToStudentInfo(StudentInfoDto studentInfoDto);
}
