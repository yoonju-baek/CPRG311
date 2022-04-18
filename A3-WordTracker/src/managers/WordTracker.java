package managers;

import java.io.*;
import problemdomain.Word;
import utilities.BSTree;

/**
 *  This class reads text files and collects and stores all words it finds in those files.
 * 
 * @author Dongyeon Kim
 * @author Seungjin Moon
 * @author Yoonju Baek
 * 
 * @version Apr 16 2022
 */
public class WordTracker {
	
	private BSTree<Word> wordsTree;
	
	private String filename;
	private String recordOption;
	
	public WordTracker(String[] args) {
		wordsTree = new BSTree<>();
		
		if(checkOption(args)) {
			loadWordsFromFile();
		}
		else {
			printOptionGuidance();
		}
	}
	
	private boolean checkOption(String[] options) {
		boolean isValid = false;
		
		// check if the first option is the file or not
		File textFile = new File(options[0]);
		if(!textFile.isFile()) {
			System.out.println("First argument should be a file name.");
		}
		else if(!textFile.exists()) {
			System.out.println("The file '"+ textFile.getAbsolutePath() + "' is not exist.");
		}
		else {
			filename = options[0];
			
			// check word recording option
			String recordOpt = options[1];
			if(!recordOpt.isBlank() && 
				(recordOpt.equals("-pf") || recordOpt.equals("-pl") || recordOpt.equals("-po"))) {
				recordOption = recordOpt;
				isValid = true;
			}
			else {
				System.out.println("Second argument is required and only options are '-pf', '-pl' or '-po'.");
			}
		}
		
		// Check optional argument to the report file
		if(!options[2].isBlank() && options[2].equals("-f")) {
			if(!options[3].isBlank() && options[3].endsWith(".txt")) {
				// record the informtaion
			}
		}
		
		return isValid;
		
	}
	
	private void loadWordsFromFile() {
		BufferedReader fin;
		
		int currLineNumber = 0;
		
		try {
			fin = new BufferedReader(new FileReader(filename));
			
			String line = fin.readLine();
			// remove punctuations
			line =  line.replaceAll("[.,';-!\"?:()<>\\[\\]{}#$%&*+/=@^_`|~]", " ");
			
			while(line != null) {
				currLineNumber++;
				
				String[] words = line.split(" ");
				
				for(String word:words) {

				}
				
			}
		} catch (IOException e) {
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
