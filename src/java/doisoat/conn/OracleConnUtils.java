/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doisoat.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucnt
 */
public class OracleConnUtils {
    public static Connection getOracleConnection()
            throws ClassNotFoundException, SQLException {

        // Chú ý: Thay đổi các thông số kết nối cho phù hợp.
        String hostName = "192.168.254.34";
        String serviceName = "tcbsweb";
        String userName = "USER_NHS";
        String password = "nhsVB123456";

        return getOracleConnection(hostName, serviceName, userName, password);
    }
    
    public static Connection getOracleConnection(String hostName, String serviceName,
           String userName, String password) throws ClassNotFoundException,
           SQLException {
   
       Class.forName("oracle.jdbc.driver.OracleDriver");
  
       // Cấu trúc URL Connection đối với Oracle
       // Ví dụ: 
       // jdbc:oracle:thin:@localhost:1521:db11g
       // jdbc:oracle:thin:@//HOSTNAME:PORT/SERVICENAME
       String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521/" + serviceName;
  
       Connection conn = DriverManager.getConnection(connectionURL, userName,
               password);
       return conn;
   }
}
