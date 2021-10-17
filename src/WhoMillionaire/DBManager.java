/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
/**
 *
 * @author bhara
 */
public class DBManager 
{
<<<<<<< Updated upstream
    Connection conn = null;
    public static final String USR_NME = "assignment2";
    public static final String PASSWORD = "project2";
    private static final String URL = "jdbc:derby://localhost:1527/MillionaireDB;create = true";
=======
    private Connection conn;
    public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String URL = "jdbc:derby:Project2_DB;create = true";
>>>>>>> Stashed changes
    
    public DBManager() 
    {
        establishConnection();
    }

<<<<<<< Updated upstream
    public Connection getConnection() 
    {
        return this.conn;
    }

=======
>>>>>>> Stashed changes
    public void establishConnection() 
    {
        if (this.conn == null) 
        {
            try 
            {
<<<<<<< Updated upstream
                this.conn = DriverManager.getConnection(URL, USR_NME, PASSWORD);
                System.out.println(URL + "Connected Successfully ....");
=======
                Class.forName(DRIVER);
                this.conn = DriverManager.getConnection(URL);
                System.out.println(URL + " Connected Successfully.");
>>>>>>> Stashed changes
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
<<<<<<< Updated upstream
=======
            } 
            catch (ClassNotFoundException ex) 
            {
                System.out.println(ex.getMessage());
>>>>>>> Stashed changes
            }
        }
    }
    
<<<<<<< Updated upstream
=======
    public Connection getConnection() 
    {
        return conn;
    }
>>>>>>> Stashed changes
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
<<<<<<< Updated upstream
=======
                System.out.println(conn.isClosed());
>>>>>>> Stashed changes
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
