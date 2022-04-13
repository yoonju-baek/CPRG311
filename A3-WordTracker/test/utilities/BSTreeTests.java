package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

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
class BSTreeTests {

	BSTree<String> tree;
	
	@BeforeEach
	void setUp() throws Exception {
		tree = new BSTree<>();
	}

	@AfterEach
	void tearDown() throws Exception {
		tree = null;
	}

	
	/**
	 * Test method for {@link utilities.BSTreeT#getRoot}.
	 * Check if an root element is retrieved successfully from the non-empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testGetRootNonEmpty() throws TreeException {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		
		assertEquals("B", tree.getRoot().getElement());
	}

	/**
	 * Test method for {@link utilities.BSTreeT#getRoot}.
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
	 * Test method for {@link utilities.BSTreeT#getHeight}.
	 * Check if the height is retrieved successfully from the Non Empty tree
	 */
	@Test
	void testGetHeightNonEmpty() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");

		assertEquals(3, tree.getHeight());
	}

	/**
	 * Test method for {@link utilities.BSTreeT#getHeight}.
	 * Check if the height returns -1 from the empty tree
	 */
	@Test
	void testGetHeightEmpty() {
		assertEquals(0, tree.getHeight());
	}

	/**
	 * Test method for {@link utilities.BSTreeT#getSize}.
	 * Check if the size is retrieved successfully from the Non Empty tree
	 */
	@Test
	void testGetSizeNonEmpty() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		assertEquals(6, tree.size());
	}	
	
	/**
	 * Test method for {@link utilities.BSTreeT#getSize}.
	 * Check if the size returns 0 from the empty tree
	 */
	@Test
	void testGetSizeEmpty() {
		assertEquals(0, tree.size());
	}
	
	/**
	 * Test method for {@link utilities.BSTreeT#isEmpty}.
	 * Check if the tree is empty 
	 */
	@Test
	void testIsEmpty() {
		assertTrue(tree.isEmpty());
	}

	/**
	 * Test method for {@link utilities.BSTreeT#isEmpty}.
	 * Check if the tree is not empty
	 */
	@Test
	void testIsEmptyNonEmpty() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		
		assertFalse(tree.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.BSTreeT#clear}.
	 * Check if the tree will be clear
	 */
	@Test
	void testClear() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		
		assertEquals(3, tree.size());
		
		tree.clear();

		assertTrue(tree.isEmpty());
		assertEquals(0, tree.size());
		assertEquals(0, tree.getHeight());
	}	
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if an element exists in the Non Empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testContainsNonEmptyMatching() throws TreeException {	
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		assertTrue(tree.contains("D"));
	}
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if the "TreeException" is thrown when checking an element exists in the empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testContainsNonEmptyNotMatching() throws TreeException {		
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		assertFalse(tree.contains("A"));
	}
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if the "TreeException" is thrown when checking an element exists in the empty tree
	 */
	@Test
	void testContainsEmpty() {	
		try {
			tree.contains("D");
			fail("TreeException wasn't thrown!");
		} catch (TreeException e) {
			assertTrue(true);
		}
		
	}
	
	/**
	 * Test method for {@link utilities.BSTree##search(java.lang.Object)}.
	 * Returns a node which an element is located in the empty tree
	 */
	@Test
	void testSearchEmpty() {
		try {
			tree.search("D");
			fail("TreeException wasn't thrown!");
		} catch (TreeException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.BSTree##search(java.lang.Object)}.
	 * Returns a node which an element is located in the empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testSearchNonEmptyMatching() throws TreeException {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		assertEquals("D", tree.search("D").getElement());
	}
	
	/**
	 * Test method for {@link utilities.BSTree##search(java.lang.Object)}.
	 * Returns a node which an element is located in the empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testSearchNonEmptyNotMatching() throws TreeException {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		assertNull(tree.search("A"));
	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the empty list.
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testAddEEmpty() throws TreeException {
		boolean added = tree.add("A");
		
		assertTrue(added);
		assertEquals("A", tree.getRoot().getElement());
		assertEquals(1, tree.size());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the non-empty list.
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testAddENonEmpty() throws TreeException {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		
		boolean added = tree.add("D");
		
		assertTrue(added);
		assertEquals("D", tree.search("D").getElement());
		assertEquals(4, tree.size());
		assertEquals(3, tree.getHeight());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 * Check if the "NullPointerException" is thrown when adding "null" to the tree
	 */
	@Test
	void testAddENullPointerException() {
		try {
			tree.add(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	void testInorderIteratorEmpty() {
		Iterator<String> iterator = tree.inorderIterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
				iterator.next();
				});
	}
	
	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	void testInorderIteratorNonEmpty() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		// In-order = {B, C, D, F, G, H}
		String[] inOrder = {"B", "C", "D", "F", "G", "H"};
		
		Iterator<String> iterator = tree.inorderIterator();
		assertTrue(iterator.hasNext());
		
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(inOrder[i++], iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	void testPreorderIteratorEmpty() {
		Iterator<String> iterator = tree.preorderIterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
				iterator.next();
				});
	}
	
	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	void testPreorderIteratorNonEmpty() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		// Pre-order = {F, C, B, D, H, G}
		String[] preOrder = {"F", "C", "B", "D", "H", "G"};
		
		Iterator<String> iterator = tree.preorderIterator();
		assertTrue(iterator.hasNext());
		
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(preOrder[i++], iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	void testPostorderIteratorEmpty() {
		Iterator<String> iterator = tree.postorderIterator();
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
				iterator.next();
				});
	}
	
	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	void testPostorderIteratorNonEmpty() {
		tree.add("F");
		tree.add("C");
		tree.add("B");
		tree.add("H");
		tree.add("D");
		tree.add("G");
		
		// Post-order = {B, D, C, G, H, F}
		String[] postOrder = {"B", "D", "C", "G", "H", "F"};
		
		Iterator<String> iterator = tree.postorderIterator();
		assertTrue(iterator.hasNext());
		
		int i = 0;
		while(iterator.hasNext()) {
			assertEquals(postOrder[i++], iterator.next());
		}
		assertFalse(iterator.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			iterator.next();
		});
	}

}
