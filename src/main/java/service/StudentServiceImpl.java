package service;

import model.Lop;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    LopService lopService = new LopServiceImpl();

    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcrud?useSSL=false", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Student> findAll() {

        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from testcrud.student");) {
            System.out.println(preparedStatement);//in câu truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int classId = rs.getInt("classId");
                Lop clazz = lopService.findById(classId);
                students.add(new Student(id, name, clazz, age));

            }
        } catch (SQLException e) {
        }
        return students;
    }

    @Override
    public void add(Student student) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into testcrud.student (name,age,classId) value (?,?,?)");) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getClazz().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public Student findById(int id) {
        Student student = new Student();
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from testcrud.student where id =?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);//in câu truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int classId = rs.getInt("classId");
                Lop clazz = lopService.findById(classId);
                student = new Student(id, name, clazz, age);

            }
        } catch (SQLException e) {
        }

        return student;
    }

    @Override
    public boolean update(Student student) throws SQLException {
        boolean upDate;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = getConnection().prepareStatement("update testcrud.student set name = ? , age = ?  where id = ?");) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getId());
            upDate= preparedStatement.executeUpdate()>0;
        }
        return upDate;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("delete from testcrud.student where id=?");) {
            preparedStatement.setInt(1,id );
            System.out.println(preparedStatement);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
