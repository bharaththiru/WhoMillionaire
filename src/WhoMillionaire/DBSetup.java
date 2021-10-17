/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bhara
 */
public class DBSetup 
{
    public DBManager dbm = new DBManager();
    private Connection conn = dbm.getConnection();;
    public Statement statement;
    public ResultSet rs;
    public ResultSetMetaData rsmd;
    public int colCount = 0;
    
    DBSetup()
    {
        try
        {
            if(statement == null)
            {
                this.statement = conn.createStatement();
            }
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
    
    public void CreateTable()
    {
        try
        {
            DatabaseMetaData dmd = conn.getMetaData();
            rs = this.statement.executeQuery("CREATE TABLE PLAYER (NAME VARCHAR(50), SCORE INT)");
            rsmd = rs.getMetaData();
            
            
            if(rs.next())
            {
                System.out.println("The table PLAYER already exists");
            }
            else
            {
                System.out.println("table PLAYER created successfully.");
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void closeConnection()
    {
        this.dbm.closeConnections();
    }
}
