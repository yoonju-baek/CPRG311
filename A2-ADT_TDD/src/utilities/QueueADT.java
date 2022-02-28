package utilities;

/**
 * <p>
 * The <code>QueueADT</code> interface is designed to be used as a linear 
 * first-in-first-out(FIFO) data structure that will be developed in the CPRG311 
 * class at SAIT. The implementors of this interface will be required to add all 
 * the functionality.
 * </p>
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 28 2022
 *
 * @param <E> The type of elements this queue holds.
 */
public interface QueueADT<E> {
	
	/**
	 *  Adds the specified element at the end of the queue.
	 *  
	 * Precondition: A valid element exists.
	 * 
	 * Postcondition: A valid element is added at the end of the queue.
	 * 
	 * @param toAdd The element to be pushed.
	 * @return <code>true</code> if the element is added at the end of the queue successfully;
	 			<code>false</code> otherwise.
	 * @throws NullPointerException if the specified element is <code>null</code>
	 * 			and the queue implementation does not support having 
	 * 			<code>null</code> elements.
	 */
	public boolean enqueue(E toAdd) throws NullPointerException;
	
	/**
	 * Removes and returns the first element from the queue.
	 * 
	 * Precondition: The queue isn't empty.
	 * 
	 * Postcondition: if the queue isn't empty, the first element from the queue
	 * 					is removed and returned.
	 * 
	 * @return the first element from the queue.
	 *+==========> exception??? about empty??
	 */
	public E dequeue();
	
	/**
	 * Looks at the first element from the queue.
	 * 
	 * Precondition: The queue isn't empty.
	 * 
	 * Postcondition: if the queue isn't empty, the first element from the queue
	 * 					is returned without removing.
	 * 
	 * @return the first element from the queue.
	 * +==========> exception??? about empty??
	 */
	public E peek();
	
	/**
	 * The size method will return the number of elements contained
	 * in the queue.
	 * 
	 * Precondition: The queue object exists.
	 * 
	 * Postcondition: The number of elements is returned.
	 * 
	 * @return The number of elements.
	 */
	public int size();
	
	/**
	 * Checks if the queue is empty.
	 * 
	 * Precondition: The queue object exists.
	 * 
	 * Postcondition: returns true if this queue is empty; false otherwise.
	 * 
	 * @return <code>true</code> if this queue contains no elements, <code>false</code> otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Checks if this queue and that queue contain equal elements in the same order.
	 * 
	 * Precondition: <code>that</code> queue object is exists.
	 * 
	 * Postcondition: returns <code>true</code> if this queue and that queue contain equal elements in the same order;
	 * 					<code>false</code> otherwise.
	 * 
	 * @param that the queue object to be compared.
	 * @return <code>true</code> if this queue and that queue contain equal elements in the same order;
	 			<code>false</code> otherwise.
	 * @throws NullPointerException if the <code>that</code> queue object is <code>null</code>
	 * 			and the queue implementation does not support comparing 
	 * 			two objects.
	 */
	public boolean equals(QueueADT<E> that) throws NullPointerException;
		
	/**
	 * Removes all of the elements from the queue.
	 * 
	 * Precondition: The queue object exists.
	 * 
	 * Postcondition: The queue is empty.
	 */
	public void dequeueAll();
	
	/**
	 * Copy the elements in the queue to another array that has already been created.
	 * if the size of queue > length of <code>copy</code> array, a new array of the	same runtime type 
	 * is allocated for this purpose.
	 * if the size of queue < length of <code>copy</code> array, copy all of the elements in the queue to the array
	 * and the remaining elements in the array remain initialized.
	 * The head of the queue corresponds to the first element of the array.
	 * 
	 * Precondition: A valid array object exists.
	 * 
	 * Postcondition: the elements in the queue is copied to another array that has already been created 
	 * in proper sequence and the array is returned.
	 * 
	 * @param copy the array to be stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of the queue.
	 * @throws NullPointerException If the specified array is <code>null</code>.
	 */
	public E[] toArray(E[] copy) throws NullPointerException;
	
	/**
	 * All of the elements in the queue is transformed to an array in proper sequence 
	 * and returns an array containing all of the elements in the queue.
	 * The size of the array is assigned exactly as many elements in the queue.
	 * The head of the queue corresponds to the first element of the array.
	 * 
	 * Precondition: The queue object exists.
	 * 
	 * Postcondition: All of the elements in the queue is transformed to an array in proper sequence and Returned it.
	 * 
	 * @return An array containing all of the elements in the queue in proper sequence.
	 */
	public Object[] toArray();

	/**
	 * Returns an iterator over the elements in the queue.
	 * 
	 * Precondition: A valid queue object exists.
	 * 
	 * Postcondition: An iterator over the elements in the queue is returned.
	 * 
	 * @return An iterator over the elements in the queue.
	 */
	public Iterator<E> iterator();
}
