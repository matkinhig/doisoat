/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.conn;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author lucnt
 */
public class ConnectionUtils {

    public static Connection getConnection()
            throws ClassNotFoundException, SQLException {

        // kết nối tới Oracle Database.
        return OracleConnUtils.getOracleConnection();
    }

    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {

        }
    }

    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException e) {
        }
    }

}
