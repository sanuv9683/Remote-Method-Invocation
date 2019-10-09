/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author sanuak
 */
public class DBConnection {

    private static DBConnection dbConnection;
    private BasicDataSource ds;

    private DBConnection() throws SQLException, ClassNotFoundException {
        ds= new BasicDataSource();
       ds.setDriverClassName("com.mysql.jdbc.Driver");
       ds.setUrl("jdbc:mysql://localhost:3306/company");
       ds.setUsername("root");
       ds.setPassword("sanu");
       ds.setInitialSize(2);
       ds.setMaxTotal(2);
    }

    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
