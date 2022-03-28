package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.EmptyQueueException;

/**
 * @author mbibe
 *
 */
class MyQueueTests {
	//attributes
	QueueADT<String> queue;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		queue = new MyQueue<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		queue = null;
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testEnqueueEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		
		assertEquals(1, queue.size());
		assertEquals("A", queue.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 */
	@Test
	void testIsEmpty() {
		assertTrue(queue.isEmpty());
		assertEquals(0, queue.size());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
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
	 * @throws EmptyQueueException 
	 * @throws  
	 */
	@Test
	void testIteratorNonEmpty() throws EmptyQueueException {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
				
		Iterator<String> iterator = queue.iterator();
		assertTrue(iterator.hasNext());
		
		while(iterator.hasNext()) {
			assertEquals(queue.dequeue(), iterator.next());
		}
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = queue.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
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
	 * @throws EmptyQueueException 
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			queue.toArray(null);
			});
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
	void testIsFull() {
		// Optional. Our group developed a non fixed length queue
		assertTrue(true);
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, queue.size());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSizeNonEmpty() {
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		
		assertEquals(3, queue.size());
	}

}
