package dao.config;

import model.Student;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    static Connection connection = ConnectMySQL.getConnection();

    public static List<Student> getAll() {
        String selectAll = "SELECT student.*, classroom.name as classname FROM codegymtestmd3.student join classroom on student.idClassroom = classroom.id";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);
            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                LocalDate birthday = resultSet.getDate("dateofbirthday").toLocalDate();
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int idClassRoom = resultSet.getInt("idClassRoom");
                students.add(new Student(id, name, address, birthday, phone, email, idClassRoom));
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveStudent(Student student){
        String insert = "INSERT INTO student (`name`, `address`, `dateofbirthday`, `phone`, `email`,`idClassRoom`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthday()));
            preparedStatement.setString(4,student.getPhone());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getClassRoom());

            preparedStatement.execute();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
    }


    public static List<Student> findByName(String nameFind) {
        String find = "SELECT student.*, classroom.name as classname FROM codegymtestmd3.student join classroom on student.idClassroom = classroom.id\n" +
                "where student.name like '%"+nameFind+"%\'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(find);
            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                int idClassRoom = resultSet.getInt("idClassRoom");
                students.add(new Student(id, name, address, birthday, phone, email, idClassRoom));
            }
            return students;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void deleteStudent(int id) {
        try {
            String sql = "DELETE FROM  student  WHERE (id= ?)";
            Connection connection = ConnectMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editStudent(Student student) {
        try{
            String sql = "UPDATE `codegymtestmd3`.`student` SET `id`=?, `address` = ?, `birthday` = ?, `phone` = ?, `email` = ?, `classroom` = ? WHERE (`id` = ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setString(2,student.getAddress());
            preparedStatement.setDate(3, Date.valueOf(student.getBirthday()));
            preparedStatement.setString(4,student.getPhone());
            preparedStatement.setString(5,student.getEmail());
            preparedStatement.setInt(6,student.getClassRoom());
            preparedStatement.execute();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
