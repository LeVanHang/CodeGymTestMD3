package service;

import dao.config.StudentDAO;
import model.Student;

import java.time.LocalDate;
import java.util.List;

public class StudentService {

    public List<Student> getAll(){
        return StudentDAO.getAll();
    }
    public List<Student> findByName(String name){
        LocalDate birthday = null;
        return StudentDAO.findByName(name, birthday);
    }

    public void save(Student student){
        StudentDAO.saveStudent(student);
    }
}
