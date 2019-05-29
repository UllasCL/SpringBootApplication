package com.example.Hello.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentInfoDto {
     int id;
    String usn;
    String name;
    String college;
    String address;
}
