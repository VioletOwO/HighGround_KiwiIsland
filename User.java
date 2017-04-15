package nz.ac.aut.ense701.gameModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import nz.ac.aut.ense701.gui.*;

/**
 *
 * @author Kaiyuan Zeng
 */
public class User {
    private int id;
    private String username;
    private String password;
    
    public User()
    {
        id = 0;
        username = "";
        password = "";
    }
    
    public User(int id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        
    }
    
    public static boolean checkUsername(String username)
    {
        for (char aChar : username.toCharArray())
        {
            if (!((aChar >= '0' && aChar <= '9') || (aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z')))
            {
                System.out.println(aChar);
                return false;
            }
        }
        return true;
    }
    
    public static boolean isDatabaseEmpty()
    {
        try
        {
            ResultSet numOfRows = DBOps.exeQuery("SELECT COUNT(*) FROM USERS");
            while(numOfRows.next())
            {
                if (numOfRows.getInt(1) == 0)
                {
                    return true;
                }
            }
        }
        catch (SQLException sqle)
        {
            return true;
        }
        return false;
    }
    
    public static boolean hasUser(String username)
    {
        try
        {
            ResultSet nameSet = DBOps.exeQuery("SELECT USERNAME FROM USERS");
            while(nameSet.next())
            {
                if (nameSet.getString(1).equals(username))
                {
                    return true;
                }
            }
        }
        catch (SQLException sqle)
        {
            return true;
        }
        
        return false;
    }
    
    /*public static User getUserByName(String searchName)
    {
        int id;
        int username;
        int password;
        try
        {
            ResultSet nameSet = DBOps.exeQuery("SELECT * FROM USERS WHERE USERNAME = \'" + searchName + "\'");
            while(nameSet.next())
            {
                id = nameSet.getInt("id");
                return new User(id, searchName);
            }
        }
        catch (SQLException sqle)
        {
            return null;
        }
        return null;
    }*/
    
    public static boolean addUser(String username, String password)
    {
        String SQLCommand = "INSERT INTO USERS (USERNAME, CHIPS) VALUES (\'" + username + "\', 1000)";
        try
        {
            DBOps.exeUpdate(SQLCommand);
        }
        catch (SQLException sqle)
        {
            return false;
        }
        return true;
    }
    
}

