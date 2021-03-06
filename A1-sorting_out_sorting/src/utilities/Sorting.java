package utilities;

import java.util.Comparator;

/**
 * This class is a collection of sorting algorithms.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class Sorting {
	
	/**
	 * The method is bubble sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j].compareTo((T) array[j + 1]) < 0) {
	            // swap
		        swapElements(array, j, j + 1);
	            }
    		}
	    }
	}
		
	/**
	 * The method is bubble sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 */
	public static <T> void bubbleSort(T[] array, Comparator<? super T> comp) {
		for (int i = 1; i < array.length; i++) {
	    	for (int j = 0; j < array.length - i; j++) {
	    		if (comp.compare(array[j], array[j + 1]) < 0) {
	            // swap
    			swapElements(array, j, j + 1);
	            }
    		}
	    }
	}
	
	/**
	 * The method is merge sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<T>> void mergeSort(T[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	/**
	 * The method is recursive merge sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param first the index of the first element of the array
	 * @param last the index of the last element of the array
	 */
	private static <T extends Comparable<T>> void mergeSort (T[] array, int first, int last) {
		if (last - first < 1) return;
		
		int middle = (first + last) / 2;
		
		mergeSort(array, first, middle);
		mergeSort(array, middle + 1, last);
		merge(array, first, middle, last);
	}
	
	/**
	 * The method is to merge all separated arrays.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param first the index of the first element of the array
	 * @param middle the index of the middle element of the array
	 * @param last the index of the last element of the array
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> void merge(T[] array, int first, int middle, int last) {
	
		Object[] temp = new Object[last - first + 1]; 
		
		int i = first;
		int j = middle + 1;
		int k = 0;
	
		while (i <= middle && j <= last) {
			if (array[i].compareTo(array[j])>=0)
				temp[k] = array[i++];
		    else
		    	temp[k] = array[j++];
		    k++;
		}
		if (i <= middle && j > last) {
			while (i <= middle) 
				temp[k++] = array[i++];
		} else {
		    while (j <= last)
		    	temp[k++] = array[j++];
		}
		for (k = 0; k < temp.length; k++) {
			array[k + first] = (T)(temp[k]);
		}
	}
	
	/**
	 * The method is merge sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 */
	public static <T> void mergeSort(T[] array, Comparator<? super T> comp) {
		mergeSort(array, comp, 0, array.length - 1);
	}
	
	/**
	 * The method is recursive merge sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 * @param first the index of the first element of the array
	 * @param last the index of the last element of the array
	 */
	private static <T> void mergeSort (T[] array, Comparator<? super T> comp, int first, int last) {
		if (last - first < 1) return;
		
		int middle = (first + last) / 2;
		
		mergeSort(array, comp, first, middle);
		mergeSort(array, comp, middle + 1, last);
		merge(array, comp, first, middle, last);
	}
	
	/**
	 * The method is to merge all separated arrays.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 * @param first the index of the first element of the array
	 * @param middle the index of the middle element of the array
	 * @param last the index of the last element of the array
	 */
	@SuppressWarnings("unchecked")
	private static <T> void merge(T[] array, Comparator<? super T> comp, int first, int middle, int last) {
	
		Object[] temp = new Object[last - first + 1]; 
		
		int i = first;
		int j = middle + 1;
		int k = 0;
	
		while (i <= middle && j <= last) {
			if (comp.compare(array[i],array[j])>=0)
				temp[k] = array[i++];
		    else
		    	temp[k] = array[j++];
		    k++;
		}
		if (i <= middle && j > last) {
			while (i <= middle) 
				temp[k++] = array[i++];
		} else {
		    while (j <= last)
		    	temp[k++] = array[j++];
		}
		for (k = 0; k < temp.length; k++) {
			array[k + first] = (T)(temp[k]);
		}
	}
	
	/**
	 * The method is selection sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] array) {
		// distinguish the sorted area and the unsorted area
		for (int i = 0; i < (array.length - 1); i++) {
			int maxIndex = i;

			// find minimum value in the unsorted values
			for (int j = i+1; j < array.length; j++) {
				if (array[maxIndex].compareTo((T) array[j]) == -1) {
					maxIndex = j;
				}

			}
			// call method to swap minimum value with the first unsorted value
			swapElements(array, i, maxIndex);				
		}
	}

	/**
	 * The method is selection sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 */
	public static <T> void selectionSort(T[] array, Comparator<? super T> comp) {
		// distinguish the sorted area and the unsorted area
		for (int i = 0; i < (array.length - 1); i++) {
			int maxIndex = i;

			// find minimum value in the unsorted values
			for (int j = i+1; j < array.length; j++) {
				if (comp.compare((T) array[maxIndex], (T) array[j]) == -1) {
					maxIndex = j;
				}
			}
			// call method to swap minimum value with the first unsorted value
			swapElements(array, i, maxIndex);	
		}

	}

	/**
	 * The method is quick sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * The method is recursive quick sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param startIndex starting index of the array to be sorted
	 * @param endIndex ending index of the array to be sorted
	 */
	private static <T extends Comparable<? super T>> void quickSort(T[] array, int startIndex, int endIndex) {
		// find an index after sorting array by splitting two parts of arrays
		// the left side consists of items that are greater than pivot value
		// the right side consists of items that are less than pivot value
		int splitIndex = partition(array, startIndex, endIndex);
		
		// call method itself to sort the part of the left side of the array 
		if (startIndex < (splitIndex - 1)) {
			quickSort(array, startIndex, (splitIndex - 1));	
		}
		// call method itself to sort the part of the right side of the array
		if (endIndex > splitIndex) {
			quickSort(array, splitIndex, endIndex);	
		}

	}
	
	/**
	 * 
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param partStart starting index of the array to be sorted
	 * @param partEnd ending index of the array to be sorted
	 * @return the final sorted position of the pivot
	 */
	private static <T extends Comparable<? super T>> int partition(T[] array, int partStart, int partEnd) {
		// choose an index at the middle of the array as a pivot
		int pivot = (partStart + partEnd) / 2;

		// shift both counters to the opposite side during meet the condition
		while (partStart <= partEnd) {
			while (array[pivot].compareTo((T) array[partStart]) < 0) {
				partStart++;
			}
			while (array[pivot].compareTo((T) array[partEnd]) > 0) {
				partEnd--;
			}
			// call a method to swap the value of the left counter with the value of the right counter
			if (partStart <= partEnd) {
				swapElements(array, partStart, partEnd);	
				// change pivot to the index corresponding to initial pivot value after swapping
				if (partStart == pivot) {
					pivot = partEnd;
				} else if (partEnd == pivot) {
					pivot = partStart;
				}
				
				partStart++;
				partEnd--;
			}
		}
		return partStart;
	}

	/** 
	 * The method is quick sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 */
	public static <T> void quickSort(T[] array, Comparator<? super T> comp) {
		quickSort(array, comp, 0, array.length - 1);
	}

	/**
	 * The method is recursive quick sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted 
	 * @param comp the comparator to determine the order of the array
	 * @param startIndex starting index of the array to be sorted
	 * @param endIndex ending index of the array to be sorted
	 */
	private static <T> void quickSort(T[] array, Comparator<? super T> comp,  int startIndex, int endIndex) {
		// find an index after sorting array by splitting two parts of arrays
		// the left side consists of items that are greater than pivot value
		// the right side consists of items that are less than pivot value
		int splitIndex = partition(array, comp, startIndex, endIndex);
		
		// call method itself to sort the part of the left side of the array 
		if (startIndex < (splitIndex - 1)) {
			quickSort(array, comp, startIndex, (splitIndex - 1));	
		}
		// call method itself to sort the part of the right side of the array
		if (endIndex > splitIndex) {
			quickSort(array, comp, splitIndex, endIndex);	
		}

	}
	
	/**
	 * 
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 * @param partStart starting index of the array to be sorted
	 * @param partEnd ending index of the array to be sorted
	 * @return the final sorted position of the pivot
	 */
	private static <T> int partition(T[] array, Comparator<? super T> comp, int partStart, int partEnd) {		
		// choose an index at the middle of the array as a pivot
		int pivot = (partStart + partEnd) / 2;

		// shift both counters to the opposite side during meet the condition
		while (partStart <= partEnd) {
			while (comp.compare((T) array[pivot], (T) array[partStart]) < 0) {
				partStart++;
			}
			while (comp.compare((T) array[pivot], (T) array[partEnd]) > 0) {
				partEnd--;
			}
			// call a method to swap the value of the left counter with the value of the right counter
			if (partStart <= partEnd) {
				swapElements(array, partStart, partEnd);	
				// change pivot to the index corresponding to initial pivot value after swapping
				if (partStart == pivot) {
					pivot = partEnd;
				} else if (partEnd == pivot) {
					pivot = partStart;
				}
				
				partStart++;
				partEnd--;
			}
		}
		return partStart;
	}


	/**
	 * The method is insertion sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void insertionSort(T[] array) {
		for(int i=1; i < array.length; i++) {
			T key = array[i];
			int j = i-1;
			
			while(j >= 0 && array[j].compareTo(key) < 0 ) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}
	
	/**
	 * The method is insertion sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 */
	public static <T> void insertionSort(T[] array, Comparator<? super T> comp) {
		for(int i=1; i < array.length; i++) {
			T key = array[i];
			int j = i-1;
			
			while(j >= 0 && comp.compare(array[j], key) < 0 ) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}
	
	/**
	 * The method is shell sort in descending order.
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 */
	public static <T extends Comparable<? super T>> void shellSort(T[] array) {
		int numbers = array.length;
		
		for(int gap=numbers/2; gap>0; gap=gap/2) {
			for(int i=gap; i<numbers; i++) {
				T insertVal = array[i];
				
				int j;
				for(j=i-gap; j>=0 && array[j].compareTo(insertVal) < 0; j=j-gap) {
					array[j+gap] = array[j];
				}
				
				array[j+gap] = insertVal;
			}
		}
	}
	
	/**
	 * The method is shell sort in descending order. 
	 * @param <T> the class of the objects in the array
	 * @param array the array to be sorted
	 * @param comp the comparator to determine the order of the array
	 */
	public static <T> void shellSort(T[] array, Comparator<? super T> comp) {
		int numbers = array.length;
		
		for(int gap=numbers/2; gap>0; gap=gap/2) {
			for(int i=gap; i<numbers; i++) {
				T insertVal = array[i];
				
				int j;
				for(j=i-gap; j>=0 && comp.compare(array[j], insertVal) < 0; j=j-gap) {
					array[j+gap] = array[j];
				}
				
				array[j+gap] = insertVal;
			}
		}
	}
	
	/**
	 * The method is to swap two elements
	 * @param <T> the class of the objects in the array
	 * @param array the array to be swapped
	 * @param i the index of the element to be swapped
	 * @param j the index of the other element to be swapped
	 */
	private static <T> void swapElements(T[] array, int i, int j )
	{
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
