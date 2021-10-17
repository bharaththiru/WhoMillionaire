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
<<<<<<< Updated upstream
            dbs.statement.addBatch("INSERT INTO PLAYER VALUES('" + name + "', " + score + ")");
            dbs.statement.executeBatch();
=======
            dbs.statement.execute("INSERT INTO PLAYER VALUES('" + name + "', " + score + ")");
>>>>>>> Stashed changes
            System.out.println("Executed and Inserted data successfully.");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println(ex.getNextException());
        }
    }
    
<<<<<<< Updated upstream
=======
    public void viewPlayerTable()
    {
         try 
        {
            dbs.rs = dbs.statement.executeQuery("SELECT * FROM APP.PLAYER");
            dbs.rsmd = dbs.rs.getMetaData();
            dbs.colCount = dbs.rsmd.getColumnCount();

            System.out.format(" |" + dbs.rsmd.getColumnName(1) + "| ");
            System.out.format("   |" + dbs.rsmd.getColumnName(2) + "| ");
            while (dbs.rs.next()) 
            {
                System.out.println("");
                for (int j = 1; j <= dbs.colCount; j++) 
                {
                    System.out.format(" |" + dbs.rs.getString(j) + "| ");
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
    
>>>>>>> Stashed changes
    public void closeConn()
    {
        dbs.closeConnection();
        System.out.println("Connection closed successfully.");
    }
}
