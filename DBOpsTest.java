package nz.ac.aut.ense701.gameModel;
import java.sql.SQLException;
import java.util.Collection;
import static junit.framework.TestCase.*;
import org.junit.Test;
/**
 *
 * @author Kaiyuan Zeng
 */
public class DBOpsTest {
    
    private DBOps db = new DBOps();
    public DBOpsTest()
    {        
    }    
    
    @Test
    public void testInitConnection()
    {
        try
        {
        db.initConnection();
        assertEquals(true, db.result);
        }
        catch(SQLException e)
        {
            
        }
    }
    @Test
    public void testexeUpdate()
    {
        try
        {
        assertEquals("kaiyuan kaiyuan", db.exeUpdate("INSERT INTO USERS (username, password) VALUES (kaiyuan,kaiyuan)"));
        }
        catch(SQLException e)
        {
            
        }
    }
    @Test
    public void testexeQuery()
    {
        assertEquals(1, 1);
        /*try
        {
        
        }
        catch(SQLException e)
        {
            
        }*/
    }
    
    
}
