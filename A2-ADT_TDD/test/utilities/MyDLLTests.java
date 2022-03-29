package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are the JUnit tests for every method in the MyDLL class. 
 * There are multiple tests for each method to ensure that the implementation is completed. 
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * 
 */
class MyDLLTests {
	//attributes
	ListADT<String> dllList;

	/**
	 * This will run the method once to instantiate, before starting tests. 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dllList = new MyDLL<>();
	}

	/**
	 * This will run the method once to clear instantiation, after finished all tests.  
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		dllList = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 * Check if the size is zero when the DLL is empty.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, dllList.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 * Check if the size is correct when the list has the specific number of elements.
	 */
	@Test
	void testSizeNonEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		assertEquals(3, dllList.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 * Check if the size is zero after executing the "clear" method when the DLL contains elements.
	 */
	@Test
	void testClear() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		assertEquals(3, dllList.size());
		
		dllList.clear();
		
		assertEquals(0, dllList.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element into the specific index of the empty DLL. 
	 */
	@Test
	void testAddIntEEmpty() {
		boolean added = dllList.add(0, "A");
		
		assertTrue(added);
		assertEquals(1, dllList.size());
		assertEquals("A", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if an element is added at the end of the DLL successfully, and the size and the added element are correct
	 * when adding an element into the specific index of the non-empty DLL. 
	 */
	@Test
	void testAddIntENonEmptyAppend() {
		dllList.add("A");
		boolean added = dllList.add(1, "B");
		
		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if an element is added at the top of the DLL successfully, and the size and the added element are correct
	 * when adding an element into the specific index of the non-empty DLL. 
	 */
	@Test
	void testAddIntENonEmptyPrepend() {
		dllList.add("B");
		boolean added = dllList.add(0, "A");
		
		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("A", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if an element is added between existing elements successfully, and the size and the added element are correct
	 * when inserting an element into the middle index of the non-empty DLL.
	 */
	@Test
	void testAddIntENonEmptyInsert() {
		dllList.add("A");
		dllList.add("C");
		boolean added = dllList.add(1, "B");
		
		assertTrue(added);
		assertEquals(3, dllList.size());
		assertEquals("B", dllList.get(1));
		
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when adding "null" into the specific index of the DLL
	 */
	@Test
	void testAddIntENullPointerException() {
		try {
			dllList.add(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when adding an element into the negative index of the DLL
	 */
	@Test
	void testAddIntELowestIndexOutOfBoundsException() {
		try {
			dllList.add(-1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when adding an element into the out of the index of the DLL
	 */
	@Test
	void testAddIntEHighestIndexOutOfBoundsException() {
		try {
			dllList.add(1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the empty DLL.
	 */
	@Test
	void testAddEEmpty() {
		boolean added = dllList.add("A");
		
		assertTrue(added);
		assertEquals(1, dllList.size());
		assertEquals("A", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 * Check if an element is added at the end of the DLL successfully, and the size and the added element are correct
	 * when adding an element to the non-empty DLL.
	 */
	@Test
	void testAddENonEmpty() {
		dllList.add("A");
		boolean added = dllList.add("B");
		
		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when adding "null" to the DLL
	 */
	@Test
	void testAddENullPointerException() {
		try {
			dllList.add(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 * Check if all elements of a DLL are added successfully, and the size and all elements in the DLL are correct
	 * when adding a DLL to another empty DLL.
	 */
	@Test
	void testAddAllEmpty() {
		MyDLL<String> newList = new MyDLL<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");
		
		boolean added = dllList.addAll(newList);
		
		assertTrue(added);
		assertEquals("D", dllList.get(0));
		assertEquals(3, dllList.size());
		assertEquals("E", dllList.get(1));
		assertEquals("F", dllList.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 * Check if all elements of a list are added successfully at the end of another DLL, and the size and all elements in the DLL are correct
	 * when adding a list to another non-empty DLL.
	 */
	@Test
	void testAddAllNonEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		MyDLL<String> newList = new MyDLL<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");
		
		boolean added = dllList.addAll(newList);
		
		assertTrue(added);
		assertEquals(6, dllList.size());
		assertEquals("A", dllList.get(0));
		assertEquals("B", dllList.get(1));
		assertEquals("C", dllList.get(2));
		assertEquals("D", dllList.get(3));
		assertEquals("E", dllList.get(4));
		assertEquals("F", dllList.get(5));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 * Check if the "NullPointerException" is thrown when adding a "null" DLL to another DLL
	 */
	@Test
	void testAddAllNullPointerException() {
		try {
			dllList.addAll(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when retrieving an element from the empty DLL
	 */
	@Test
	void testGetEmpty() {
		try {
			dllList.get(0);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 * Check if an element is retrieved successfully from the non-empty DLL
	 */
	@Test
	void testGetNonEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String value = dllList.get(2);
		
		assertEquals("C", value);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when retrieving an element from the negative index of the empty DLL
	 */
	@Test
	void testGetLowestIndexOutOfBoundsException() {
		try {
			dllList.get(-1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when retrieving an element from the out of index of the empty DLL 
	 */
	@Test
	void testGetHighestIndexOutOfBoundsException() {
		try {
			dllList.add("A");
			dllList.get(1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the empty DLL
	 */
	@Test
	void testRemoveIntEmpty() {
		try {
			dllList.remove(0);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the size and the removed element are correct
	 * when removing an element from the DLL containing only one element using index number.
	 */
	@Test
	void testRemoveIntWhenOnlyOneNodeExists() {
		dllList.add("A");
		
		String deleted = dllList.remove(0);
		
		assertEquals(0, dllList.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the size and the removed element are correct, and the second element is changed the position to the top of the DLL 
	 * when removing an element from the top of the DLL using index number.
	 */
	@Test
	void testRemoveIntFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove(0);
		
		assertEquals("A", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the size and the removed element are correct, and the element in front of removing one is not changed the position 
	 * when removing an element at the end of the DLL using index number.
	 */
	@Test
	void testRemoveIntLastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove(2);
		
		assertEquals("C", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the size and the removed element are correct, and the element followed by removing one is changed the position 
	 * when removing an element from the middle of the DLL using index number.
	 */
	@Test
	void testRemoveIntMiddleNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove(1);
		
		assertEquals("B", deleted);
		assertEquals(2, dllList.size());
		assertEquals("C", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the negative index of the DLL
	 */
	@Test
	void testRemoveIntLowestIndexOutOfBoundsException() {
		try {
			dllList.remove(-1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the out of the index of the DLL
	 */
	@Test
	void testRemoveIntHighestIndexOutOfBoundsException() {
		try {
			dllList.add("A");
			dllList.remove(1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size is correct and no element is removed
	 * when removing an element from the empty DLL.
	 */
	@Test
	void testRemoveEEmpty() {
		String deleted = dllList.remove("A");
		
		assertEquals(0, dllList.size());
		assertNull(deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct
	 * when removing an element from the list containing only one element. 
	 */
	@Test
	void testRemoveEWhenOnlyOneNodeExists() {
		dllList.add("A");
		
		String deleted = dllList.remove("A");
		
		assertEquals(0, dllList.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct, and the second element is changed the position to the top of the DLL 
	 * when removing an element from the top of the DLL.
	 */
	@Test
	void testRemoveEFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("A");
		
		assertEquals("A", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct, and the element in front of removing one is not changed the position 
	 * when removing an element at the end of the DLL.
	 */
	@Test
	void testRemoveELastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("C");
		
		assertEquals("C", deleted);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct, and the element followed by removing one is changed the position 
	 * when removing an element from the middle of the DLL.
	 */
	@Test
	void testRemoveEMiddleNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("B");
		
		assertEquals("B", deleted);
		assertEquals(2, dllList.size());
		assertEquals("C", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size is decreased, the removed element are firstly founded in the DLL, 
	 * and the element followed by removing one is changed the position 
	 * when removing one of elements having the same value from the DLL.
	 */
	@Test
	void testRemoveEWhenHasDuplicatedNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		dllList.add("B");
		dllList.add("D");
		
		String deleted = dllList.remove("B");
		
		assertEquals("B", deleted);
		assertEquals(4, dllList.size());
		assertEquals("A", dllList.get(0));
		assertEquals("C", dllList.get(1));
		assertEquals("B", dllList.get(2));
		assertEquals("D", dllList.get(3));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the size is correct and no element is removed
	 * when removing an non-containing element from the DLL.
	 */
	@Test
	void testRemoveENotContain() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("D");
		
		assertEquals(3, dllList.size());
		assertNull(deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when removing a "null" from the DLL
	 */
	@Test
	void testRemoveENullPointerException() {
		try {
			dllList.remove(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the empty DLL
	 */
	@Test
	void testSetEmpty() {
		try {
			dllList.set(0, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the size and the changed element are correct, and the value before changed is correct  
	 * when changing an element at the top of the DLL.
	 */
	@Test
	void testSetFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String preValue = dllList.set(0, "D");
		
		assertEquals("A", preValue);
		assertEquals(3, dllList.size());
		assertEquals("D", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the size and the changed element are correct, and the value before changed is correct  
	 * when changing an element at the end of the DLL.
	 */
	@Test
	void testSetLastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String preValue = dllList.set(2, "D");
		
		assertEquals("C", preValue);
		assertEquals(3, dllList.size());
		assertEquals("D", dllList.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the size and the changed element are correct, and the value before changed is correct  
	 * when changing an element at the middle of the DLL.
	 */
	@Test
	void testSetMiddleNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String preValue = dllList.set(1, "D");
		
		assertEquals("B", preValue);
		assertEquals(3, dllList.size());
		assertEquals("D", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when changing an element of the DLL to "null"
	 */
	@Test
	void testSetNullPointerException() {
		try {
			dllList.add("A");
			dllList.set(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when changing an element at the negative index of the DLL
	 */
	@Test
	void testSetLowestIndexOutOfBoundsException() {
		try {
			dllList.set(-1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when changing an element at the out of the DLL
	 */
	@Test
	void testSetHighestIndexOutOfBoundsException() {
		try {
			dllList.add("A");
			dllList.set(1, "B");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 * Check if the size is zero and "true" is returned when the DLL is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(dllList.isEmpty());
		assertEquals(0, dllList.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 * Check if the size is correct and "false" is returned when the DLL is non-empty.
	 */
	@Test
	void testIsEmptyNonEmpty() {
		dllList.add("A");
		dllList.add("B");
		
		assertFalse(dllList.isEmpty());
		assertEquals(2, dllList.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 * Check if "false" is returned when comparing an element to the empty DLL.
	 */
	@Test
	void testContainsEmpty() {		
		boolean contains = dllList.contains("B");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 * Check if "true" is returned when comparing an element to the DLL containing it.
	 */
	@Test
	void testContainsMatching() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		boolean contains = dllList.contains("B");
		
		assertTrue(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 * Check if "false" is returned when comparing an element to the DLL not containing it.
	 */
	@Test
	void testContainsNoMatching() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		boolean contains = dllList.contains("D");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when comparing "null" to the DLL
	 */
	@Test
	void testContainsNullPointerException() {
		try {
			dllList.contains(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty DLL to the generic type of the array
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		
		arr = dllList.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty DLL to the generic type of the array
	 */
	@Test
	void testToArrayEArrayNonEmptySufficient() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String[] arr = new String[3];
		
		arr = dllList.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(dllList.get(i), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 * Check if the size of the array is expanded and the array contains elements
	 * when transferring the non-empty DLL to the generic type of the array having insufficient size.
	 */
	@Test
	void testToArrayEArrayNonEmptyInsufficient() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String[] arr = new String[1];
		
		arr = dllList.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(dllList.get(i), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 * Check if the "NullPointerException" is thrown when transferring "null" DLL to the generic type of the array
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			dllList.toArray(null);
			});
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty DLL to the object type of the array
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = dllList.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty DLL to the object type of the array
	 */
	@Test
	void testToArrayNonEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		Object[] arr = dllList.toArray();
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(dllList.get(i), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 * Check if the "NoSuchElementException" is thrown and "false" returns 
	 * when the iterator traverses from the top to the end in the empty DLL
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> iterator = dllList.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
			});
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 * Check if "true" returns and the element is correctly retrieved 
	 * when the iterator traverses from the top to the end in the non-empty DLL 
	 * And check if "NoSuchElementException" is thrown and "false" returns followed by the end of the DLL 
	 */
	@Test
	void testIteratorNonEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		Iterator<String> iterator = dllList.iterator();
		assertTrue(iterator.hasNext());
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(dllList.get(i++), iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
			});
	}

}
