package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	/**
	 * 
	 */
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
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		head = tail = null;
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

	@Override
	public boolean isEmpty() {
		return (head == null);
	}

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
		
		@Override
		public boolean hasNext() {			
			if(pos == null) {
				return head != null;
			}
			else {
				return pos.getNext() != null;				
			}
			
		}

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