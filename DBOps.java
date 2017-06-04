/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Class DBOps is used to initialize database connection and execute SQL commands.
 *
 */
public class DBOps
{
    public static boolean result = false;
    
    /** The connection. */
    public static Connection conn;
    
    public DBOps(){
        try {
            initConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBOps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Initial the connection.
     *
     * @throws SQLException the SQL exception
     */
    public static void initConnection() throws SQLException
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Properties props = new Properties();
            props.put("user", "kiwiIsland");
            props.put("password", "kiwiIsland");
            conn = DriverManager.getConnection("jdbc:derby:KIWIISLANDDB;create = true", props);
            //conn.setAutoCommit(false);
            Statement stat = conn.createStatement();
            if(!isTableExists("users")){
                stat.executeUpdate("CREATE TABLE users(id integer not null generated always as identity (start with 1, increment by 1) primary key,username varchar(256) not null,password varchar(256) not null)");
                //System.out.println("DB setup done!");
            }
            if(!isTableExists("records")){
                stat.executeUpdate("CREATE TABLE records(id integer not null generated always as identity (start with 1, increment by 1) primary key,name varchar(256) not null,mark integer not null)");
                //System.out.println("DB setup done!");
            }
            //System.out.println("DB setup done!");
            result = true;
            //stat.close();
        }
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        catch (InstantiationException e) 
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) 
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            if (!e.getSQLState().equals("X0Y32")) 
            e.printStackTrace();
        }
        
    }
    
    /**
     * Execute update.
     *
     * @param SQLCommand the SQL command
     * @return the integer representation of the execution status
     * @throws SQLException the SQL exception
     */
    public static int exeUpdate(String SQLCommand) throws SQLException
    {
        if (conn == null)
        {
            initConnection();
        }
        Statement stat = conn.createStatement();
        return stat.executeUpdate(SQLCommand);
    }
    
    /**
     * Execute query.
     *
     * @param SQLCommand the SQL command
     * @return the result set
     * @throws SQLException the SQL exception
     */
    public static ResultSet exeQuery(String SQLCommand) throws SQLException
    {
        if (conn == null)
        {
            initConnection();
        }
        Statement stat = conn.createStatement();
        return stat.executeQuery(SQLCommand);
    }
    
    public static boolean isTableExists(String table) {
        boolean b = false;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            Properties props = new Properties();
            props.put("user", "kiwiIsland");
            props.put("password", "kiwiIsland");
            Connection conn = DriverManager.getConnection("jdbc:derby:KIWIISLANDDBB;create = true", props);
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet rs = dbm.getTables(null, null, "employee", null);
            if(rs.next()){
                b = true;
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBOps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DBOps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBOps.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DBOps.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
    
    public static void shutDown() throws SQLException{
        if(conn != null){
            conn.close();
        }
    }
    
    public static void main(String[] args)
    {
        try{
            initConnection();
            User.addUser("abc", "abc");
            System.out.println(User.getUserByName("abc").getID() + "   "+ User.getUserByName("abc").getUsername() + "   " + User.getUserByName("abc").getPassword());
            Record.addRecord("aaa", 120);
            System.out.println(Record.getTopTenPlayer().get(0).getName());
            
        }
        catch(SQLException e)
        {
            
        }
    }
}
