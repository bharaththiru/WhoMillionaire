/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bhara
 */
public class DBSetup 
{
    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    Statement statement;
    
    DBSetup()
    {
        try
        {
            this.statement = conn.createStatement();
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
            ResultSet rs = dmd.getTables(null, null, "PLAYER", null);
            
            if(rs.next())
            {
                System.out.println("The table PLAYER already exists");
            }
            else
            {
                statement.addBatch("CREATE TABLE PLAYER (NAME VARCHAR(50), SCORE INT)");
                statement.executeBatch();
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
        this.db.closeConnections();
    }
}
