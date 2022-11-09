package service;

import dao.config.StudentDAO;
import model.Student;

import java.util.List;

public class StudentService {
    public static    List<Student> students = StudentDAO.getAll();
    public List<Student> getAll(){
        return StudentDAO.getAll();
    }
    public List<Student> findByName(String name){
        return StudentDAO.findByName(name);
    }

    public void save(Student student){
        StudentDAO.saveStudent(student);
    }

    public static void editStudent(int id, Student student){
        for (int i = 0; i < students.size(); i++) {
            students.set(i, student);
            StudentDAO.editStudent(student);
        } {

        }
    }

    public static Student returnStudent(int idStudent) {
        Student student = null;
        for (Student s : StudentDAO.getAll()) {
            if (s.getId() == idStudent ) {
                student = s;
            }
        }

        return student;
    }
}