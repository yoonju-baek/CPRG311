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
 * @version Apr 13 2022
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		
		
		assertEquals("fiction", tree.getRoot().getElement());
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertEquals(7, tree.getHeight());
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertEquals(20, tree.size());
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		
		assertFalse(tree.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.BSTreeT#clear}.
	 * Check if the tree will be clear
	 */
	@Test
	void testClear() {
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertEquals(20, tree.size());
		
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertTrue(tree.contains("houses"));
	}
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if the "TreeException" is thrown when checking an element exists in the empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testContainsNonEmptyNotMatching() throws TreeException {		
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertFalse(tree.contains("file"));
	}
	
	/**
	 * Test method for {@link utilities.BSTree##contains(java.lang.Object)}.
	 * Check if the "TreeException" is thrown when checking an element exists in the empty tree
	 */
	@Test
	void testContainsEmpty() {	
		try {
			tree.contains("tree");
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
			tree.search("tree");
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertEquals("kite", tree.search("kite").getElement());
	}
	
	/**
	 * Test method for {@link utilities.BSTree##search(java.lang.Object)}.
	 * Returns a node which an element is located in the empty tree
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testSearchNonEmptyNotMatching() throws TreeException {
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		assertNull(tree.search("file"));
	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 * Check if an element is added successfully, and the size and the added element are correct
	 * when adding an element to the empty list.
	 * @throws TreeException if the tree is empty.
	 */
	@Test
	void testAddEEmpty() throws TreeException {
		boolean added = tree.add("fiction");
		
		assertTrue(added);
		assertEquals("fiction", tree.getRoot().getElement());
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		
		boolean added = tree.add("bird");
		
		assertTrue(added);
		assertEquals("fiction", tree.getRoot().getElement());
		assertEquals("cherries", tree.getRoot().getLeft().getElement());
		assertEquals("bedroom", tree.getRoot().getLeft().getLeft().getElement());
		assertEquals("cemetery", tree.getRoot().getLeft().getLeft().getRight().getElement());
		assertEquals("boy", tree.getRoot().getLeft().getLeft().getRight().getLeft().getElement());
		assertEquals("bird", tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft().getElement());
		assertEquals(20, tree.size());
		assertEquals(7, tree.getHeight());
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		try {
			// left tree of the root
			assertEquals("fiction", tree.getRoot().getElement());
			assertEquals("cherries", tree.getRoot().getLeft().getElement());
			assertEquals("bedroom", tree.getRoot().getLeft().getLeft().getElement());
			assertEquals("cemetery", tree.getRoot().getLeft().getLeft().getRight().getElement());
			assertEquals("boy", tree.getRoot().getLeft().getLeft().getRight().getLeft().getElement());
			assertEquals("bird", tree.getRoot().getLeft().getLeft().getRight().getLeft().getLeft().getElement());
			assertEquals("cord", tree.getRoot().getLeft().getRight().getElement());
			// right tree of the root
			assertEquals("voyage", tree.getRoot().getRight().getElement());
			assertEquals("lettuce", tree.getRoot().getRight().getLeft().getElement());
			assertEquals("honey", tree.getRoot().getRight().getLeft().getLeft().getElement());
			assertEquals("glove", tree.getRoot().getRight().getLeft().getLeft().getLeft().getElement());
			assertEquals("icicle", tree.getRoot().getRight().getLeft().getLeft().getRight().getElement());
			assertEquals("houses", tree.getRoot().getRight().getLeft().getLeft().getRight().getLeft().getElement());
			assertEquals("kite", tree.getRoot().getRight().getLeft().getLeft().getRight().getRight().getElement());
			assertEquals("pencil", tree.getRoot().getRight().getLeft().getRight().getElement());			
			assertEquals("reaction", tree.getRoot().getRight().getLeft().getRight().getRight().getElement());
			assertEquals("tree", tree.getRoot().getRight().getLeft().getRight().getRight().getRight().getElement());
			assertEquals("tax", tree.getRoot().getRight().getLeft().getRight().getRight().getRight().getLeft().getElement());
			assertEquals("tub", tree.getRoot().getRight().getLeft().getRight().getRight().getRight().getRight().getElement());
			assertEquals("war", tree.getRoot().getRight().getRight().getElement());

	} catch (TreeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		String[] inOrder = {"bedroom", "bird", "boy", "cemetery", "cherries", "cord", "fiction", "glove", "honey", "houses", "icicle", "kite", "lettuce", "pencil", "reaction", "tax", "tree", "tub", "voyage", "war"}; 
		
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		String[] preOrder = {"fiction", "cherries", "bedroom", "cemetery", "boy", "bird", "cord", "voyage", "lettuce", "honey", "glove", "icicle", "houses", "kite", "pencil", "reaction", "tree", "tax", "tub", "war"};
		
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
		tree.add("fiction");
		tree.add("cherries");
		tree.add("voyage");
		tree.add("lettuce");
		tree.add("honey");
		tree.add("bedroom");
		tree.add("cemetery");
		tree.add("pencil");
		tree.add("reaction");
		tree.add("tree");
		tree.add("glove");
		tree.add("cord");
		tree.add("icicle");
		tree.add("tub");
		tree.add("houses");
		tree.add("boy");
		tree.add("kite");
		tree.add("tax");
		tree.add("war");
		tree.add("bird");
		
		String[] postOrder = {"bird", "boy", "cemetery", "bedroom", "cord", "cherries", "glove", "houses", "kite", "icicle", "honey", "tax", "tub", "tree", "reaction", "pencil", "lettuce", "war", "voyage", "fiction"};
		
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
