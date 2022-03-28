package utilities;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author mbibe
 *
 */
class MyArraryListTests {
	//attributes
	ListADT<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
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
	 */
	@Test
	void testRemoveEEmpty() {
		String deleted = list.remove("A");
		
		assertEquals(0, list.size());
		assertNull(deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
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
	 */
	@Test
	void testIsEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
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
	 */
	@Test
	void testContainsEmpty() {
		boolean contains = list.contains("B");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
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
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			list.toArray(null);
			});
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = list.toArray();
		assertEquals(0, arr.length);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
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
