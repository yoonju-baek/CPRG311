package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;

import exceptions.TreeException;

/**
 * Represents a BSTree.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 09 2022
 */
public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {

	private static final long serialVersionUID = 1L;
	
	private BSTreeNode<E> root;
	
	/**
	 * Initializes a BSTree object.
	 */
	public BSTree() {
		this.root = null;
	}
	
	/**
	 * Initializes a BSTree object.
	 * 
	 * @param element the element to be stored.
	 */
	public BSTree(E element) {
		this.root = new BSTreeNode<E>(element, null, null);
	}

	/**
	 * The node at the root of the Binary Search Tree will be returned.
	 * 
	 * @return node stored at the root of tree is returned
	 * @throws TreeException if the root is empty.
	 */
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		if(root == null) {
			throw new TreeException();
		}
		
		return this.root;
	}

	/**
	 * Determines the row height of the tree and returns that value as an integer value.
	 * 
	 * @return the height of the tree.
	 */
	@Override
	public int getHeight() {
		if(root == null) {
			return 0;
		}
		else {
			return root.getHeight();
		}
	}
	
	
	/**
	 * The number of elements currently stored in the tree is counted and the value is returned.
	 * 
	 * @return number of elements currently stored in tree.
	 */
	@Override
	public int size() {
		if(root == null) {
			return 0;
		}
		else {
			return root.getNumberNodes();
		}
	}
	

	/**
	 * Checks if the tree is currently empty.
	 * 
	 * @return returns boolean true if the tree is empty otherwise false.
	 */
	@Override
	public boolean isEmpty() {
		return (root == null);
	}

	/**
	 * Clears all elements currently stored in tree and makes the tree empty.
	 */
	@Override
	public void clear() {
		root = null;
	}

	/**
	 * Checks the current tree to see if the element passed in is stored in
	 * the tree. If the element is found in the tree the method returns true
	 * and if the element is not in the tree the method returns false.
	 * 
	 * @param entry the element to find in the tree
	 * @return returns boolean true if element is currently in the tree and
	 * 			false if the element is not found in the tree
	 * @throws TreeException if the tree is empty.
	 */
	@Override
	public boolean contains(E entry) throws TreeException {
		return (search(entry) != null);
	}

	/**
	 * Retrieves a node from the tree given the object to search for.
	 * 
	 * @param entry element object being searched
	 * @return the node with the element located in tree, null if not found
	 * @throws TreeException if the tree is empty
	 */
	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		if(root == null) {
			throw new TreeException();
		}
		
		BSTreeNode<E> node = root;
		
		while(node != null) {
			if(node.getElement().compareTo(entry) > 0) {
				node = node.getLeft();
			} else if(node.getElement().compareTo(entry) < 0){
				node = node.getRight();
			} else {
				break;
			}
		}
		
		return node;
	}

	/**
	 * Adds a new element to the tree according to the natural ordering
	 * established by the Comparable implementation.
	 * 
	 * @param newEntry the element being added to the tree
	 * @return a boolean true if the element is added successfully else false
	 * @throws NullPointerException if the element being added is null
	 */
	@Override
	public boolean add(E newEntry) throws NullPointerException {
		if(newEntry == null) {
			throw new NullPointerException();
		}
		
		boolean addResult = false;
		
		BSTreeNode<E> newNode = new BSTreeNode<E>(newEntry, null, null);
		
		if(root == null) {
			root = newNode;
			addResult = true;
		}
		else {
			BSTreeNode<E> node = root;
				
			while(node != null) {
				if(node.getElement().compareTo(newEntry) > 0) {
					if(node.hasLeftChild()) {
						node = node.getLeft();
					}
					else {
						node.setLeft(newNode);
						addResult = true;
					}
				} 
				else if(node.getElement().compareTo(newEntry) < 0) {
					if(node.hasRightChild()) {
						node = node.getRight();
					} else {
						node.setRight(newNode);
						addResult = true;
					}
				}
				else {
					// if equal????
					break;
				}
			}
		}
		
		return addResult;
	}

	/**
	 * Generates an in-order iteration over the contents of the tree. Elements
	 * are in their natural order.
	 * 
	 * @return an iterator with the elements in the natural order
	 */
	@Override
	public Iterator<E> inorderIterator() {
		return new BSTInorderIterator();
	}

	/**
	 * Generates a pre-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is first.
	 * 
	 * @return an iterator with the elements in a root element first order
	 */
	@Override
	public Iterator<E> preorderIterator() {
		return new BSTPreorderIterator();
	}

	/**
	 * Generates a post-order iteration over the contents of the tree. Elements
	 * are order in such a way as the root element is last.
	 * 
	 * @return an iterator with the elements in a root element last order
	 */
	@Override
	public Iterator<E> postorderIterator() {
		return new BSTPostorderIterator();
	}

	/***********************************IN-ORDER INNER CLASS*******************************************/
	private class BSTInorderIterator implements Iterator<E> {
		private Stack<BSTreeNode<E>> travStack;
		private BSTreeNode<E> currNode;
		
		/**
		 * Initialize BSTInorderIterator
		 * 
		 * @param root root node of the tree
		 */
		public BSTInorderIterator() {
			travStack = new Stack<>();
			currNode = root;
	
			while(currNode != null) {
				travStack.push(currNode);
				currNode = currNode.getLeft();
			}
		}
		
		/**
		 * Returns true if the iteration has more elements. 
		 * (In other words, returns true if next() 
		 * would return an element rather than throwing an exception.)
		 * 
		 * @return true if the iterator has more elements.
		 */
		@Override
		public boolean hasNext() {
			return (!travStack.isEmpty());
		}

		/**
		 * Returns the next element in the iteration in the in-order sequence.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException If the iteration has no more elements.
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) throw new NoSuchElementException();
			
			currNode = travStack.pop();
			
			BSTreeNode<E> node = currNode.getRight();
			while(node != null) {
				travStack.push(node);
				node = node.getLeft();
			}
			
			return currNode.getElement();
		}
	}
	
	/***********************************PRE-ORDER INNER CLASS*******************************************/
	private class BSTPreorderIterator implements Iterator<E> {
		private Stack<BSTreeNode<E>> travStack;
		private BSTreeNode<E> currNode;
		
		/**
		 * Initialize BSTPreorderIterator
		 * iterate Root Left Right
		 */
		public BSTPreorderIterator() {
			travStack = new Stack<>();
			currNode = root;
			
			if(root != null) {
				travStack.push(currNode);
			}
		}
		
		/**
		 * Returns true if the iteration has more elements. 
		 * (In other words, returns true if next() 
		 * would return an element rather than throwing an exception.)
		 * 
		 * @return true if the iterator has more elements.
		 */
		@Override
		public boolean hasNext() {
			return (!travStack.isEmpty());
		}

		/**
		 * Returns the next element in the iteration in the pre-order sequence.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException
		 * 			If the iteration has no more elements.
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) throw new NoSuchElementException();
			
			if(!travStack.isEmpty()) {
				currNode = travStack.pop();
				
				if(currNode.getRight() != null) {
					travStack.push(currNode.getRight());
				}
				if(currNode.getLeft() != null) {
					travStack.push(currNode.getLeft());
				}
			}
			
			return currNode.getElement();
		}
	}

	/***********************************POST-ORDER INNER CLASS*******************************************/
	private class BSTPostorderIterator implements Iterator<E> {
		private Stack<BSTreeNode<E>> travStack;
		private BSTreeNode<E> currNode;
			
		/**
		 * Initialize BSTInorderIterator
		 * 
		 */
		public BSTPostorderIterator() {
			travStack = new Stack<>();
			currNode = root;
			
			if(root != null) {
				travStack.push(currNode);
			}
		}
			
		/**
		 * Returns true if the iteration has more elements. 
		 * (In other words, returns true if next() 
		 * would return an element rather than throwing an exception.)
		 * 
		 * @return true if the iterator has more elements.
		 */
		@Override
		public boolean hasNext() {
			return (!travStack.isEmpty());
		}

		/**
		 * Returns the next element in the iteration in the post-order sequence.
		 * 
		 * @return The next element in the iteration.
		 * @throws NoSuchElementException
		 * 			If the iteration has no more elements.
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) throw new NoSuchElementException();
			
			while(!travStack.isEmpty()) {
				currNode = travStack.pop();
				
				if(currNode.getLeft() != null) {
					travStack.push(currNode.getLeft());
				}
				
				if(currNode.getRight() != null) {
					travStack.push(currNode.getRight());
				}
			}
			
			return currNode.getElement();
		}

	}
}

