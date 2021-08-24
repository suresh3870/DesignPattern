package com.greatlearning.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnect {
        static Connection con=null;
        public static Connection getConnection()
        {
            if (con != null) return con;
            // get db, user, pass from settings file
            return getConnection("dbConnect", "root", "root");
        }

        private static Connection getConnection(String db_name,String user_name,String password)
        {
            try
            {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbName", "root", "root");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

            return con;
        }
    }
