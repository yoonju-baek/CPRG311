package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

/**
 * @author mbibe
 *
 */
public class MyArrayList<E> implements ListADT<E> {

	private static final long serialVersionUID = 1L;
	
	//attributes
	private E[] array;
	private int size;
	
	//Constructor
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[10];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toAdd == null) {
			throw new NullPointerException();
		}
		
		// check for capacity
		if(size == array.length) {
			//TODO create a new array(bigger than the original) x2 of original array
			// use a loop to copy everything from the original array into the new array
			//get array to reference the new array
		}
		
		// TODO insert toAdd into index position (requires a loop to shift everything from index forward)
		
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if(toAdd == null) {
			throw new NullPointerException();
		}
		// check for capacity
		if(size == array.length) {
			//TODO create a new array(bigger than the original) x2 of original array
			// use a loop to copy everything from the original array into the new array
			//get array to reference the new array
		}
		
		array[size] = toAdd;
		size++;
		
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// before adding, check if there are space in the array.
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold.length < size) {
			toHold = (E[]) Array.newInstance(array[0].getClass(), this.size);
		}
		
		System.arraycopy(array, 0, toHold, 0, size);
		return toHold;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray() {
		//Object[] toHold = (E[]) Array.newInstance(array[0].getClass(), this.size);
		Object[] toHold = (E[]) new Object[this.size];
		
		System.arraycopy(array, 0, toHold, 0, size);
		return toHold;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayBasedIterator();
	}
	
	/***********************************INNER CLASS*******************************************/
	private class ArrayBasedIterator implements Iterator<E> {

		private int pos;
		private E[] copy;
		
		public ArrayBasedIterator() {
			copy = (E[]) new Object[size];
			System.arraycopy(array, 0, copy, 0, size);
		}
		
		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if(pos >= size) {
				throw new NoSuchElementException();
			}
			
			E toReturn = copy[pos++]; 
			return toReturn;
		}
		
	}

}
