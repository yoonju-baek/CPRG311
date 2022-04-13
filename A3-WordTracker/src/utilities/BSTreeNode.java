package utilities;

import java.io.Serializable;

/**
 * Represents a BSTreeNode.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 08 2022
 */
public class BSTreeNode<E> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private E element;
	private BSTreeNode<E> left, right;
	
	/**
	 * Initializes a BSTreeNode object.
	 */
	public BSTreeNode() {
		
	}
	
	/**
	 * Initializes a BSTreeNode object.
	 * 
	 * @param elem the element to be stored.
	 * @param left the link to the left child.
	 * @param right the link to the right child.
	 */
	public BSTreeNode(E elem, BSTreeNode<E> left, BSTreeNode<E> right) {
		this.element = elem;
		this.left = left;
		this.right = right;
	}

	/**
	 * Gets the element.
	 * 
	 * @return the element.
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Sets the element.
	 * 
	 * @param element the element to be stored.
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Gets the left child.
	 * 
	 * @return the left child.
	 */
	public BSTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * Sets the left child.
	 * 
	 * @param the link to the left child.
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * Gets the right child.
	 * 
	 * @return the right child.
	 */
	public BSTreeNode<E> getRight() {
		return right;
	}

	/**
	 * Sets the right child.
	 * 
	 * @param the link to the right child.
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}
	
	/**
	 * Returns the result whether the current node has a left child.
	 * 
	 * @return true if the current node has a left child. Otherwise, false.
	 */
	public boolean hasLeftChild() {
		return (getLeft() != null);
	}
	
	/**
	 * Returns the result whether the current node has a right child.
	 * 
	 * @return true if the current node has a right child. Otherwise, false.
	 */
	public boolean hasRightChild() {
		return (getRight() != null);
	}

	/**
	 * Returns the result whether the current node is a leaf.
	 * 
	 * @return true if the current node is leaf. Otherwise, false.
	 */
	public boolean isLeaf() {
		return (!hasLeftChild() && !hasRightChild());
	}
	
	public int getNumberNodes() {
		return (1 + ((hasLeftChild()) ? left.getNumberNodes() : 0)
			 + ((hasRightChild()) ? right.getNumberNodes() : 0));
	}
	
	public int getHeight() {
		int leftH = getHeight(left);
		int rightH = getHeight(right);
		
		if(leftH > rightH) {
			return leftH + 1;
		}
		else {
			return rightH + 1;
		}
	}
	
	
	private int getHeight(BSTreeNode<E> node) {
		if(node == null) {
			return 0;
		} else {
			int leftHeight = getHeight(node.getLeft());
			int rightHeight = getHeight(node.getRight());
			
			if(leftHeight > rightHeight) {
				return (leftHeight + 1);
			}
			else {
				return (rightHeight + 1);
			}
		}
	}

}
