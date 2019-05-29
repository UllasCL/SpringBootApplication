package com.example.Hello.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name = "student")
public class StudentInfo {

    @Id
    @Column(name = "id")
    int id;
    @Column(name = "usn")
    String usn;
    @Column(name = "name")
    String name;
    @Column(name = "college")
    String college;
    @Column(name = "address")
    String address;

}
