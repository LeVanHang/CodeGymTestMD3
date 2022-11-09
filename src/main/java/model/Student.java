package model;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private String address;
    private LocalDate birthday;
    private String phone;
    private String email;
    private int classRoom;

    public Student(int id, String name, String address, LocalDate birthday, String phone, String email, String className, int idClassRoom) {
    }

    public Student(String name, String address, Date birthday, String phone, String email, int classRoom) {
        this.name = name;
        this.address = address;
        this.birthday = birthday.toLocalDate();
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = Date.valueOf(birthday).toLocalDate();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public Student(int id, String name, String address, LocalDate birthday, String phone, String email, int classRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.classRoom = classRoom;
    }

    public Student(int id, String name, String address, Date birthday, String phone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday.toLocalDate();
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", classRoom=" + classRoom +
                '}';
    }
}
