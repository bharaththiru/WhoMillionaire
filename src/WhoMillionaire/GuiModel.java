/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.SQLException;

/**
 *
 * @author bhara
 */
public class GuiModel 
{
    DBManager dmb = new DBManager();
    DBSetup dbs = new DBSetup();
    
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
            dbs.statement.addBatch("INSERT INTO PLAYER VALUES('" + name + "', " + score + ")");
            dbs.statement.executeBatch();
            System.out.println("Executed and Inserted data successfully.");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
    public void closeConn()
    {
        dbs.closeConnection();
        System.out.println("Connection closed successfully.");
    }
}
