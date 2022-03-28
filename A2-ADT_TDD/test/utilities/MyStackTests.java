package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mbibe
 *
 */
class MyStackTests {
	
	StackADT<String> stack;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushEmpty() {
		stack.push("A");
		
		assertEquals(1, stack.size());
		assertEquals("A", stack.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNonEmpty() {
		stack.push("A");
		stack.push("B");
		
		assertEquals(2, stack.size());
		
		stack.pop();
		assertEquals("A", stack.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNullPointerException() {
		try {
			stack.push(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPopNonEmpty() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		String deleted = stack.pop();
		
		assertEquals(2, stack.size());
		assertEquals("C", deleted);
		assertEquals("B", stack.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPopWhenOnlyOneElementExits() {
		stack.push("A");
		
		String deleted = stack.pop();
		
		assertEquals(0, stack.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPopEmptyStackException() {
		try {
			stack.pop();
			fail("EmptyStackException wasn't thrown!");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekNonEmpty() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		String value = stack.peek();
		
		assertEquals(3, stack.size());
		assertEquals("C", value);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekWhenOnlyElementExits() {
		stack.push("A");
		
		String value = stack.peek();
		
		assertEquals(1, stack.size());
		assertEquals("A", value);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekEmptyStackException() {
		try {
			stack.peek();
			fail("EmptyStackException wasn't thrown!");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(3, stack.size());
		
		stack.clear();
		
		assertEquals(0, stack.size());
		assertTrue(stack.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyNonEmpty() {
		stack.push("A");
		stack.push("B");
		
		assertFalse(stack.isEmpty());
		assertEquals(2, stack.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = stack.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArrayNonEmpty() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		Object[] arr = stack.toArray();
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(stack.pop(), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		
		arr = stack.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNonEmptySufficient() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		String[] arr = new String[3];
		
		arr = stack.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(stack.pop(), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNonEmptyInSufficient() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		String[] arr = new String[1];
		
		arr = stack.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(stack.pop(), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			stack.toArray(null);
			});
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsEmpty() {
		boolean contains = stack.contains("A");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsMatching() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		boolean contains = stack.contains("C");
		
		assertTrue(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNoMatching() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		boolean contains = stack.contains("D");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNullPointerException() {
		try {
			stack.contains(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchEmpty() {
		assertEquals(-1, stack.search("A"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchMatchingNoDuplicatedElements() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		int depth = stack.search("C");
		
		assertEquals(1, depth);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchMatchingWhenHasDuplicatedElements() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("B");
		stack.push("D");
		
		int depth = stack.search("B");
		
		assertEquals(2, depth);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchNoMatching() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(-1, stack.search("D"));
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> iterator = stack.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}
	
	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIteratorNonEmpty() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		Iterator<String> iterator = stack.iterator();
		assertTrue(iterator.hasNext());
		
		while(iterator.hasNext()) {
			assertEquals(stack.peek(), iterator.next());
			stack.pop();
		}
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEEquals() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		
		MyStack<String> comparedS = new MyStack<>();
		comparedS.push("A");
		comparedS.push("B");
		comparedS.push("C");
		comparedS.push("D");
		
		assertTrue(stack.equals(comparedS));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfENotEquals() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		
		MyStack<String> comparedS = new MyStack<>();
		comparedS.push("D");
		comparedS.push("B");
		comparedS.push("C");
		comparedS.push("A");
		
		assertFalse(stack.equals(comparedS));
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeNonEmpty() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(3, stack.size());
	}

}
