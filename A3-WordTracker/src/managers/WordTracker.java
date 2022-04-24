package managers;

import java.io.*;

import exceptions.TreeException;
import problemdomain.Location;
import problemdomain.Word;
import utilities.BSTree;
import utilities.Iterator;

/**
 *  This class reads text files and collects and stores all words it finds in those files.
 *  Stores each occurrence of a word in a file and the line on which it was found in that file.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 16 2022
 */
public class WordTracker {
	
	private BSTree<Word> wordsTree;
	private String inFilename;
	private String outFilename;
	private String printOpt;
	
	private final String WORDTREE_BINARY = "res/repository.ser";
	
	/**
	 * Create WordTracker object.
	 * 
	 * @param args options that include the input text file, the method of prints and the output file
	 */
	public WordTracker(String[] args) {
		wordsTree = new BSTree<>();
		
		if((args.length >= 2) && checkOption(args)) {
			System.out.println("[Word Tracker]Start proccessing]");
			deserializeWordsFromFile();
			loadWordsFromFile();
			serializeWordsToFile();
			reportWordInfo();
			System.out.println("[Word Tracker]End proccess]");
		}
		else {
			printOptionGuidance();
		}
	}
	
	/**
	 * Determines the options for tracking words from the text file.
	 * 
	 * @param options options include the input text file, the method of prints and the output file(optional)
	 */
	private boolean checkOption(String[] options) {
		boolean isValid = false;
		
		if(options.length < 2) {
			return false;
		}
		
		// check if the first option is the file or not
		File textFile = new File(options[0]);
		
		if(!textFile.exists()) {
			System.out.println("The file '"+ textFile.getAbsolutePath() + "' is not exist.");
			return false;
		}
		
		inFilename = options[0];
			
		// Check word recording option
		String record = options[1];
		if(!record.isBlank() && 
		  (record.equals("-pf") || record.equals("-pl") || record.equals("-po"))) {
			printOpt = record;
			isValid = true;
		}
		else {
			System.out.println("Second argument is required and only options are '-pf', '-pl' or '-po'.");
			isValid = false;
		}

		// Check optional argument to the report file
		if(options.length >= 4 && 
		   options[2].equals("-f") && 
		   options[3].endsWith(".txt")) {
				outFilename = options[3];
				isValid = true;
		}
		else {
				isValid = false;
		}
		
		return isValid;
		
	}
	
	/**
	 * Method to load words from the text file and fill to BS Tree
	 */
	private void loadWordsFromFile() {
		BufferedReader fin;
		String line;
		int currLineNumber = 0;
		
		try {
			fin = new BufferedReader(new FileReader(inFilename));
			
			while((line = fin.readLine()) != null) {
				// remove punctuations
				line =  line.replaceAll("[!\"#$%&()*+,-./:';<=>?@\\[\\]^_`{|}~]", " ");
				
				currLineNumber++;
				
				String[] words = line.split(" ");
				
				for(String word:words) {
					if(word.isBlank()) {
						continue;
					}
					Location nLocation = new Location(inFilename, currLineNumber);
					Word nWord = new Word(word, nLocation);
					
					if(wordsTree.isEmpty() || !wordsTree.contains(nWord)) {
						wordsTree.add(nWord);
					}
					else {
						Word oWord = wordsTree.search(nWord).getElement();
						
						
						// Add new location
						boolean isListed = false;
						for(Location location:oWord.getLocations()) {
							if(location.getFileName().equals(inFilename)) {
								if(!location.getLineNumbers().contains(currLineNumber)) {
									location.addLineNumbers(currLineNumber);
								}
								// increase occurrence in the list 
								oWord.increaseOccurrence();
								isListed = true;
								break;
							}
						}
						
						if(!isListed) {
							oWord.addLocation(nLocation);
						}
						
					}
				}
			}
			
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TreeException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to report in alphabetic order all words along with the corresponding list of files,
	 * numbers of the lines in which the word occur and the frequency of occurrence of the words.
	 */
	private void reportWordInfo() {
		PrintStream output = null;
		try {
			if(outFilename != null) {
				String path = inFilename.substring(0, inFilename.lastIndexOf("\\")+1);
					output = new PrintStream(path+outFilename);
			}
			else {
				output = System.out;
			}
			
			Iterator<Word> iterator = (Iterator<Word>) wordsTree.inorderIterator();
			while(iterator.hasNext()) {
				Word word = iterator.next();
				
				switch (printOpt) {
					case "-pf":
						output.println(word.getWord());
						for(Location location:word.getLocations()) {
							output.println("\t"+location.getFileName());
						}
							
						break;
					case "-pl":
						output.println(word.getWord());
						output.println("\t"+"Total Occurrence: " + word.getOccurrence() +  " time(s).");
						for(Location location:word.getLocations()) {
							output.println("\t"+location.getFileName());
						}
							
						break;
					case "-po":
						output.println(word.getWord());
						output.println("\t"+"Total Occurrence: " + word.getOccurrence() +  " time(s).");		
						for(Location location:word.getLocations()) {
							output.println("\t"+location.getFileName());

							output.println("\tLine Numbers:");
							for(int lineNumber:location.getLineNumbers()) {
								output.println("\t\t"+lineNumber);
							}
						}
							
						break;
					}
						
				}
			
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Store the words tree in a binary file
	 */
	private void serializeWordsToFile() {
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(WORDTREE_BINARY));

			oos.writeObject(wordsTree);
			oos.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Restores the words tree from the binary file
	 */
	private void deserializeWordsFromFile() {
		try
		{
			ObjectInputStream ois = new ObjectInputStream(
						new FileInputStream(WORDTREE_BINARY));

			wordsTree = (BSTree<Word>) ois.readObject();
			ois.close();
		}
		catch (FileNotFoundException e)
		{
			return;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Print option guidance
	 */
	private void printOptionGuidance() {
		System.out.println("[Error]Invalid option");
		System.out.println("==== Option Guidance =====");
		System.out.println("<input.txt> -pf/-pl/-po [-f <output.txt>]");
		System.out.println("<input.txt> : the path and filename of the text file to be processed");
		System.out.println("[-pf]: print in alphabetic order all words along with the corresponding list of files in which the words occur.");
		System.out.println("[-pl]: print in alphabetic order all words along with the corresponding list of files and numbers of the lines in which the word occur.");
		System.out.println("[-po]: print in alphabetic order all words along with the corresponding list of files, numbers of the lines in which the word occur and the frequency of occurrence of the words.");
		System.out.println("[-f] <output.txt>: optional, redirect of the report in the previous step to the path and filename specified in <output.txt>. ");
	}

}
