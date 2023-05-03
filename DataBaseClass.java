package com.bridgelabz;

import java.sql.*;
import java.util.Enumeration;

public class DataBaseClass {
    static String url = "jdbc:mysql://localhost:3306/EmployeePayroll";
    static String userName="root";
    static String password="Mohan@1969";
    public static void fetchData(String quaryFetch) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.print("The error in the class -" + e);
        }
        try {
            Connection connection =DriverManager.getConnection(url,userName,password);
            Statement st = connection.createStatement();
            System.out.println("The fecting the data is started  \n");
            ResultSet rs =st.executeQuery(quaryFetch);
            //The result we want in the table formatte so we use RS
            //fetch the data
            System.out.println("The result set - " + rs);
            while (rs.next()) {
                String userData = rs.getInt(1)+" "+rs.getNString(2) + "  " + rs.getDate(3)+" "+ rs.getDouble(4 ) + " "+ rs.getString(5);
                System.out.println(userData);
            }
            System.out.println("Closing point of the Fetch method");
            st.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("The error at the Connection - " + e);
        }
    }

    public static void main(String[] args) {
        fetchData("select * from EmployeePayroll");
    }
}

//jdbc:mysql://localhost:3306/?user=root