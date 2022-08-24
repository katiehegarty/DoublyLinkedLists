package Lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
       testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
     }
    @Test
    public void testIsEmpty() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	assertTrue("Checking isEmpty returns true", testDLL.isEmpty()); 
    	//testDLL.insertBefore(0, 4);
    	//assertFalse("Checking isEmpty return false for non-empty DLL", testDLL.isEmpty());
    }
   @Test 
   public void testGet() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   assertNull("Checking get method on empty DLL", testDLL.get(0));
	   testDLL.insertBefore(0,1);
	   assertEquals("Checking get to retrieve first node of testDLL", Integer.valueOf(1), testDLL.get(0));
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(2,4);
	   assertEquals("Checking get to retrieve first node of testDLL", Integer.valueOf(2), testDLL.get(1));
	   assertNull("Checking get to retrieve non-exstent node", testDLL.get(21));
   }
	   
   @Test
   public void testDeleteAt() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   assertFalse("", testDLL.deleteAt(0));
	   testDLL.insertBefore(0, 1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(2,4);
	   assertTrue("Checking deleteAt removes first node of list", testDLL.deleteAt(0));
	   assertFalse("Checking deleteAt for non existent pos", testDLL.deleteAt(21));
	   assertTrue("Checking deleteAt for last node", testDLL.deleteAt(2));
	   
	   
    }
   @Test
   public void testReverse() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   testDLL.reverse();
	   assertEquals("Checking reverse on non-existent list ", "", testDLL.toString());
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3,4);
	   testDLL.reverse();
	   assertEquals("", "4,3,2,1", testDLL.toString());
   }
   @Test
   public void testMakeUnique() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   testDLL.makeUnique();
	   assertEquals("Checking makeUnique on empty DLL", "", testDLL.toString());
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,1);
	   testDLL.insertBefore(2,2);
	   testDLL.insertBefore(3,2);
	   testDLL.makeUnique();
	   assertEquals("Checking make unique removes all like nodes", "1,2", testDLL.toString());
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3,4);
	   testDLL.makeUnique();
	   assertEquals("Checking makeUnique with no like nodes", "1,2,3,4", testDLL.toString());
	   
   }
   @Test
   public void testPush() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   testDLL.push(9);
	   assertEquals("Checking push for empty dll", "9", testDLL.toString());
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3,4);
	   testDLL.push(2);
	   assertEquals("Checking push pushes 2 onto list", "2,1,2,3,4,9", testDLL.toString());
   }
   @Test
   public void testPop() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   testDLL.pop();
	   assertEquals("Checking pop for empty dll", "", testDLL.toString());
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3,4);
	   testDLL.pop();
	   assertEquals("Checking pop pops most recent node", "2,3,4", testDLL.toString());
	   
   }
   @Test
   public void testDequeue() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   testDLL.dequeue();
	   assertEquals("Checking dequeue for empty DLL", "", testDLL.toString());
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3,4);
	   testDLL.dequeue();
	   assertEquals("Checking dequeue takes first node out", "1,2,3", testDLL.toString());
	   
   }
   @Test
   public void testEnqueue() {
	   DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
	   testDLL.enqueue(7);
	   assertEquals("Checking enqueue for empty dll", "7", testDLL.toString());
	   testDLL.deleteAt(0);
	   testDLL.insertBefore(0,1);
	   testDLL.insertBefore(1,2);
	   testDLL.insertBefore(2,3);
	   testDLL.insertBefore(3,4);
	   testDLL.enqueue(27);
	   assertEquals("Checking enqueue adds 32 to end of list", "27,1,2,3,4", testDLL.toString());
   }
   
}

