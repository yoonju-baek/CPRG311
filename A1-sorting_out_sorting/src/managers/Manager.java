package managers;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;

import domain.Shape;
import utilities.*;

/**
 * This class compares height, base area, and volume to sort various shapes.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Feb 07 2022
 *
 */
public class Manager {

	//Attributes
	private Shape[]	shapeArray;
	private String filename;
	private String target;
	private String sorting;

	private String targetStr;
	/**
	 * Create Manager object.
	 */
	public Manager() {
	}
	
	/**
	 * Create Manager object.
	 * @param options options include the compare type, the sort type and the file name
	 */
	public Manager(String[] options) {
		checkSortingOption(options);
		fillShapeArray();
	}

	
	/**
	 * Determines the options for comparing and sorting from the file
	 * @param options options include the compare type, the sort type and the file name
	 */
	private void checkSortingOption(String[] options) {
		int i=0;

		while(i < options.length) {			
			String param = options[i].substring(0, 2).toLowerCase();
			switch (param) {
				case "-f":
					filename = options[i].substring(2);
					break;
				case "-t":
					target = options[i].substring(2);
					if (target.equals("h")) {
						targetStr = "Height";
					} else if (target.equals("a")) {
						targetStr = "BaseArea";
					} else if (target.equals("v")) {
						targetStr = "Volume";
					}
					break;
				case "-s":
					sorting = options[i].substring(2);
					break;

				default:
					System.out.println("Something wrong");
					break;
			}
			
			i++;
		}

	}
	
	/**
	 * Method to load shape date from the file and fill to array
	 */
	private void fillShapeArray()
	{
		try
		{
			BufferedReader fin = new BufferedReader(new FileReader("res/"+filename));
			
			String line = fin.readLine();
			
			
			while(line != null)
			{
				Object o = null;
				StringTokenizer st = new StringTokenizer(line," ");
				
				int shapeNums = Integer.parseInt(st.nextToken());
				shapeArray = new Shape[shapeNums];

				for(int i=0; i<shapeArray.length; i++) {
					String className = "domain."+st.nextToken();
					Class cls = Class.forName(className);
				
					Class paramTypes[] = new Class[2];
					paramTypes[0] = Double.TYPE;
					paramTypes[1] = Double.TYPE;
					
					Constructor ct = cls.getConstructor(paramTypes);
					
					Object argList[] = new Object[2];
					argList[0] = new Double(Double.parseDouble(st.nextToken()));
					argList[1] = new Double(Double.parseDouble(st.nextToken()));
					
					o = ct.newInstance(argList);
					
					shapeArray[i] = (Shape) o;
				}
				
				line = fin.readLine();
			}		
			fin.close();	
		}	
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
		}
				
	}
	
	/**
	 * Execute sorting based on options user input
	 */
	public void executeSorting() {
		//instantiate for compare value based on base area and volume
		BaseAreaCompare ba = new BaseAreaCompare();			
		VolumeCompare vc = new VolumeCompare();

		String sortingType = "";
		
		//get start time before sorting
		long startTime = System.currentTimeMillis();

		//execute a specific sorting according to the option user input
		switch (sorting) {
			case "b":
				sortingType = "Bubble Sort";
				if (target.equals("h")) {
					Sorting.bubbleSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.bubbleSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.bubbleSort(shapeArray, vc);
				}
				break;
			case "s":
				sortingType = "Selection Sort";
				if (target.equals("h")) {
					Sorting.selectionSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.selectionSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.selectionSort(shapeArray, vc);
				}
				break;
			case "i":
				sortingType = "Insertion Sort";
				if (target.equals("h")) {
					Sorting.insertionSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.insertionSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.insertionSort(shapeArray, vc);
				}
				break;
			case "m":
				sortingType = "Merge Sort";
				if (target.equals("h")) {
					Sorting.mergeSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.mergeSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.mergeSort(shapeArray, vc);
				}
				break;
			case "q":
				sortingType = "Quick Sort";
				if (target.equals("h")) {
					Sorting.quickSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.quickSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.quickSort(shapeArray, vc);
				}
				break;
			case "z":
				sortingType = "Shell Sort";
				if (target.equals("h")) {
					Sorting.shellSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.shellSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.shellSort(shapeArray, vc);
				}
				break;
			default:
				System.out.println("Invalid sorting option.");
				return;
		}
		//get end time and calculate elapsed time to process sorting 
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Elapsed time to process %s(%s): %dms", sortingType, targetStr, (endTime - startTime)));
		System.out.println();
		
		//call a method for printing
		printSortedValue();
		
	}
	
	/**
	 * Print sorted array for first, last, and every thousandth value
	 */
	private void printSortedValue() {
		for (int i = 0; i < shapeArray.length; i++) {
			if (i == 0 || i == (shapeArray.length - 1) || i % 1000 == 999) {
				System.out.println("No. " + String.format("%8d: %s", i, shapeArray[i].toString()));
			}
		}
	}
		
}


