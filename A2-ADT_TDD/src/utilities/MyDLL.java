package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * Utility class for doubly linked list
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * @param <E> The type of element this iterator returns
 */
public class MyDLL<E> implements ListADT<E> {

	private static final long serialVersionUID = 1L;
	
	private MyDLLNode<E> head, tail;
	
	private int size = 0;
	
	public MyDLL() {
		this.head = this.tail = null;
	}

	public MyDLL(MyDLLNode<E> head, MyDLLNode<E> tail) {
		this.head = head;
		this.tail = tail;
	}
	/**
	 * The size method will return the current element count contained 
	 * in the list.
	 * 
	 * @return The current element count
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	@Override
	public void clear() {
		head = tail = null;
		size = 0;
	}
	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and,
	 * any subsequent elements to the right (adds one to their indices).
	 * 
	 * @param index
	 * @param toAdd
	 * @return true if the element is added successfully
	 * @throws NullPointerException if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
		
		if(isEmpty()) {
			head = tail = newNode;
		}
		else {		
			if(index == 0) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			}
			else if(index == size) {
				return add(toAdd);
			}
			else {
				MyDLLNode<E> curr = head;
				
				for(int i = 0; i < index; i++) {
					curr = curr.getNext();
				}
				
				curr.getPrev().setNext(newNode);
				newNode.setPrev(curr.getPrev());
				curr.setPrev(newNode);
				newNode.setNext(curr);
			}
		}
		
		size++;
		
		return true;
	}
	
	/**
	 * Appends the specified element to the end of this list
	 * 
	 * @param toAdd
	 * @return true if element is appended successfully
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
		
		if(!isEmpty()) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		} else {
			head = tail = newNode;
		}
		
		size++;
		
		return true;
	}
	
	/**
	 * Appends all of the elements to the end of the list
	 * 
	 * @param toAdd
	 * @return true if the operation is successful
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode;
		
		int startIndex = 0;
		if(isEmpty()) {
			newNode = new MyDLLNode<>(toAdd.get(0));
			head = tail = newNode;
			
			size++;
			startIndex = 1;
		}
		
		for(int i = startIndex; i < toAdd.size(); i++) {
			newNode = new MyDLLNode<>(toAdd.get(i));
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
			
			size++;
		}
		
		return true;
	}
	
	/**
	 * Returns the element at the specified position in this list
	 * 
	 * @param index
	 * @return The element at the specified position in this list
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		MyDLLNode<E> curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr.getElement();
	}
	
	/**
	 * Removes the element at the specified position in this list
	 * 
	 * @param index
	 * @return The removed element
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E deleted = null;
		
		if(index == 0) {
			deleted = head.getElement();
			
			if(head == tail) {
				head = tail = null;
			}
			else {
				head.getNext().setPrev(null);
				head = head.getNext();
			}
		} else if(index == size() - 1) {
			deleted = tail.getElement();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			MyDLLNode<E> curr = head;
			
			for(int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			deleted = curr.getElement();
			
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
		}
		
		size--;
		
		return deleted;
	}

	/**
	 * Removes the first occurrence in this list of the specified element
	 * @param toRemove
	 * @return The element which is being removed or
	 *         null if the list does not contain the element
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) {
			throw new NullPointerException();
		}
		
		if(isEmpty()) {
			return null;
		}
		
		E deleted = null;
		
		if(head.getElement().equals(toRemove)) {
			deleted = head.getElement();
			
			if(head == tail) {
				head = tail = null;
			}
			else {
				head.getNext().setPrev(null);
				head = head.getNext();
			}
		} else if(tail.getElement().equals(toRemove)) {
			deleted = tail.getElement();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			MyDLLNode<E> curr = head;
			
			for(int i = 0; i < size(); i++) {
				if(curr.getElement().equals(toRemove)) {
					deleted = curr.getElement();
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
					
					break;
				}
				curr = curr.getNext();
			}
		}
		
		if(deleted != null) {
			size--;
		}
		
		return deleted;
	}

	/**
	 * Replaces the element at the specified position in the list
	 * with the specified element
	 * 
	 * @param index
	 * @param toChange
	 * @return The element previously at the specified position.
	 * @throws NullPointerException if the specified element is null
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toChange == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> curr = head;
		
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		
		E preValue = curr.getElement();
		curr.setElement(toChange);
		
		return preValue;
	}

	/**
	 * Returns true if this list contains no elements
	 * 
	 * @return true if the list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return (head == null);
	}

	/**
	 * Returns true if this list contains the specified element
	 * 
	 * @param toFind
	 * @return true if this list contains the specified element
	 * @throws NullPointerException if the specified element is null
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean result = false;
		
		if(toFind == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> curr = head;
		
		for(int i = 0; i < size(); i++) {
			if(curr.getElement().equals(toFind)) {
				result = true;
			}
			curr = curr.getNext(); 
		}
		
		return result;
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence
	 * @param toHold
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException if the specified element is null
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null) {
			throw new NullPointerException();
		}
		
		if(toHold.length < size) {
			toHold = (E[]) Array.newInstance(head.getElement().getClass(), this.size);
		}
		
		MyDLLNode<E> curr = head;
		
		for (int i = 0; i < size(); i++) {
			toHold[i] = curr.getElement();
			curr = curr.getNext();
		}
		return toHold;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence
	 * 
	 * @return An array containing all of the elements in this list in proper sequence
	 */
	@Override
	public Object[] toArray() {
		Object[] newArray = new Object[size()];
		MyDLLNode<E> curr = head;
		
		for (int i = 0; i < size(); i++) {
			newArray[i] = curr.getElement();
			curr = curr.getNext();
		}
		return newArray;
	}
	
	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	/***********************************INNER CLASS*******************************************/
	private class LinkedListIterator implements Iterator<E> {

		private MyDLLNode<E> pos;
		
		public LinkedListIterator() {
			pos = null;
		}
		
		/**
		 * Returns true if the iteration has more elements
		 * (Returns true if next() would return an element 
		 * rather than throwing an exception)
		 * 
		 * @return true if the iterator has more elements
		 */
		@Override
		public boolean hasNext() {			
			if(pos == null) {
				return head != null;
			}
			else {
				return pos.getNext() != null;				
			}
			
		}
		
		/**
		 * Returns the next element in the iteration
		 * 
		 * @return The next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (!hasNext()) throw new NoSuchElementException();
			
			if(pos == null) {
				pos = head;
			}
			else {
				pos = pos.getNext();				
			}
			
	        E element = pos.getElement();
	        
	        return element;
		}
		
	}

}