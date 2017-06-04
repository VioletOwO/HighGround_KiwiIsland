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
public class RecordTest extends junit.framework.TestCase
{
    Record record = new Record();
    private int id = 1;
    private String username = "Kaiyuan";
    private int mark = 1;
    
    public RecordTest(){}
    
    @Override
    protected void setUp()
    {
        record.setId(id);
        record.setMark(mark);
        record.setName(username);
    }
    
    @Test
    public void testGetID()
    {
        assertEquals(1, record.getId());
    }
    
    @Test
    public void testGetName()
    {
        assertEquals("Kaiyuan", record.getName());
    }
    
    @Test
    public void testGetMark()
    {
        assertEquals(1, record.getMark());
    }
    
    @Test
    public void testGetTopTenPlayer()
    {
        assertEquals(1, record.getId());
    }
    
    @Test
    public void testAddRecord()
    {
        assertEquals(true, record.addRecord("Kaiyuan", 1));
    }
}
