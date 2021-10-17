/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
<<<<<<< Updated upstream
=======
import java.sql.ResultSetMetaData;
>>>>>>> Stashed changes
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author bhara
 */
public class DBSetup 
{
<<<<<<< Updated upstream
    DBManager db = new DBManager();
    Connection conn = db.getConnection();
    Statement statement;
=======
    public DBManager dbm = new DBManager();
    private Connection conn = dbm.getConnection();;
    public Statement statement;
    public ResultSet rs;
    public ResultSetMetaData rsmd;
    public int colCount = 0;
>>>>>>> Stashed changes
    
    DBSetup()
    {
        try
        {
<<<<<<< Updated upstream
            this.statement = conn.createStatement();
=======
            if(statement == null)
            {
                this.statement = conn.createStatement();
            }
            
>>>>>>> Stashed changes
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
    }
    
    public void CreateTable()
    {
        try
        {
            DatabaseMetaData dmd = conn.getMetaData();
<<<<<<< Updated upstream
            ResultSet rs = dmd.getTables(null, null, "PLAYER", null);
=======
            this.statement.execute("CREATE TABLE PLAYER (NAME VARCHAR(50), SCORE INT)");
            
>>>>>>> Stashed changes
            
            if(rs.next())
            {
                System.out.println("The table PLAYER already exists");
            }
            else
            {
<<<<<<< Updated upstream
                statement.addBatch("CREATE TABLE PLAYER (NAME VARCHAR(50), SCORE INT)");
                statement.executeBatch();
=======
                System.out.println("table PLAYER created successfully.");
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        this.db.closeConnections();
=======
        this.dbm.closeConnections();
>>>>>>> Stashed changes
    }
}
