package com.edutilos.mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MysqlREPL {
     private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
          MysqlREPL repl = new MysqlREPL();
        repl.execute();
    }

    private void execute() {
        String input = "";
        while(true) {
           input = processInput().toLowerCase();
          //  System.out.println(input);
            if(input.equals("end")) {
               break;
            } else {
             executeMsqlCmd(input);
            }
        }
    }




    //variables
    private Connection conn ;
    private Statement stmt ;
    private ResultSet rs ;
    private final String user = "root";
    private final String pass = "";
    private final String url = "jdbc:mysql://localhost/test";
    private void connect() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection(url, user, pass);
            stmt = conn.createStatement();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        }

    private void disconnect() {
        try {
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public  String executeMsqlCmd(String cmd) {
       connect();
        try {
            if(cmd.isEmpty()) return "" ;
            if (cmd.contains("select") || cmd.contains("show") || cmd.contains("describe")) {
                 rs = stmt.executeQuery(cmd);
                //disconnect();
                return  processResultSet();
            } else {
                stmt.executeUpdate(cmd);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        disconnect();
        return "";
    }

    private String processResultSet() throws Exception {

        String wholeResult = "" ;
        while(rs.next()) {
          int counter = 1 ;
            String str = "";

               Object obj =  rs.getObject(counter++);



            while(obj != null) {
                str += obj.toString() + " , ";
                //System.out.println(str);
           try {
               obj = rs.getObject(counter++);
           }catch(Exception ex) {

              // ex.printStackTrace();
               break;
           }
           }
                   str = str.substring(0 , str.lastIndexOf(','));
                    System.out.println(str);
                     wholeResult += str + "\r\n";
                    str = "";
                    counter = 1;


        }

        return wholeResult;
    }



    private String processInput() {
        String cmd = "";
        String line = scanner.nextLine();
        while(line != null) {
            cmd += line ;
            if(line.contains(";")) {
                 cmd = cmd.substring(0 , cmd.indexOf(';'));
                break;
            }
        }

        return cmd;
    }
}
