package utilities;

import java.util.NoSuchElementException;
import exceptions.EmptyQueueException;

/**
 * @author mbibe
 * @param <E>
 *
 */
public class MyQueue<E> implements QueueADT<E> {

	private static final long serialVersionUID = 1L;

	//attributes
	private MyDLL<E> list;
		
	
	public MyQueue() {
		list = new MyDLL<>();
	}
		
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		list.add(toAdd);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if(list.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		E deleted = list.remove(0);
		
		return deleted;
	}

	@Override
	public E peek() throws EmptyQueueException {
		if(list.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		E value = list.get(0);
		
		return value;
	}

	@Override
	public void dequeueAll() {
		list.clear();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

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

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null) {
			throw new NullPointerException();
		}
		
		return list.toArray(holder);
	}

	@Override
	public boolean isFull() {
		// Optional. Our group developed a non fixed length queue
		return true;
	}

	@Override
	public int size() {
		return list.size();
	}
	
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
		
		@Override
		public boolean hasNext() {			
			return iterator.hasNext();
		}

		@Override
		public E next() throws NoSuchElementException {     
	        return iterator.next();
		}
	}

}
