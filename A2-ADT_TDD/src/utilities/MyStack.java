package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Utility class for a stack
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * @param <E> The type of element this iterator returns
 */
public class MyStack<E> implements StackADT<E> {

	private static final long serialVersionUID = 1L;
	
	private MyArrayList<E> list;
	
	public MyStack() {
		list = new MyArrayList<>();
	}
	
	/**
	 * Pushes an item onto the top of this stack
	 * 
	 * @param toAdd - item to be pushed onto the top of the stack
	 * @throws NullPointerException when attempting to add a null element to the stack
	 */
	@Override
	public void push(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		list.add(0, toAdd);
	}
	
	/**
	 * Removes the object at the top of this stack and returns that object
	 * as the value of this function
	 * 
	 * @return the item popped off the top of the stack
	 * @throws EmptyStackException if there are not items in the stack
	 */
	@Override
	public E pop() throws EmptyStackException {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return list.remove(0);
	}
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack
	 * 
	 * @return the object at the top of this stack.
	 * @throws EmptyStackException
	 */
	@Override
	public E peek() throws EmptyStackException {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return list.get(0);
	}
	
	/**
	 * Clears all the items from this Stack
	 */
	@Override
	public void clear() {
		list.clear();
	}
	
	/**
	 * Returns true if this Stack contains no items
	 * 
	 * @return true if this Stack contains no items
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence
	 * Obeys the general contract of the Collection.toArray method
	 * 
	 * @return an array containing all of the elements in this list in proper sequence
	 */
	@Override
	public Object[] toArray() {
		return list.toArray();
	}
	
	/**
	 * Returns an array containing all of the elements in this list in proper sequence;
	 * the runtime type of the returned array is that of the specified array
	 * 
	 * @param holder - the array into which the elements of this stack are to be stored, 
	 * 				   if it is big enough; otherwise, a new array of the same
	 * 				   runtime type is allocated for this purpose.
	 * @return an array containing the elements of this stack
	 * @throws NullPointerException if the specified array is null
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) {
			throw new NullPointerException();
		}
		
		return list.toArray(holder);
	}
	
	/**
	 * Returns true if this list contains the specified element
	 * 
	 * @param toFind - element whose presence in this list is to be tested
	 * @return true if this list contains the specified element
	 * @throws NullPointerException if the specified element is null and
	 * 		   this list does not support null elements
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) {
			throw new NullPointerException();
		}
		
		return list.contains(toFind);
	}
	
	/**
	 * Returns the 1-based position where an object is on this stack
	 * 
	 * @param toFind - the desired object
	 * @return the 1-based position from the top of the stack where the object
	 *         is located; the return value -1 indicates that the object is not
	 *         on the stack
	 */
	@Override
	public int search(E toFind) {
		int pos = -1;
		
		for(int i=0; i < list.size(); i++) {
			if(list.get(i).equals(toFind)) {
				pos = i+1;
				break;
			}
		}
		
		return pos;
	}
	
	/**
	 * Used to compare two Stack ADT's
	 * To be equal two stacks must contain equal items appearing in the same order
	 * 
	 * @param that - the Stack ADT to be compared to this stack
	 * @return true if the stacks are equal
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		if(list.size() != that.size()) {
			return false;
		}
		
		Iterator<E> thisiterator = this.iterator();
		Iterator<E> thatiterator = that.iterator();
		
		while(thisiterator.hasNext()) {
			E thisE = thisiterator.next();
			E thatE = thatiterator.next();
			
			if(!thisE.equals(thatE)) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Returns the depth of the current stack as an integer value
	 * @return the current size to the stack as an integer
	 */
	@Override
	public int size() {
		return list.size();
	}

	/**
	 * Returns an iterator over the elements in this stack in proper sequence
	 * 
	 * @return an iterator over the elements in this stack in proper sequence
	 */
	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}
	
	/***********************************INNER CLASS*******************************************/
	private class StackIterator implements Iterator<E> {

		private Iterator<E> iterator;
		
		public StackIterator() {
			iterator = list.iterator();
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
			return iterator.hasNext();
		}

		/**
		 * Returns the next element in the iteration
		 * 
		 * @return The next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public E next() throws NoSuchElementException {     
	        return iterator.next();
		}
	}

	
}
