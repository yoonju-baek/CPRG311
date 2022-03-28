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
		for(int i=0; i < size; i++) {
			array[i] = null;
		}
		
		size = 0;
	}

	@SuppressWarnings("unchecked")
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
			E[] newArray = (E[]) new Object[array.length * 2];
			// use a loop to copy everything from the original array into the new array
			for (int i=0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			//get array to reference the new array
			array = newArray;
		}
		
		// TODO insert toAdd into index position (requires a loop to shift everything from index forward)
		for(int j=size-1; j >= index; j--) {
			array[j+1] = array[j];
		}
		
		array[index] = toAdd;
		size++;
		
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
			E[] newArray = (E[]) new Object[array.length * 2];
			// use a loop to copy everything from the original array into the new array
			for (int i=0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			//get array to reference the new array
			array = newArray;
		}
		
		array[size] = toAdd;
		size++;
		
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null ) {
			throw new NullPointerException();
		}
		
		// before adding, check if there are space in the array.
		// check for capacity
		if(size == array.length) {
			E[] newArray = (E[]) new Object[array.length + toAdd.size()];
			// use a loop to copy everything from the original array into the new array
			for (int i=0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			//get array to reference the new array
			array = newArray;
		}
		
		int j=0;
		for(int i=size; i < size+toAdd.size(); i++) {
			array[i] = toAdd.get(j++);
		}
		
		size = size + toAdd.size();
		
		return true;
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
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		E deleted = array[index];
		for(int i=index; i < size; i++) {
			array[i] = array[i+1];
		}
		
		size--;
		
		return deleted;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null) {
			throw new NullPointerException();
		}
		
		E deleted = null;
		int index;
		for(index=0; index < size; index++) {
			if(array[index].equals(toRemove)) {
				deleted = array[index];
				
				for(int i=index; i < size; i++) {
					array[i] = array[i+1];
				}
				
				size--;
				break;
			}
		}
		
		return deleted;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if(toChange == null) {
			throw new NullPointerException();
		}
		
		E changed = array[index];
		
		array[index] = toChange;
		
		return changed;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null) {
			throw new NullPointerException();
		}
		
		for(int i=0; i < size; i++) {
			if(array[i].equals(toFind)) {
				return true;
			}
		}
		
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
