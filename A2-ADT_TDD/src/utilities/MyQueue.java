package utilities;

import java.util.NoSuchElementException;
import exceptions.EmptyQueueException;

/**
 * Utility class for a queue
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * @param <E> The type of element this iterator returns
 */
public class MyQueue<E> implements QueueADT<E> {

	private static final long serialVersionUID = 1L;

	//attributes
	private MyDLL<E> list;
		
	
	public MyQueue() {
		list = new MyDLL<>();
	}
		
	/**
	 * Enqueue will place the added item at the last position in the queue
	 * 
	 * @param toAdd - the item to be added to the Queue
	 * @throws NullPointerException raised when a null object is placed in the Queue
	 */
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		list.add(toAdd);
	}
	
	/**
	 * Dequeue will remove the first item that was placed in the Queue
	 * @return the first item in the Queue
	 * @throws EmptyQueueException raised when the queue's length is zero
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		if(list.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		E deleted = list.remove(0);
		
		return deleted;
	}
	
	/**
	 * Peek provides a reference to the first item in the queue without removing from the queue
	 * 
	 * @return the first item in the queue
	 * @throws EmptyQueueException raised when the queue's length is zero
	 */
	@Override
	public E peek() throws EmptyQueueException {
		if(list.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		E value = list.get(0);
		
		return value;
	}
	
	/**
	 * dequeueAll removes all items in the queue
	 */
	@Override
	public void dequeueAll() {
		list.clear();
	}

	/**
	 * Returns <code>true</code> when the queue contains no items
	 * @return <code>true</code> when queue length is zero (0)
	 */
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Used to compare two Queue ADT's
	 * (To be equal two queues must contain equal items appearing in the same order)
	 * 
	 * @param that - the Queue ADT to be compared to this queue
	 * @return true if the queues are equal.
	 */
	@Override
	public boolean equals(QueueADT<E> that) {
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
	 * Returns an array containing all of the elements in this list in proper sequence
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
	 * @param holder - the array into which the elements of this queue are to be
	 *            	   stored, if it is big enough; otherwise, a new array of the
	 *            	   same runtime type is allocated for this purpose
	 * @return an array containing the elements of this queue
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
	 * Returns true if the number of items in the queue equals the length
	 * 
	 * @return true if queue is at capacity
	 */
	@Override
	public boolean isFull() {
		// Optional. Our group developed a non fixed length queue
		return true;
	}
	
	/**
	 * Returns the length of the current queue as an integer value
	 * @return the current size to the queue as an integer
	 */
	@Override
	public int size() {
		return list.size();
	}
	
	/**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	/***********************************INNER CLASS*******************************************/
	private class QueueIterator implements Iterator<E> {

		private Iterator<E> iterator;
		
		public QueueIterator() {
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
