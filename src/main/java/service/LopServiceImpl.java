package service;

import model.Lop;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LopServiceImpl implements LopService {

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
    public List<Lop> findAll() {
        List<Lop> lops = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from class");) {
            System.out.println(preparedStatement);//in câu truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                lops.add(new Lop(id, name));

            }
        } catch (SQLException e) {}
        return lops;
    }


    @Override
    public void add(Lop aLop) throws SQLException {

    }

    @Override
    public Lop findById(int id) {
        Lop clazz =new Lop();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from class where id=?");) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);//in câu truy vấn
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int classId  = rs.getInt("id");
                String name = rs.getString("name");
                clazz =new Lop(classId,name);

            }
        } catch (SQLException e) {}
        return clazz ;
    }



    @Override
    public boolean update(Lop aLop) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int t) throws SQLException {
        return false;
    }


}
