package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are the JUnit tests for every method in the MyStack class. 
 * There are multiple tests for each method to ensure that the implementation is completed. 
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * 
 */
class MyStackTests {
	//attributes
	StackADT<String> stack;

	/**
     * This will run the method once to instantiate, before starting tests.
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		stack = new MyStack<>();
	}

	/**
	 * This will run the method once to clear instantiation, after finished all tests.
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		stack = null;
	}

	/**
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the empty stack.
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushEmpty() {
		stack.push("A");
		
		assertEquals(1, stack.size());
		assertEquals("A", stack.peek());
	}
	
	/**
	 * Check if an element is added at the top of the stack successfully, and the size and the added element are correct
	 * when adding an element to the non-empty stack.
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
	 * Check if the "NullPointerException" is thrown when adding "null" to the stack
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
	 * Check if the size and the removed element are correct, and the second element is changed the position to the top of the stack 
	 * when removing an element from the top of the stack.
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
	 * Check if the size is zero and the removed element is correct
	 * when removing an element from the stack containing only one element.
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
	 * Check if "EmptyStackException" is thrown when removing an element from the empty stack
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
	 * Check if the size is correct and an element is retrieved successfully from the non-empty stack
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
	 * Check if the size is correct and an element is retrieved successfully
	 * when retrieving an element from the stack containing only one element.
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
	 * Check if the "EmptyStackException" is thrown when retrieving an element from the empty stack
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
	 * Check if the size is zero and stack is empty
	 * when removing all elements from the stack.
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
	 * Check if the size is zero when the stack is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(stack.isEmpty());
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 * Check if the size is correct when the stack has the specific number of elements.
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
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty stack to the object type of the array
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = stack.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty stack to the object type of the array
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
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty stack to the generic type of the array
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
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty stack to the generic type of the array
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
	 * Check if the size of the array is expanded and the array contains elements
	 * when transferring the non-empty stack to the generic type of the array having insufficient size.
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
	 * Check if the "NullPointerException" is thrown when transferring "null" stack to the generic type of the array
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			stack.toArray(null);
			});
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 * Check if "false" is returned when comparing an element to the empty stack.
	 */
	@Test
	void testContainsEmpty() {
		boolean contains = stack.contains("A");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 * Check if "true" is returned when comparing an element to the stack containing it.
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
	 * Check if "false" is returned when comparing an element to the stack not containing it.
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
	 * Check if the "NullPointerException" is thrown when comparing "null" to the stack
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
	 * Check if the result returns "-1" when the specific element is not found in the empty stack
	 */
	@Test
	void testSearchEmpty() {
		assertEquals(-1, stack.search("A"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 * Check if the result returns "1" when searching element is only one in the stack
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
	 * Check if the result returns the number of count when searching element is more than one in the stack
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
	 * Check if the result returns "-1" when searching element is not found in the non-empty stack
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
	 * Check if the "NoSuchElementException" is thrown and "false" returns 
	 * when the iterator traverses in the empty stack
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
	 * Check if "true" returns and the element is correctly retrieved 
	 * when the iterator traverses from the top to the end in the non-empty stack 
	 * And check if "NoSuchElementException" is thrown and "false" returns followed by the end of the stack 
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
	 * Check if "true" is returned when all elements in a stack equals the other stack
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
	 * Check if "false" is returned when all elements in a stack do not equals the other stack
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
	 * Check if the size of the empty stack is zero
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, stack.size());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 * Check if the size of the non-empty stack is correct 
	 */
	@Test
	void testSizeNonEmpty() {
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(3, stack.size());
	}

}
