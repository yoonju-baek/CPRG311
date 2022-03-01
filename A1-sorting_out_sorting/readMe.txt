Project title:	CPRG 311 Assignment 1 - Complexity and Sorting
Authors: Group 5 -  DongYeon Kim 
		    Seungjin Moon
		    Yoonju Baek
Date: 13 Feb 2022

================================================================

This sorting program implements six sorting algorithms: 
Bubble, Selection, Insertion, Merge, Quick and shell Sort.
This testing application will compare polygons by height, volume
or base area from data in txt files (polyfor1.txt, polyfor3.txt 
and polyfor5.txt), then will sort in descending order.

================================================================

To use the program, follow the steps below.

1. Run CMD (Command Prompt)
2. Change the current directory to where the Sort.jar files are 
	ex) cd C:\temp
3. Enter commands via Command Line
	ex) java -jar sort.jar -tH -F"C:\temp\polyfor1.txt" –sB
	
	option:
		-f							data file path
		-fpolyfor1.txt				not use path if data file is the same path with jar file
		-f"/res/polyfor1.txt"		use the relative path data file is
		-f"c:\temp\polyfor1.txt"	use the absolute path data file is
		
		-t							sorting type option
		-th							sort by height
		-tv							sort by volume
		-ta							sort by base area
		
		-s							sorting algorithm option
		-sb							sort using bubble sort algorithm
		-ss							sort using selection sort algorithm
		-si							sort using insertion sort algorithm
		-sm							sort using merge sort algorithm
		-sq							sort using quick sort algorithm
		-sz							sort using shell sort algorithm
================================================================

Completeness of the assignment: 100% (The program works properly. 
There are no any deficiencies or missing functionalities)