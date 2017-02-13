package com.edutilos.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 13/02/2017.
 */
public class PersonDAOMysql implements  PersonDAO{

    private final String user = "root";
    private final String pass = "";
  private final String url = "jdbc:mysql://localhost/test";
    //private final String driverName = "com.mysql.jdbc.Driver";
    private final String driverName = "com.mysql.cj.jdbc.Driver";

     //variables
    private Connection conn ;
    private Statement stmt;
    private PreparedStatement pstmt ;
    private ResultSet rs ;


    public PersonDAOMysql() {
        try {
         //   Class.forName(driverName);
          DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connect() {
        try {
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void disconnect() {
         if(rs != null) try {
             rs.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
        if(pstmt != null) try {
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(stmt != null) try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(conn != null) try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(Person p) {
      connect();
         String cmd = "insert into Person VALUES(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(cmd);
            pstmt.setLong(1, p.getId());
            pstmt.setString(2, p.getName());
            pstmt.setInt(3, p.getAge());
            pstmt.setDouble(4, p.getWage());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();
    }

    @Override
    public void update(long id, Person newPerson) {
       connect();
          String cmd = "update Person set name = ? , age = ? , wage = ? where id = ?";
           try {
               pstmt = conn.prepareStatement(cmd);
               pstmt.setString(1, newPerson.getName());
               pstmt.setInt(2, newPerson.getAge());
               pstmt.setDouble(3, newPerson.getWage());
                pstmt.setLong(4, id);
               pstmt.executeUpdate();
           } catch(SQLException ex) {
               ex.printStackTrace();
           }
        disconnect();
    }

    @Override
    public void delete(long id) {
      connect() ;
        String cmd = "delete from Person where id = ?";

         try {
            pstmt = conn.prepareStatement(cmd);
             pstmt.setLong(1, id);
             pstmt.executeUpdate();
         } catch(SQLException ex) {
             ex.printStackTrace();
         }
        disconnect();
    }

    @Override
    public Person findById(long id) {
        connect();
        Person p ;

        String cmd = "select * from Person where id = ?";
        try {
             pstmt = conn.prepareStatement(cmd);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            rs.next();
         p = fromRSToPerson();
        } catch(SQLException ex) {
            ex.printStackTrace();
            p = null ;
        }
        disconnect();
        return p;
    }

    @Override
    public List<Person> findAll() {
        connect();
        List<Person> pList = new ArrayList<>();
        String cmd = "select * from Person";
        try {
            rs = stmt.executeQuery(cmd);
            while(rs.next()) {
               pList.add(fromRSToPerson());
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        disconnect();
        return pList;
    }

    private Person fromRSToPerson() {
        Person p ;
        try {

            long id = rs.getLong(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            double wage = rs.getDouble(4);
            p = new Person(id, name, age, wage);
        } catch(SQLException ex) {
            ex.printStackTrace();
            p = null ;
        }
        return p ;
        }
}
