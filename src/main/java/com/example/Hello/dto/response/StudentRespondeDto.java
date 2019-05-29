package com.example.Hello.dto.response;

import com.example.Hello.dto.StudentInfoDto;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRespondeDto {
    String status;
    Integer code;
    String messages;
    List<StudentInfoDto> studentInfoDtos;
}
