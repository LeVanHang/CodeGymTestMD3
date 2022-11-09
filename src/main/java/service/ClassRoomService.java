package service;

import dao.config.ClassRoomDAO;
import dao.config.ClassRoomDAO;
import dao.config.StudentDAO;
import model.ClassRoom;
import model.Student;

import java.util.List;

public class ClassRoomService {

    public List<ClassRoom> getAll(){
        return ClassRoomDAO.getAll();
    }
}
