/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bhara
 */
public class DBManager 
{
    private Connection conn;
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String URL = "jdbc:derby:Project2_DB;create = true";
    
    public DBManager() 
    {
        establishConnection();
    }

    public void establishConnection() 
    {
        if (this.conn == null) 
        {
            try 
            {
                Class.forName(DRIVER);
                this.conn = DriverManager.getConnection(URL);
                System.out.println(URL + " Connected Successfully.");
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            } 
            catch (ClassNotFoundException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public Connection getConnection() 
    {
        return conn;
    }
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
                System.out.println(conn.isClosed());
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
