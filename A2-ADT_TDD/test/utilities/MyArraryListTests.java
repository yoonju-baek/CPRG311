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
	void testSizeNotEmpty() {
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
	void testAddIntENotEmptyAppend() {
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
	void testAddIntENotEmptyPrepend() {
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
	void testAddIntENotEmptyInsert() {
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
	void testAddE() {
		// TODO 3 version
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		// MyArraylist or MyDDL
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	void testGet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	void testRemoveInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	void testSet() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		fail("Not yet implemented");
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
	void testIteratorNotEmpty() {
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
