/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bhara
 */
public class GuiModel 
{
    DBManager dmb = new DBManager();
    DBSetup dbs = new DBSetup();
    public ResultSet rs;
    public ResultSetMetaData rsmd;
    public int colCount = 0;
    
    public void connect()
    {
        dmb.establishConnection();
    }
    
    public void createTable()
    {
        dbs.CreateTable();
    }
    
    public void executeStatement()
    {
        String name = Player.getName();
        int score = GuiController.score;
        
        try
        {
            dbs.statement.execute("INSERT INTO PLAYER VALUES('" + name + "', " + score + ")");
            System.out.println("Executed and Inserted data successfully.");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void viewPlayerTable()
    {
         try 
        {
            rs = dbs.statement.executeQuery("SELECT * FROM APP.PLAYER");
            rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();

            System.out.format(" |" + rsmd.getColumnName(1) + "| ");
            System.out.format("   |" + rsmd.getColumnName(2) + "| ");
            while (rs.next()) 
            {
                System.out.println("");
                for (int j = 1; j <= colCount; j++) 
                {
                    System.out.format(" |" + rs.getString(j) + "| ");
                }
            }

            System.out.println("");
            System.out.println("Select query executed successfully.");
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
    
    public void closeConn()
    {
        dbs.closeConnection();
        System.out.println("Connection closed successfully.");
    }
}
