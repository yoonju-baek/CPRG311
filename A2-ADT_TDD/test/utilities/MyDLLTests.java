package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author mbibe
 *
 */
class MyDLLTests {
	//attributes
	ListADT<String> dllList;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dllList = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		dllList = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, dllList.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		assertEquals(3, dllList.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
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
	 */
	@Test
	void testAddIntENotEmptyAppend() {
		dllList.add("A");
		boolean added = dllList.add(1, "B");
		
		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENotEmptyPrepend() {
		dllList.add("B");
		boolean added = dllList.add(0, "A");
		
		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("A", dllList.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENotEmptyInsert() {
		dllList.add("A");
		dllList.add("C");
		boolean added = dllList.add(1, "B");
		
		assertTrue(added);
		assertEquals(3, dllList.size());
		assertEquals("B", dllList.get(1));
		
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
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
	 */
	@Test
	void testAddENotEmpty() {
		dllList.add("A");
		boolean added = dllList.add("B");
		
		assertTrue(added);
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
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
	 */
	@Test
	void testAddAllEmpty() {
		MyDLL<String> newList = new MyDLL<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");
		
		boolean added = dllList.addAll((ListADT<? extends String>) newList);
		
		assertTrue(added);
		assertEquals(3, dllList.size());
		assertEquals("D", dllList.get(0));
		assertEquals("E", dllList.get(1));
		assertEquals("F", dllList.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllNotEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		MyDLL<String> newList = new MyDLL<>();
		newList.add("D");
		newList.add("E");
		newList.add("F");
		
		boolean added = dllList.addAll((ListADT<? extends String>) newList);
		
		assertTrue(added);
		assertEquals(6, dllList.size());
		assertEquals("D", dllList.get(3));
		assertEquals("E", dllList.get(4));
		assertEquals("F", dllList.get(5));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
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
	 */
	@Test
	void testGetNotEmpty() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String value = dllList.get(2);
		
		assertEquals("C", value);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
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
	 */
	@Test
	void testRemoveIntFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove(0);
		
		assertEquals(2, dllList.size());
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntLastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove(2);
		
		assertEquals(2, dllList.size());
		assertEquals("C", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntMiddleNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove(1);
		
		assertEquals(2, dllList.size());
		assertEquals("B", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
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
	 */
	@Test
	void testRemoveEEmpty() {
		String deleted = dllList.remove("A");
		
		assertEquals(0, dllList.size());
		assertEquals(null, deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
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
	 */
	@Test
	void testRemoveEFirstNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("A");
		
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(0));
		assertEquals("A", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveELastNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("C");
		
		assertEquals(2, dllList.size());
		assertEquals("B", dllList.get(1));
		assertEquals("C", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveEMiddleNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("B");
		
		assertEquals(2, dllList.size());
		assertEquals("C", dllList.get(1));
		assertEquals("B", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENodeIfHasDuplicatedNode() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		dllList.add("B");
		dllList.add("D");
		
		String deleted = dllList.remove("B");
		
		assertEquals(4, dllList.size());
		assertEquals("A", dllList.get(0));
		assertEquals("C", dllList.get(1));
		assertEquals("B", dllList.get(2));
		assertEquals("D", dllList.get(3));
		assertEquals("B", deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENotContain() {
		dllList.add("A");
		dllList.add("B");
		dllList.add("C");
		
		String deleted = dllList.remove("D");
		
		assertEquals(3, dllList.size());
		assertEquals(null, deleted);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
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
	 */
	@Test
	void testIsEmpty() {
		assertTrue(dllList.isEmpty());
		assertEquals(0, dllList.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsEmpty() {		
		boolean contains = dllList.contains("B");
		
		assertFalse(contains);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
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
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			dllList.toArray(null);
			});
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = dllList.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
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
	 */
	@Test
	void testIteratorNotEmpty() {
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
