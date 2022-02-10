package managers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

import domain.Shape;

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
			System.out.println(options[i]);
			
			String param = options[i].substring(0, 2).toLowerCase();
			System.out.println("Param: " + param);
			switch (param) {
			case "-f":
				filename = options[i].substring(2);
				break;
			case "-t":
				target = options[i].substring(2);
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
}

