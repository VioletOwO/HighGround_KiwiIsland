package assignment;

import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.PriorityBlockingQueue;
import static assignment.Constants.BUFFER_SIZE;
/**
 *
 * @author Kaiyuan Zeng 14852277
 *          Yang Hu      14860526
 * Buffer class is used to initialize the whole program and store methods which threads will invoke.
 */
public class Buffer
{
    private Semaphore empty;
    private Semaphore full;
    private Semaphore mutex;
    PriorityBlockingQueue<Integer> buffers;     
/**
 * Initialize Buffer attributes.
 */
    public Buffer() 
    {
        empty = new Semaphore(1, false);
        full = new Semaphore(0, false);
        mutex = new Semaphore(BUFFER_SIZE);
        buffers = new PriorityBlockingQueue(BUFFER_SIZE);        
    }
 /**
  * Insert integer into buffer queue.
 */    
    public int insert_item(Integer in) 
    {        
        try 
        {
            empty.acquire();
            mutex.acquire();
            buffers.put(in);            
        } 
        catch (InterruptedException e) 
        {
            return -1;
        }
        finally
        {
            mutex.release();
            full.release();
            return 0;
        }               
    }
/** Remove integer from buffer queue.
 */    
    public int remove_item() 
    {
        Integer out = -1;
        try
        {
            full.acquire();
            mutex.acquire();
            out = buffers.take();
        }
        catch(InterruptedException e)
        {
            return -1;
        }
        finally
        {
            mutex.release();
            empty.release();
            return out;
        }
    }
/**
 * Start program and get user command to execute.
 */    
    public static void main(String[] args)
    {        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How long to sleep before terminating(in seconds):");
        long terminalTime = keyboard.nextLong();
        System.out.print("Enter the number of producer threads:");
        int numProducer = keyboard.nextInt();
        System.out.print("Enter the number of consumer threads:");
        int numConsumer = keyboard.nextInt();        
        
        Buffer buffer = new Buffer();
        Thread[] producers = new Thread[numProducer];
        Thread[] consumers = new Thread[numConsumer];
        
        for(int i = 0; i < numProducer; i++)
            producers[i] = new Thread(new Producer(buffer));  

        for(int i = 0; i < numConsumer; i++)
            consumers[i] = new Thread(new Consumer(buffer));  

        for(Thread thread : producers) 
            thread.start();        
        for(Thread thread: consumers)
            thread.start();
        
        try
        {
            Thread.sleep(terminalTime * 1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }               
    }
}    

