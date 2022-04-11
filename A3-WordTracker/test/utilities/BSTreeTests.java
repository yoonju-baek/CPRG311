package utilities;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;

/**
 * These are the JUnit tests for every method in the BSTree class. 
 * There are multiple tests for each method to ensure that the implementation is completed. 
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 09 2022
 * 
 */
class BSTreeTests<E extends Comparable<? super E>> {

	BSTree<E> tree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new BSTree<E>();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}

	
	/**
	 * Test method for {@link utilities.BSTree#getRoot}.
	 * Check if an root element is retrieved successfully from the non-empty tree
	 */
	@Test
	void testGetRoot() {
		tree.add((E) "B");
		tree.add((E) "A");
		tree.add((E) "C");
		
		try {
			assertEquals("B", tree.getRoot());
		} catch (TreeException e) {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot}.
	 * Check if the "TreeException" is thrown when retrieving an root element from the empty tree
	 */
	@Test
	void testGetRootEmpty() {
		try {
			tree.getRoot();
			fail("TreeException wasn't thrown!");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.BSTree#getHeight}.
	 * Check if the height is retrieved successfully from the tree
	 */
	@Test
	void testGetHeight() {
		tree.add((E) "F");
		tree.add((E) "C");
		tree.add((E) "B");
		tree.add((E) "H");
		tree.add((E) "D");
		tree.add((E) "G");

		assertEquals(3, tree.getHeight());
	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight}.
	 * Check if the height returns -1 from the empty tree
	 */
	@Test
	void testGetHeightEmpty() {
		assertEquals(-1, tree.getHeight());
	}

	/**
	 * Test method for {@link utilities.BSTree#getSize}.
	 * Check if the size is retrieved successfully from the tree
	 */
	@Test
	void testGetSize() {
		tree.add((E) "F");
		tree.add((E) "C");
		tree.add((E) "B");
		tree.add((E) "H");
		tree.add((E) "D");
		tree.add((E) "G");
		
		assertEquals(6, tree.size());
	}	
	
	/**
	 * Test method for {@link utilities.BSTree#getSize}.
	 * Check if the size returns 0 from the empty tree
	 */
	@Test
	void testGetSizeEmpty() {
		assertEquals(0, tree.size());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#isEmpty}.
	 * Check if the tree is empty 
	 */
	@Test
	void testIsEmpty() {
		assertTrue(tree.isEmpty());
	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty}.
	 * Check if the tree is not empty
	 */
	@Test
	void testIsEmptyNotEmpty() {
		tree.add((E) "A");
		
		assertFalse(tree.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#clear}.
	 * Check if the tree will be clear
	 */
	@Test
	void testClear() {
		tree.add((E) "B");
		tree.add((E) "A");
		tree.add((E) "C");
		tree.clear();

		assertTrue(tree.isEmpty());
	}	
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if an element exists in the tree
	 */
	@Test
	void testContains() {	
		tree.add((E) "F");
		tree.add((E) "C");
		tree.add((E) "B");
		tree.add((E) "H");
		tree.add((E) "D");
		tree.add((E) "G");
		
		try {
			assertTrue(tree.contains((E) "D"));
		} catch (TreeException e) {
			assertFalse(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if the "TreeException" is thrown when checking an element exists in the empty tree
	 */
	@Test
	void testContainsEmpty() {		
		try {
			assertFalse(tree.contains((E) "D"));
		} catch (TreeException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.BSTree##search(java.lang.Object)}.
	 * Returns a node which an element is located in the tree
	 * @throws TreeException 
	 */
	@Test
	void testSearch() throws TreeException {
		tree.add((E) "F");
		tree.add((E) "C");
		tree.add((E) "B");
		tree.add((E) "H");
		tree.add((E) "D");
		tree.add((E) "G");

		assertTrue(tree.search((E) "D"));
	}


	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testInorderIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testPreorderIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testPostorderIterator() {
		fail("Not yet implemented");
	}

}
