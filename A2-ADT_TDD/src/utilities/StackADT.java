package utilities;

import java.util.EmptyStackException;

/**
 * <p>
 * The <code>StackADT</code> interface is designed to be used as a linear 
 * last-in-first-out(LIFO) data structure that will be developed in the CPRG311 
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
 * @param <E> The type of elements this stack holds.
 */
public interface StackADT<E> {
	
	/**
	 * Adds the specified element to the top of a stack.
	 * 
	 * Precondition: A valid stack exists and a valid element(toPush) is provided.
	 * 
	 * Postcondition: A valid element is pushed onto the top of a stack.
	 * 
	 * @param toPush The element to be pushed.
	 * @return <code>true</code> if the element is pushed successfully;
	 			<code>false</code> otherwise.
	 * @throws NullPointerException if the specified element is <code>null</code>
	 * 			and the stack implementation does not support having 
	 * 			<code>null</code> elements.
	 */
	public boolean push(E toPush) throws NullPointerException;
	
	/**
	 * Removes and returns the element from the top of a stack.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: if the stack isn't empty, the element from the top of stack
	 * 					is removed and returned.
	 * 
	 * @return the element at the top of the stack.
	 * @throws EmptyStackException If the stack has no more elements.
	 */
	public E pop() throws EmptyStackException;
	
	/**
	 * Looks at the element of the top of a stack.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: if the stack isn't empty, the element from the top of stack
	 * 					is returned without removing.
	 * 
	 * @return the element at the top of the stack.
	 * @throws EmptyStackException If the stack has no more elements.
	 */
	public E peek() throws EmptyStackException;
	
	/**
	 * The size method will return the number of elements contained
	 * in the stack.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: The number of elements is returned.
	 * 
	 * @return The number of elements.
	 */
	public int size();
	
	/**
	 * Checks if the stack is empty.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: returns true if this stack is empty; false otherwise.
	 * 
	 * @return <code>true</code> if this stack contains no elements, <code>false</code> otherwise.
	 */
	public boolean isEmpty();
	
	/**
	 * Removes all of the elements from the stack.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: The stack is empty.
	 */
	public void clear();
	
	/**
	 * Checks if this stack and that stack contain equal elements in the same order.
	 * 
	 * Precondition: The valid stack exists and <code>that</code> stack is provided.
	 * 
	 * Postcondition: returns <code>true</code> if this stack and that stack contain equal elements in the same order;
	 * 					<code>false</code> otherwise.
	 * 
	 * @param that the stack object to be compared.
	 * @return <code>true</code> if this stack and that stack contain equal elements in the same order;
	 			<code>false</code> otherwise.
	 * @throws NullPointerException if the <code>that</code> stack object is <code>null</code>.
	 * 			
	 */
	public boolean equals(StackADT<E> that) throws NullPointerException;
	
	/**
	 * Retrieves the position of the specified element if this element is contained in the stack.
	 * the top is at position 1, the next one is position2, etc.
	 * there are not a zero-based position.
	 * 
	 * Precondition: The valid stack exists and a valid element(obj) is provided.
	 * 
	 * Postcondition: returns the position of the specified element.
	 * 
	 * @param obj The element whose presence in the stack.
	 * @return The position of the specified element.
	 * @throws NullPointerException if the specified element is <code>null</code>.
	 */
	public int search(E obj) throws NullPointerException;
	
	/**
	 * Checks if the specified element is contained in the stack.
	 * the top is at position 1, the next one is position2, etc.
	 * there are not a zero-based position.
	 * 
	 * Precondition: The valid stack exists and a valid element(obj) is provided.
	 * 
	 * Postcondition: returns <code>true</code> if this element exists in the stack;
	 * 					<code>false</code> otherwise.
	 * 
	 * @param obj The element whose presence in the stack.
	 * @return <code>true</code> if this element exists in the stack;
	 * 			<code>false</code> otherwise.
	 * @throws NullPointerException if the specified element is <code>null</code>.
	 */
	public boolean contains(E obj) throws NullPointerException;
	
	/**
	 * Copy the elements in the stack to another array that has already been created.
	 * if the size of stack > length of <code>copy</code> array, a new array of the	same runtime type 
	 * is allocated for this purpose
	 * if the size of stack < length of <code>copy</code> array, copy all of the elements in the stack to the array
	 * and the remaining elements in the array remain initialized.
	 * The top of the stack corresponds to the first element of the array.
	 * 
	 * Precondition: The valid stack exists and a valid array(copy) is provided.
	 * 
	 * Postcondition: the elements in the stack is copied to another array that has already been created 
	 * 					in proper sequence(top-down order) and the array is returned. The array to be stored if it is big enough; 
	 * 					otherwise, a new array of the same runtime type is allocated for this purpose.
	 * 
	 * @param copy the array to be stored.
	 * @return An array containing the elements of the stack.
	 * @throws NullPointerException If the specified array is <code>null</code>.
	 */
	public E[] toArray(E[] copy) throws NullPointerException;
	
	/**
	 * All of the elements in the stack is transformed to an array in proper sequence(top-down order) 
	 * and returns an array containing all of the elements in the stack.
	 * The size of the array is assigned exactly as many elements in the stack.
	 * The top of the stack corresponds to the first element of the array.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: All of the elements in the stack is transformed to an array in proper sequence(top-down order) and returned it.
	 * 
	 * @return An array containing all of the elements in the stack in proper sequence(top-down order).
	 */
	public Object[] toArray();
	
	/**
	 * Returns an iterator over the elements in the stack.
	 * 
	 * Precondition: The valid stack exists.
	 * 
	 * Postcondition: An iterator over the elements in the stack is returned in proper sequence(top-down order).
	 * 
	 * @return An iterator over the elements in the stack.
	 */
	public Iterator<E> iterator();
}
