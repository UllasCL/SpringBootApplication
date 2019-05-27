package com.example.Hello.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class StudentInfo {

    @Id
    private int id;
    @Column(name = "usn")
    private String usn;
    @Column(name = "name")
    private String name;
    @Column(name = "college")
    private String college;
    @Column(name = "address")
    private String address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setUsn(String usn) {
        this.usn = usn;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return usn
     */
    public String getUsn() {
        return usn;
    }

    /**
     *
     * @return college name
     */
    public String getCollege() {
        return college;
    }

    /**
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
