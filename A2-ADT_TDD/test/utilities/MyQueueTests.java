package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;

/**
 * These are the JUnit tests for every method in the MyQueue class. 
 * There are multiple tests for each method to ensure that the implementation is completed. 
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * 
 */
class MyQueueTests {
	//attributes
	QueueADT<String> queue;

	/**
     * This will run the method once to instantiate, before starting tests.
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		queue = new MyQueue<>();
	}

	/**
	 * This will run the method once to clear instantiation, after finished all tests.
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the empty queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testEnqueueEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		
		assertEquals(1, queue.size());
		assertEquals("A", queue.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * Check if an element is added at the end of the queue successfully, and the size and the added element are correct
	 * when adding an element to the non-empty queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testEnqueueNonEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		
		assertEquals(2, queue.size());
		
		queue.dequeue();
		assertEquals("B", queue.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when adding "null" to the queue
	 */
	@Test
	void testEnqueueNullPointerException() {
		try {
			queue.enqueue(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 * Check if the size and the removed element are correct, and the second element is changed the position to the top of the queue 
	 * when removing an element from the top of the queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testDequeueNonEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		
		String deleted = queue.dequeue();
		
		assertEquals(1, queue.size());
		assertEquals("A", deleted);
		assertEquals("B", queue.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 * Check if the size is zero and the removed element is correct
	 * when removing an element from the queue containing only one element.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testDequeueWhenOnlyOneElementExits() throws EmptyQueueException {
		queue.enqueue("A");
		
		String deleted = queue.dequeue();
		
		assertEquals(0, queue.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 * Check if "EmptyQueueException" is thrown when removing an element from the empty queue
	 */
	@Test
	void testDequeueEmptyQueueException() {
		try {
			queue.dequeue();
			fail("EmptyQueueException wasn't thrown!");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 * Check if the size is correct and an element is retrieved successfully from the non-empty queue
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testPeekNonEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		
		String value = queue.peek();
		
		assertEquals(2, queue.size());
		assertEquals("A", value);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 * Check if the size is correct and an element is retrieved successfully
	 * when retrieving an element from the queue containing only one element.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testPeekWhenOnlyOneElementExits() throws EmptyQueueException {
		queue.enqueue("A");
		
		String value = queue.peek();
		
		assertEquals(1, queue.size());
		assertEquals("A", value);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 * Check if the "EmptyQueueException" is thrown when retrieving an element from the empty queue
	 */
	@Test
	void testPeekEmptyQueueException() {
		try {
			queue.peek();
			fail("EmptyQueueException wasn't thrown!");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 * Check if the size is zero and queue is empty
	 * when removing all elements from the queue.
	 */
	@Test
	void testDequeueAll() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		assertEquals(3, queue.size());
		
		queue.dequeueAll();
		
		assertEquals(0, queue.size());
		assertTrue(queue.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 * Check if the size is zero when the queue is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 * Check if the size is correct when the queue has the specific number of elements.
	 */
	@Test
	void testIsEmptyNonEmpty() {
		queue.enqueue("A");
		queue.enqueue("B");
		
		assertFalse(queue.isEmpty());
		assertEquals(2, queue.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 * Check if the "NoSuchElementException" is thrown and "false" returns 
	 * when the iterator traverses in the empty queue
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> iterator = queue.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 * Check if "true" returns and the element is correctly retrieved 
	 * when the iterator traverses from the top to the end in the non-empty queue 
	 * And check if "NoSuchElementException" is thrown and "false" returns followed by the end of the queue
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testIteratorNonEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
				
		Iterator<String> iterator = queue.iterator();
		assertTrue(iterator.hasNext());
		
		while(iterator.hasNext()) {
			assertEquals(queue.peek(), iterator.next());
			queue.dequeue();
		}
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 * Check if "true" is returned when all elements in a queue equals the other queue
	 */
	@Test
	void testEqualsQueueADTOfEEquals() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		
		MyQueue<String> comparedQ = new MyQueue<>();
		comparedQ.enqueue("A");
		comparedQ.enqueue("B");
		comparedQ.enqueue("C");
		comparedQ.enqueue("D");
		
		assertTrue(queue.equals(comparedQ));
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 * Check if "false" is returned when all elements in a queue do not equals the other queue
	 */
	@Test
	void testEqualsQueueADTOfENotEquals() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
		
		MyQueue<String> comparedQ = new MyQueue<>();
		comparedQ.enqueue("A");
		comparedQ.enqueue("D");
		comparedQ.enqueue("C");
		comparedQ.enqueue("B");
		
		assertFalse(queue.equals(comparedQ));
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty queue to the object type of the array
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = queue.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty queue to the object type of the array
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testToArrayNonEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		Object[] arr = queue.toArray();
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(queue.dequeue(), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty queue to the generic type of the array
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		
		arr = queue.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty queue to the generic type of the array
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testToArrayEArrayNonEmptySufficient() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		String[] arr = new String[3];
		
		arr = queue.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(queue.dequeue(), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 * Check if the size of the array is expanded and the array contains elements
	 * when transferring the non-empty queue to the generic type of the array having insufficient size.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Test
	void testToArrayEArrayNonEmptyInSufficient() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		String[] arr = new String[1];
		
		arr = queue.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(queue.dequeue(), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 * Check if the "NullPointerException" is thrown when transferring "null" queue to the generic type of the array
	 * @throws NullPointerException
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			queue.toArray(null);
			});
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 * Check if the queue is full
	 */
	@Test
	void testIsFull() {
		// Optional. Our group developed a non fixed length queue
		assertTrue(true);
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 * Check if the size of the empty queue is zero
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, queue.size());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 * Check if the size of the non-empty queue is correct 
	 */
	@Test
	void testSizeNonEmpty() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		assertEquals(3, queue.size());
	}

}
