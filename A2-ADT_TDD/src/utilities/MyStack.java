package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * @author mbibe
 *
 */
public class MyStack<E> implements StackADT<E> {

	private static final long serialVersionUID = 1L;
	
	private MyArrayList<E> list;
	
	public MyStack() {
		list = new MyArrayList<>();
	}

	@Override
	public void push(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		list.add(0, toAdd);
	}

	@Override
	public E pop() throws EmptyStackException {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return list.remove(0);
	}

	@Override
	public E peek() throws EmptyStackException {
		if(list.isEmpty()) {
			throw new EmptyStackException();
		}
		
		return list.get(0);
	}

	@Override
	public void clear() {
		list.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
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
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) {
			throw new NullPointerException();
		}
		
		return list.contains(toFind);
	}

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

	@Override
	public int size() {
		return list.size();
	}

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
