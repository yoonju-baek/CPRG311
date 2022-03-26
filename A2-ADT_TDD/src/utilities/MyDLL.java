package utilities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyDLL<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MyDLLNode<E> head, tail;
	private MyDLLNode<E> curr = head;
	
	public MyDLL() {
		this.head = this.tail = null;
	}

	public MyDLL(MyDLLNode<E> head, MyDLLNode<E> tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public int size() {
		int length = 0;
		
		while (hasNext()) {
			length++;
		}
		
		return length;
	}

	public void clear() {
		head = tail = null;
	}

	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		MyDLLNode newNode = new MyDLLNode(toAdd);
		
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		
		curr.getPrev().setNext(newNode);
		newNode.setPrev(curr.getPrev());
		curr.setPrev(newNode);
		newNode.setNext(curr);
		
		return true;
	}

	public boolean add(E toAdd) throws NullPointerException {
		MyDLLNode newNode = new MyDLLNode(toAdd);
		
		if(!isEmpty()) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		} else {
			head = tail = newNode;
		}
		
		return true;
	}

	public boolean addAll(ListADT<? extends E>  toAdd) throws NullPointerException {
		MyDLLNode newNode;
		
		if(!isEmpty()) {
			for(int i = 0; i < toAdd.size(); i++) {
				newNode = new MyDLLNode(toAdd.get(i));
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
			}
		} else {
			newNode = new MyDLLNode(toAdd.get(0));
			head = tail = newNode;
			for(int i = 1; i < toAdd.size(); i++) {
				newNode = new MyDLLNode(toAdd.get(i));
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail = newNode;
			}
		}
		return true;
	}

	public E get(int index) throws IndexOutOfBoundsException {
		for(int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr.getElement();
	}

	public boolean remove(int index) throws IndexOutOfBoundsException {
		if(head == tail) {
			head = tail = null;
		} else if(index == 0) {
			head.getNext().setPrev(null);
			head = head.getNext();
		} else if(index == size() - 1) {
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			for(int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
		}
		return true;
	}

	public boolean remove(E toRemove) throws NullPointerException {
		if(head == tail) {
			head = tail = null;
		} else if(head.getElement().equals(toRemove)) {
			head.getNext().setPrev(null);
			head = head.getNext();
		} else if(tail.getElement().equals(toRemove)) {
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			for(int i = 0; i < size(); i++) {
				if(curr.getNext().getElement().equals(toRemove)) {
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
				}
				curr = curr.getNext();
			}
		}
		return true;
	}

	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		MyDLLNode newNode = new MyDLLNode(toChange);
		
		if(index == 0) {
			head = newNode;
		} else {
			for(int i = 0; i < index; i++) {
				if(curr.getNext() == null) {
					tail = newNode;
				} 
				curr = curr.getNext();
			}	
			
			MyDLLNode temp = curr.getNext();
			curr.setNext(newNode.getNext());
			newNode.setNext(temp);
		}

		
		return curr.getElement();
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public boolean contains(Object toFind) throws NullPointerException {
		boolean result = false;
		
		for(int i = 0; i < size(); i++) {
			if(curr.getElement().equals(toFind)) {
				result = true;
			}
			curr = curr.getNext(); 
		}
		
		return result;
	}

	public E[] toArray(E[] toHold) throws NullPointerException {
		int i = 0;
		if(size() < toHold.length) {
			E[] arrayList = (E[]) new ArrayList[size()];
			while (hasNext()) {
				arrayList[i] = curr.getElement();
				curr = curr.getNext();
				i++;
			}
			return arrayList;
		} else {
			while (hasNext()) {
				toHold[i] = curr.getElement();
				curr = curr.getNext();
				i++;
			}
			return toHold;
		}

	}

	public Object[] toArray() {
		Object[] newArray = new Object[size()];
		
		for (int i = 0; i < size(); i++) {
			newArray[i] = curr.getElement();
		}
		return newArray;
	}

	public boolean hasNext() {
		return curr != null;
	}

	public E next() throws NoSuchElementException {
		if (!hasNext()) throw new NoSuchElementException("No next element.");
        E element = curr.getElement();
        curr = curr.getNext();
        return element;
	}

}
