/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nz.ac.aut.ense701.gameModel;
import org.junit.Test;
/**
 *
 * @author Administrator
 */
public class MyTimerTaskTest extends junit.framework.TestCase
{
    MyTimerTask mt;
    
    public MyTimerTaskTest(){}
    
    @Override
    protected void setUp()
    {
        mt = new MyTimerTask();
    }
    
    @Test
    public void testGetID()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testGetGameState()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testGetLable()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testGetShowingTime()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testGetTime()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testGetIsPause()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testSetGameState()
    {
        mt.setGameState(GameState.LOST);
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testSetLable()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testSetShowingTime()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testSetTime()
    {
        mt.setTime(600);
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testUpgradeShowingTime()
    {
        mt.updateShowingTime();
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testUpgrade()
    {
        assertEquals(600, mt.getTime());
    }
    
    @Test
    public void testSetPause()
    {
        assertEquals(600, mt.getTime());
    }
    
}
