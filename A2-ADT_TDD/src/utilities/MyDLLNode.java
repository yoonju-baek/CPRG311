package utilities;

import java.io.Serializable;

/**
 * A generic doubly linked list 
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Mar 28 2022
 * @param <E> The type of element this iterator returns
 */
public class MyDLLNode<E> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private E element;
	private MyDLLNode<E> prev, next;
	
	public MyDLLNode() {
		
	}
	
	public MyDLLNode(E element) {
		this.element = element;
	}
	
	public MyDLLNode(E element, MyDLLNode<E> prev, MyDLLNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
    /**
     * Returns the stored element at this position
     *
     * @return the stored element
     */
	public E getElement() {
		return element;
	}

    // Setter methods
	public void setElement(E element) {
		this.element = element;
	}

	public MyDLLNode<E> getPrev() {
		return prev;
	}

	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	public MyDLLNode<E> getNext() {
		return next;
	}

	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}
	
}
