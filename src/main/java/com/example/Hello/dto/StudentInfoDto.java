package com.example.Hello.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentInfoDto {
    private int id;
    private String usn;
    private String name;
    private String college;
    private String address;
}
