package managers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.StringTokenizer;

import domain.Shape;


public class Manager {

	//Attributes
	private Shape[]	shapeArray;
	private String filename;
	private String target;
	private String sorting;
	
	public Manager() {
	}
	
	public Manager(String[] options) {
		checkSortingOption(options);
		fillShapeArray();
	}
	
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

