/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment3_spring2019;

import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @version 2019-28-3
 * @author seane
 */
public class WorkAheadQueueTest  {
    
    /**
     * constructor
     */
    public WorkAheadQueueTest() { // constructor
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    @Test
    public void testDequeueInt() {
        WorkAheadQueue instance = new WorkAheadQueue();
        for (int i = 0; i < 4; i++) {
            instance.enqueue(i);
        }
        int size = 4;
        assertEquals("After enqueueing N elements, the size of the queue " + 
            "should be N.", size, instance.size());
        for (int i = 2; i >= 0; i--) {
            try {
                instance.dequeue(i);
                assertEquals("Dequeueing elements should decrease the size of " 
                    + "the queue.", --size, instance.size());
            } catch (EmptyCollectionException | InvalidArgumentException e) {
                fail("Unexpected " + e.getClass().getSimpleName() + 
                    " occurred - dequeue(x)");
            }
        }

        // Elements that are dequeued from the front are no longer at the front
        // The method returns the element that was removed
        instance = new WorkAheadQueue<>();
        instance.enqueue(1);
        instance.enqueue(2);
        try {
            assertEquals("The first element enqueued should be returned by the "
                + "first method.", new Integer(1), instance.first());
        } catch (EmptyCollectionException e) {
            fail("Unexpected " + e.getClass().getSimpleName()
                + " occurred - first()");
        }
        try {
            assertEquals("Dequeueing the element from the front should return "
                + "it.", new Integer(1), instance.dequeue(0));
        } catch (EmptyCollectionException | InvalidArgumentException e) {
            fail("Unexpected " + e.getClass().getSimpleName()
                + " occurred - dequeue(x)");
        }
        try {
            assertEquals("An element should no longer be at the front once it "
                + "has been dequeued.", new Integer(2), instance.first());
        } catch (EmptyCollectionException e) {
            fail("Unexpected " + e.getClass().getSimpleName()
                + " occurred - first()");
        }
    }

    /**
     * Test of first method, of class WorkAheadQueue.
     */
    @Test
    public void testFirstInt() throws Exception {
        System.out.println("first");
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        instance.enqueue(2);
        instance.enqueue(3);
        instance.enqueue(4);
        assertEquals(instance.first(0) , 1);
        assertEquals(instance.first(1) , 2);
    }

    /**
     * Test of firstThreeNodes method, of class WorkAheadQueue.
     */
    @Test


    public void testFirstThreeElements() throws Exception {
        System.out.println("firstThreeElements");
        WorkAheadQueue instance = new WorkAheadQueue();
        assertTrue(instance.isEmpty());
        instance.enqueue(1);
        assertEquals(instance.firstThreeElements().size() , 1);
        assertEquals(instance.firstThreeElements().get(0) , 1);
        instance.enqueue(2);
        assertEquals(instance.firstThreeElements().size() , 2);
        assertEquals(instance.firstThreeElements().get(1) , 2);
        instance.enqueue(3);
        assertEquals(instance.firstThreeElements().size() , 3);
        assertEquals(instance.firstThreeElements().get(2) , 3);
        instance.enqueue(4);
        assertEquals(instance.firstThreeElements().size() , 3);
        assertEquals(instance.firstThreeElements().get(2) , 3);
        instance.enqueue(5);    
    }

    /**
     * Test of enqueue method, of class WorkAheadQueue.
     */
    @Test
    public void testEnqueue() {
        System.out.println("enqueue");
        WorkAheadQueue instance = new WorkAheadQueue();
        assertTrue(instance.isEmpty());
        instance.enqueue(2); 
        assertFalse(instance.isEmpty());
        instance.enqueue(1);
        instance.enqueue(3);
        assertEquals(instance.size() , 3);
    }

    /**
     * Test of dequeue method, of class WorkAheadQueue.
     */
    @Test
    public void testDequeueArgs() throws Exception {
        System.out.println("dequeue");
        WorkAheadQueue instance = new WorkAheadQueue();
        assertTrue(instance.isEmpty());
        instance.enqueue(1);
        assertEquals(instance.size() , 1);
        assertFalse(instance.isEmpty());
        instance.dequeue();
        assertTrue(instance.isEmpty());
        assertEquals(instance.size() , 0);
        instance.enqueue(2);
        assertEquals(instance.size() , 1);
        instance.enqueue(3);
        assertEquals(instance.size() , 2);
        instance.dequeue();
        assertEquals(instance.size() , 1);
    }

    /**
     * Test of first method, of class WorkAheadQueue.
     */
    @Test
    public void testFirstArgs() throws Exception {
        System.out.println("first");
        WorkAheadQueue instance = new WorkAheadQueue();
        instance.enqueue(1);
        assertEquals(instance.first(),1);
        instance.enqueue(2);
        assertEquals(instance.first(),1);
    }

    /**
     * Test of isEmpty method, of class WorkAheadQueue.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        WorkAheadQueue instance = new WorkAheadQueue();
        assertTrue(instance.isEmpty());
       
    }

    /**
     * Test of size method, of class WorkAheadQueue.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        WorkAheadQueue instance = new WorkAheadQueue();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        instance.enqueue(1);
        assertEquals(instance.size() , 1);
    }

    /**
     * Test of firstThreeNodes method, of class WorkAheadQueue.
     */
    @Test
    public void testFirstThreeNodes() throws Exception {
        System.out.println("firstThreeNodes");
        WorkAheadQueue instance = new WorkAheadQueue();
        assertTrue(instance.isEmpty());
        instance.enqueue(1);
        assertEquals(instance.firstThreeNodes().size() , 1);
        instance.enqueue(2);
        assertEquals(instance.firstThreeNodes().size() , 2);
        instance.enqueue(3);
        assertEquals(instance.firstThreeNodes().size() , 3);
        instance.enqueue(4);
        assertEquals(instance.firstThreeNodes().size() , 3);
        instance.enqueue(5);
    }

    /**
     * Test of toString method, of class WorkAheadQueue.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        WorkAheadQueue instance = new WorkAheadQueue();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of populateNodes method, of class WorkAheadQueue.
     */   
    /**
     * Test of dequeue method for EmptyCollectionException, of class
     * WorkAheadQueue.
     */
    @Test
    public void testDequeueIntEmpty() {
        // Empty collection exception is thrown when collection is empty
        WorkAheadQueue instance = new WorkAheadQueue();
        try {
            instance = new WorkAheadQueue<>();
            instance.dequeue(0);
            fail("Expected ECE did not occur - dequeue(x)");
        } catch (EmptyCollectionException | InvalidArgumentException e) {
            assertTrue(e instanceof EmptyCollectionException);
        }
    }
    /**
     * Test of dequeue method for InvalidArgumentException, of class
     * WorkAheadQueue.
     */
    @Test
    public void testDequeueIntInvalid() {
        WorkAheadQueue instance = new WorkAheadQueue();
        for (int i = 3; i > 1; i--) {
            instance = new WorkAheadQueue<>();
            for (int j = 0; j < i; j++) {
                instance.enqueue(1);
            }
            try {
                instance.dequeue(i);
                fail("Expected IAE did not occur - dequeue(x)");
            } catch (EmptyCollectionException | InvalidArgumentException e) {
                assertTrue(e instanceof InvalidArgumentException);
            }
        }
    }
}
