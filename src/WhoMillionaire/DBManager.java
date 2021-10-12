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
    Connection conn = null;
    public static final String USR_NME = "assignment2";
    public static final String PASSWORD = "project2";
    private static final String URL = "jdbc:derby://localhost:1527/MillionaireDB;create = true";
    
    public DBManager() 
    {
        establishConnection();
    }

    public Connection getConnection() 
    {
        return this.conn;
    }

    public void establishConnection() 
    {
        if (this.conn == null) 
        {
            try 
            {
                this.conn = DriverManager.getConnection(URL, USR_NME, PASSWORD);
                System.out.println(URL + "Connected Successfully ....");
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void closeConnections() 
    {
        if (conn != null) 
        {
            try 
            {
                conn.close();
            } 
            catch (SQLException ex) 
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}
