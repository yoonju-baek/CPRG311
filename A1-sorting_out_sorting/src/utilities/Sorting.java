package utilities;

import java.util.Comparator;

public class Sorting {
	/**
	 * 
	 * @param <T>
	 * @param array
	 */
	@SuppressWarnings("unchecked")
	public static <T> void selectionSort(Comparable<T>[] array) {
		// distinguish the sorted area and the unsorted area
		for (int i = 0; i < (array.length - 1); i++) {
			int minIndex = i;

			// find minimum value in the unsorted values
			for (int j = 1; j < array.length; j++) {
				if (array[minIndex].compareTo((T) array[j]) == 1) {
					minIndex = j;
				}

			}
			// call method to swap minimum value with the first unsorted value
			swapElements(array, i, minIndex);				
		}

	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param comp
	 */
	@SuppressWarnings("unchecked")
	public static <T> void selectionSort(Comparable<T>[] array, Comparator<? super T> comp) {
		// distinguish the sorted area and the unsorted area
		for (int i = 0; i < (array.length - 1); i++) {
			int minIndex = i;

			// find minimum value in the unsorted values
			for (int j = 1; j < array.length; j++) {
				if (comp.compare((T) array[minIndex], (T) array[j]) == 1) {
					minIndex = j;
				}
			}
			// call method to swap minimum value with the first unsorted value
			swapElements(array, i, minIndex);	
		}

	}

	/**
	 * 
	 * @param <T>
	 * @param arrayPart1
	 */
	public static <T> void quickSort(Comparable<T>[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param startIndex
	 * @param endIndex
	 */
	@SuppressWarnings("unchecked")
	public static <T> void quickSort(Comparable<T>[] array, int startIndex, int endIndex) {
		int partStart = startIndex;
		int partEnd = endIndex;
		// select a value at the middle of the array as a pivot
		int pivot = (partStart + partEnd) / 2;

		// move both counters to the opposite side during meet the condition
		while (partStart < partEnd) {
			while (array[pivot].compareTo((T) array[partStart]) > 1) {
				partStart++;
			}
			while (array[pivot].compareTo((T) array[partEnd]) < 1) {
				partEnd++;
			}
			// call a method to swap the value of the left counter with the value of the right counter
			swapElements(array, partStart, partEnd);
		}

		// call method itself to sort the part of the left side of the array 
		if (startIndex < partStart -1) {
			quickSort(array, startIndex, partStart -1);
		}
		// call method itself to sort the part of the right side of the array
		if (endIndex > partStart) {
			quickSort(array, partStart, endIndex);
		}

	}

	/** 
	 * 
	 * @param <T>
	 * @param array
	 * @param comp
	 */
	public static <T> void quickSort(Comparable<T>[] array, Comparator<? super T> comp) {
		quickSort(array, comp, 0, array.length - 1);
	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param comp
	 * @param startIndex
	 * @param endIndex
	 */
	public static <T> void quickSort(Comparable<T>[] array, Comparator<? super T> comp,  int startIndex, int endIndex) {

	}

	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param i
	 * @param j
	 */
	private static <T> void swapElements(Comparable<T>[] array, int i, int j) {
		Comparable<T> temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
