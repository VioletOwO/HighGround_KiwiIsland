package nz.ac.aut.ense701.gameModel;

import java.util.Collection;
import org.junit.Test;
/**
 *
 * @author Kaiyuan Zeng
 */
public class UserTest extends junit.framework.TestCase
{
    User user;
    private int id = 1;
    private String username = "Kaiyuan";
    private String password = "Kaiyuan";
    
    public UserTest()
    {
    }
    @Override
    protected void setUp()
    {
       user = new User(id, username, password);
    }
    
    @Test
    public void testGetID()
    {
        assertEquals(1, user.getID());
    }
    
    @Test
    public void testGetUsername()
    {
        assertEquals("Kaiyuan", user.getUsername());
    }
    
    @Test
    public void testGetPassword()
    {
        assertEquals("Kaiyuan", user.getPassword());
    }
    
    
}
