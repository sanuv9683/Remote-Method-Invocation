/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sanuak
 */
public class CrudUtil {

    private static PreparedStatement getPreaparedStatemene(Connection con, String sql, Object... param) throws SQLException {
        PreparedStatement pstm = con.prepareStatement(sql);
        for (int i = 0; i < param.length; i++) {
            pstm.setObject(i + 1, param[i]);
        }
        return pstm;
    }

    public static boolean executeUpdate(Connection con, String sql, Object... param) throws SQLException {
        return getPreaparedStatemene(con, sql, param).executeUpdate() > 0;
    }

    public static ResultSet executeQuery(Connection con, String sql, Object... param) throws SQLException {
        return getPreaparedStatemene(con, sql, param).executeQuery();
    }
}
