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
	private String filename = "";
	private String target = "";
	private String sorting = "";

	private String targetStr;
	private String sortingStr;
	
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
		
		if(!filename.isEmpty() && !target.isEmpty() && !sorting.isEmpty()) {
			if(!fillShapeArray()) {
				executeSorting();	
			}
		}
		else {
			printOptionGuidance();
		}
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
					if(filename.contains("\\") || filename.contains("/")) {
						filename = filename.replaceAll("\"", "");
					}
					else {
						filename = "res/" + filename;
					}
					break;
				case "-t":
					target = options[i].substring(2).toLowerCase();
					if (target.equals("h")) {
						targetStr = "Height";
					} else if (target.equals("a")) {
						targetStr = "BaseArea";
					} else if (target.equals("v")) {
						targetStr = "Volume";
					} else {
						target = "";
					}
					
					break;
				case "-s":
					sorting = options[i].substring(2).toLowerCase();
					if (sorting.equals("b")) {
						sortingStr = "Bubble Sort";
					} else if (sorting.equals("s")) {
						sortingStr = "Selection Sort";
					} else if (sorting.equals("i")) {
						sortingStr= "Insertion Sort";
					} else if (sorting.equals("m")) {
						sortingStr = "Merge Sort";
					} else if (sorting.equals("q")) {
						sortingStr = "Quick Sort";
					} else if (sorting.equals("z")) {
						sortingStr = "Shell Sort";
					} else {
						sorting = "";
					}
					break;

				default:
					printOptionGuidance();
					break;
			}
			
			i++;
		}

	}
	
	/**
	 * Method to load shape date from the file and fill to array
	 */
	private boolean fillShapeArray()
	{
		boolean isError = false;
		try
		{
			BufferedReader fin = new BufferedReader(new FileReader(filename));
			
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
			isError = true;
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (IllegalArgumentException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
			isError = true;
		}
		catch (InvocationTargetException e)
		{
			e.printStackTrace();
			isError = true;
		}
				
		return isError;
	}
	
	/**
	 * Execute sorting based on options user input
	 */
	private void executeSorting() {
		//instantiate for compare value based on base area and volume
		BaseAreaCompare ba = new BaseAreaCompare();			
		VolumeCompare vc = new VolumeCompare();

		System.out.println("Start sorting data in " +filename + " by " + targetStr + " using " + sortingStr +"\n");
		
		//get start time before sorting
		long startTime = System.currentTimeMillis();

		//execute a specific sorting according to the option user input
		switch (sorting) {
			case "b":
				if (target.equals("h")) {
					Sorting.bubbleSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.bubbleSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.bubbleSort(shapeArray, vc);
				}
				break;
			case "s":
				if (target.equals("h")) {
					Sorting.selectionSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.selectionSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.selectionSort(shapeArray, vc);
				}
				break;
			case "i":
				if (target.equals("h")) {
					Sorting.insertionSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.insertionSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.insertionSort(shapeArray, vc);
				}
				break;
			case "m":
				if (target.equals("h")) {
					Sorting.mergeSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.mergeSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.mergeSort(shapeArray, vc);
				}
				break;
			case "q":
				if (target.equals("h")) {
					Sorting.quickSort(shapeArray);
				} else if (target.equals("a")) {
					Sorting.quickSort(shapeArray, ba);
				} else if (target.equals("v")) {
					Sorting.quickSort(shapeArray, vc);
				}
				break;
			case "z":
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
		System.out.println(String.format("Elapsed time to process %s(%s): %dms", sortingStr, targetStr, (endTime - startTime)));
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
				System.out.println("No. " + String.format("%8d: %s", i+1, shapeArray[i].toString()));
			}
		}
	}
	
	/**
	 * Print option guidance
	 */
	private void printOptionGuidance() {
		System.out.println("[Error]Invalid option");
		System.out.println("==== Option Guidance =====");
		System.out.println("f: file name, t: the compare type, s: the sort type");
		System.out.println("[t option] h: height, a: base area, v: volume");
		System.out.println("[s option] b: bubble, s: selection, i: insertion, m: merge, q: quick, z: shell");
		System.out.println("E.g. -fpolyfor1.txt -Tv -Sb");
	}
		
}


