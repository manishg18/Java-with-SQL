
package org.example;

import java.sql.*;

public class Main {

    static String url = "jdbc:mysql://localhost:3306/jdbc2";
    static String user = "root";
    static String password = "root";

    // Get all records
    static void getall() throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();

        String sql = "SELECT * FROM employee";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id"));
            System.out.println("Name: " + rs.getString("Name"));
            System.out.println("Age: " + rs.getInt("Age"));
            System.out.println("Aadhar: " + rs.getString("Aadhar"));
            System.out.println("Gender: " + rs.getString("Gender"));
            System.out.println("----------------------");
        }

        rs.close();
        st.close();
        con.close();
    }

    // Insert record
    static void insert() throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();

        String sql = "INSERT INTO employee (Name, Age, Aadhar, Gender) " +
                "VALUES ('Sowmya', 21, '190123456782', 'Female')";


        int rows = st.executeUpdate(sql);

        System.out.println(rows + " record inserted");

        st.close();
        con.close();
    }

    // Update record
    static void update() throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();

        String sql = "UPDATE employee SET Age = 25 WHERE id = 6";

        int rows = st.executeUpdate(sql);

        System.out.println(rows + " record updated");

        st.close();
        con.close();
    }

    // Delete record
    static void delete() throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();

        String sql = "DELETE FROM employee WHERE id = 1";

        int rows = st.executeUpdate(sql);

        System.out.println(rows + " record deleted");

        st.close();
        con.close();
    }

    // Main method
    public static void main(String[] args) {

        try {
            System.out.println("Connected to MySQL!");

            getall();

            // Uncomment the method you want to execute:
            //insert();
            // update();
            // delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


