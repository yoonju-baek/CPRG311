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
	 * 
	 * @param <T>
	 * @param array
	 * @param comp
	 */
	@SuppressWarnings("unchecked")
	public static <T> void selectionSort(Comparable<T>[] array, Comparator<? super T> comp) {
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
	private static <T> void quickSort(Comparable<T>[] array, int startIndex, int endIndex) {
		int partStart = startIndex;
		int partEnd = endIndex;
		// select a value at the middle of the array as a pivot
		int pivot = (partStart + partEnd) / 2;

		// move both counters to the opposite side during meet the condition
		while (partStart < partEnd) {
			while (array[pivot].compareTo((T) array[partStart]) <= 0) {
				partStart++;
			}
			while (array[pivot].compareTo((T) array[partEnd]) >= 0) {
				partEnd++;
			}
			// call a method to swap the value of the left counter with the value of the right counter
			swapElements(array, partStart, partEnd);
		}

		// call method itself to sort the part of the left side of the array 
		if (startIndex < (partStart -1)) {
			quickSort(array, startIndex, (partStart -1));
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
	@SuppressWarnings("unchecked")
	private static <T> void quickSort(Comparable<T>[] array, Comparator<? super T> comp,  int startIndex, int endIndex) {
		int partStart = startIndex;
		int partEnd = endIndex;
		// select a value at the middle of the array as a pivot
		int pivot = (partStart + partEnd) / 2;

		// move both counters to the opposite side during meet the condition
		while (partStart < partEnd) {
			while (comp.compare((T) array[pivot], (T) array[partStart]) <= 0) {
				partStart++;
			}
			while (comp.compare((T) array[pivot], (T) array[partEnd]) >= 0) {
				partEnd++;
			}
			// call a method to swap the value of the left counter with the value of the right counter
			swapElements(array, partStart, partEnd);
		}

		// call method itself to sort the part of the left side of the array 
		if (startIndex < (partStart -1)) {
			quickSort(array, comp, startIndex, (partStart -1));
		}
		// call method itself to sort the part of the right side of the array
		if (endIndex > partStart) {
			quickSort(array, comp, partStart, endIndex);
		}
	}


	public static <T extends Comparable<? super T>> void insertionSort(T[] arr) {
		for(int i=1; i < arr.length; i++) {
			T key = arr[i];
			int j = i-1;
			
			while(j >= 0 && arr[j].compareTo(key) < 0 ) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public static <T> void insertionSort(T[] arr, Comparator<? super T> comp) {
		for(int i=1; i < arr.length; i++) {
			T key = arr[i];
			int j = i-1;
			
			while(j >= 0 && comp.compare(arr[j], key) < 0 ) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	
	public static <T extends Comparable<? super T>> void shellSort(T[] arr) {
		int numbers = arr.length;
		
		for(int gap=numbers/2; gap>0; gap=gap/2) {
			for(int i=gap; i<numbers; i++) {
				T insertVal = arr[i];
				
				int j;
				for(j=i-gap; j>=0 && arr[j].compareTo(insertVal) < 0; j=j-gap) {
					arr[j+gap] = arr[j];
				}
				
				arr[j+gap] = insertVal;
			}
		}
	}
	
	public static <T> void shellSort(T[] arr, Comparator<? super T> comp) {
		int numbers = arr.length;
		
		for(int gap=numbers/2; gap>0; gap=gap/2) {
			for(int i=gap; i<numbers; i++) {
				T insertVal = arr[i];
				
				int j;
				for(j=i-gap; j>=0 && comp.compare(arr[j], insertVal) < 0; j=j-gap) {
					arr[j+gap] = arr[j];
				}
				
				arr[j+gap] = insertVal;
			}
		}
	}
	
	/**
	 * 
	 * @param <T>
	 * @param array
	 * @param i
	 * @param j
	 */
	private static <T> void swapElements(T[] array, int i, int j )
	{
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
