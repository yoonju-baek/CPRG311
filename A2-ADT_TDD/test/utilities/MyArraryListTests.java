package utilities;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * These are the JUnit tests for every method in the MyArrayList class. 
 * There are multiple tests for each method to ensure that the implementation is completed. 
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * 
 */
class MyArraryListTests {
	//attributes
	ListADT<String> list;

	/**
     * This will run the method once to instantiate, before starting tests. 
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList<>();
	}

	/**
	 * This will run the method once to clear instantiation, after finished all tests.  
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 * Check if the size is zero when the list is empty.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 * Check if the size is correct when the list has the specific number of elements.
	 */
	@Test
	void testSizeNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 * Check if the size is zero after executing the "clear" method when the list contains elements.
	 */
	@Test
	void testClear() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		assertEquals(3, list.size());
		
		list.clear();
		
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element into the specific index of the empty list.
	 */
	@Test
	void testAddIntEEmpty() {
		boolean added = list.add(0, "A");
		
		assertTrue(added);
		assertEquals(1, list.size());
		assertEquals("A", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if an element is added at the end of the list successfully, and the size and the added element are correct
	 * when adding an element into the specific index of the non-empty list.
	 */
	@Test
	void testAddIntENonEmptyAppend() {
		list.add("A");
		boolean added = list.add(1, "B");
				
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if an element is added at the top of the list successfully, and the size and the added element are correct
	 * when adding an element into the specific index of the non-empty list.
	 */
	@Test
	void testAddIntENonEmptyPrepend() {
		list.add("B");
		boolean added = list.add(0, "A");
		
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("A", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if an element is added between existing elements successfully, and the size and the added element are correct
	 * when inserting an element into the middle index of the non-empty list.
	 */
	@Test
	void testAddIntENonEmptyInsert() {
		list.add("A");
		list.add("C");
		boolean added = list.add(1, "B");
		
		assertTrue(added);
		assertEquals(3, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when adding "null" into the specific index of the list
	 */
	@Test
	void testAddIntENullPointerException() {
		try {
			list.add(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when adding an element into the negative index of the list
	 */
	@Test
	void testAddIntELowestIndexOutOfBoundsException() {
		try {
			list.add(-1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when adding an element into the out of the index of the list
	 */
	@Test
	void testAddIntEHighestIndexOutOfBoundsException() {
		try {
			list.add(1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the empty list.
	 */
	@Test
	void testAddEEmpty() {
		boolean added = list.add("A");
		
		assertTrue(added);
		assertEquals(1, list.size());
		assertEquals("A", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 * Check if an element is added at the end of the list successfully, and the size and the added element are correct
	 * when adding an element to the non-empty list.
	 */
	@Test
	void testAddENonEmpty() {
		list.add("A");
		boolean added = list.add("B");
		
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when adding "null" to the list
	 */
	@Test
	void testAddENullPointerException() {
		try {
			list.add(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 * Check if all elements of a list are added successfully, and the size and all elements in the list are correct
	 * when adding a list to the empty list.
	 */
	@Test
	void testAddAllEmpty() {
		MyArrayList<String> newList = new MyArrayList<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");
		
		boolean added = list.addAll(newList);
		
		assertTrue(added);
		assertEquals(3, list.size());
		assertEquals("D", list.get(0));
		assertEquals("E", list.get(1));
		assertEquals("F", list.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 * Check if all elements of a list are added successfully at the end of another list, and the size and all elements in the list are correct
	 * when adding a list to another non-empty list.
	 */
	@Test
	void testAddAllNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		MyArrayList<String> newList = new MyArrayList<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");
		
		boolean added = list.addAll(newList);
		
		assertTrue(added);
		assertEquals(6, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 * Check if the "NullPointerException" is thrown when adding a "null" list to another list
	 */
	@Test
	void testAddAllNullPointerException() {
		try {
			list.addAll(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when retrieving an element from the empty list
	 */
	@Test
	void testGetEmpty() {
		try {
			list.get(0);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 * Check if an element is retrieved successfully from the non-empty list
	 */
	@Test
	void testGetNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String value = list.get(2);
		
		assertEquals("C", value);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when retrieving an element from the negative index of the empty list
	 */
	@Test
	void testGetLowestIndexOutOfBoundsException() {
		try {
			list.get(-1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when retrieving an element from the out of index of the empty list 
	 */
	@Test
	void testGetHighestIndexOutOfBoundsException() {
		try {
			list.add("A");
			list.get(1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the empty list
	 */
	@Test
	void testRemoveIntEmpty() {
		try {
			list.remove(0);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the size is zero and the removed element is correct
	 * when removing an element from the list containing only one element using index number.
	 */
	@Test
	void testRemoveIntWhenOnlyOneElementExists() {
		list.add("A");
		
		String deleted = list.remove(0);
		
		assertEquals(0, list.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the size and the removed element are correct, and the second element is changed the position to the top of the list 
	 * when removing an element from the top of the list using index number.
	 */
	@Test
	void testRemoveIntFirstElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove(0);
		
		assertEquals("A", deleted);
		assertEquals(2, list.size());
		assertEquals("B", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the size and the removed element are correct, and the element in front of removing one is not changed the position 
	 * when removing an element at the end of the list using index number.
	 */
	@Test
	void testRemoveIntLastElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove(2);
		
		assertEquals("C", deleted);
		assertEquals(2, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the size and the removed element are correct, and the element followed by removing one is changed the position 
	 * when removing an element from the middle of the list using index number.
	 */
	@Test
	void testRemoveIntMiddleElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove(1);
		
		assertEquals("B", deleted);
		assertEquals(2, list.size());
		assertEquals("C", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the negative index of the list
	 */
	@Test
	void testRemoveIntLowestIndexOutOfBoundsException() {
		try {
			list.remove(-1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the out of the index of the list
	 */
	@Test
	void testRemoveIntHighestIndexOutOfBoundsException() {
		try {
			list.add("A");
			list.remove(1);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size is correct and no element is removed
	 * when removing an element from the empty list.
	 */
	@Test
	void testRemoveEEmpty() {
		String deleted = list.remove("A");
		
		assertEquals(0, list.size());
		assertNull(deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct
	 * when removing an element from the list containing only one element. 
	 */
	@Test
	void testRemoveEWhenOnlyOneElementExists() {
		list.add("A");
		
		String deleted = list.remove("A");
		
		assertEquals(0, list.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct, and the second element is changed the position to the top of the list 
	 * when removing an element from the top of the list.
	 */
	@Test
	void testRemoveEFirstElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove("A");
		
		assertEquals("A", deleted);
		assertEquals(2, list.size());
		assertEquals("B", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct, and the element in front of removing one is not changed the position 
	 * when removing an element at the end of the list.
	 */
	@Test
	void testRemoveELastElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove("C");
		
		assertEquals("C", deleted);
		assertEquals(2, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size and the removed element are correct, and the element followed by removing one is changed the position 
	 * when removing an element from the middle of the list.
	 */
	@Test
	void testRemoveEMiddleElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove("B");
		
		assertEquals("B", deleted);
		assertEquals(2, list.size());
		assertEquals("C", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size is decreased, the removed element are firstly founded in the list, 
	 * and the element followed by removing one is changed the position
	 * when removing one of elements having the same value from the list.
	 */
	@Test
	void testRemoveEWhenHasDuplicatedElements() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("B");
		list.add("D");
		
		String deleted = list.remove("B");
		
		assertEquals("B", deleted);
		assertEquals(4, list.size());
		assertEquals("A", list.get(0));
		assertEquals("C", list.get(1));
		assertEquals("B", list.get(2));
		assertEquals("D", list.get(3));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the size is correct and no element is removed
	 * when removing an non-containing element from the list.
	 */
	@Test
	void testRemoveENotContain() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String deleted = list.remove("D");
		
		assertEquals(3, list.size());
		assertNull(deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when removing a "null" from the list
	 */
	@Test
	void testRemoveENullPointerException() {
		try {
			list.remove(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when removing an element from the empty list
	 */
	@Test
	void testSetEmpty() {
		try {
			list.set(0, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the size and the changed element are correct, and the value before changed is correct  
	 * when changing an element at the top of the list. 
	 */
	@Test
	void testSetFirstElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String preValue = list.set(0, "D");
		
		assertEquals("A", preValue);
		assertEquals(3, list.size());
		assertEquals("D", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the size and the changed element are correct, and the value before changed is correct  
	 * when changing an element at the end of the list.
	 */
	@Test
	void testSetLastElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String preValue = list.set(2, "D");
		
		assertEquals("C", preValue);
		assertEquals(3, list.size());
		assertEquals("D", list.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the size and the changed element are correct, and the value before changed is correct  
	 * when changing an element at the middle of the list.
	 */
	@Test
	void testSetMiddleElement() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String preValue = list.set(1, "D");
		
		assertEquals("B", preValue);
		assertEquals(3, list.size());
		assertEquals("D", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when changing an element of the list to "null"
	 */
	@Test
	void testSetNullPointerException() {
		try {
			list.add("A");
			list.set(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when changing an element at the negative index of the list
	 */
	@Test
	void testSetLowestIndexOutOfBoundsException() {
		try {
			list.set(-1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 * Check if the "IndexOutOfBoundsException" is thrown when changing an element at the out of the list
	 */
	@Test
	void testSetHighestIndexOutOfBoundsException() {
		try {
			list.add("A");
			list.set(1, "B");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 * Check if the size is zero and "true" is returned when the list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 * Check if the size is correct and "false" is returned when the list is non-empty.
	 */
	@Test
	void testIsEmptyNonEmpty() {
		list.add("A");
		list.add("B");
		
		assertFalse(list.isEmpty());
		assertEquals(2, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 * Check if "false" is returned when comparing an element to the empty list.
	 */
	@Test
	void testContainsEmpty() {
		boolean contains = list.contains("B");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 * Check if "true" is returned when comparing an element to the list containing it.
	 */
	@Test
	void testContainsMatching() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		boolean contains = list.contains("B");
		
		assertTrue(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 * Check if "false" is returned when comparing an element to the list not containing it.
	 */
	@Test
	void testContainsNoMatching() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		boolean contains = list.contains("D");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 * Check if the "NullPointerException" is thrown when comparing "null" to the list
	 */
	@Test
	void testContainsNullPointerException() {
		try {
			list.contains(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty list to the generic type of the array
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty list to the generic type of the array
	 */
	@Test
	void testToArrayEArrayNonEmptySufficient() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String[] arr = new String[3];
		
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 * Check if the size of the array is expanded and the array contains elements
	 * when transferring the non-empty list to the generic type of the array having insufficient size.
	 */
	@Test
	void testToArrayEArrayNonEmptyInsufficient() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		String[] arr = new String[1];
		
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 * Check if the "NullPointerException" is thrown when transferring "null" list to the generic type of the array
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			list.toArray(null);
			});
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 * Check if the size of the array is correct and the array is empty
	 * when transferring the empty list to the object type of the array
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = list.toArray();
		assertEquals(0, arr.length);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 * Check if the size of the array is correct and the array contains elements
	 * when transferring the non-empty list to the object type of the array
	 */
	@Test
	void testToArrayNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Object[] arr = list.toArray();
		assertEquals(3, arr.length);
		
		for(int i=0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 * Check if the "NoSuchElementException" is thrown and "false" returns 
	 * when the iterator traverses in the empty list
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> iterator = list.iterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
			});
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 * Check if "true" returns and the element is correctly retrieved 
	 * when the iterator traverses from the top to the end in the non-empty list 
	 * And check if "NoSuchElementException" is thrown and "false" returns followed by the end of the list 
	 * 
	 */
	@Test
	void testIteratorNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		
		Iterator<String> iterator = list.iterator();
		assertTrue(iterator.hasNext());
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(list.get(i++), iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
			});
	}
}
