import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class WordHandler {
	private ArrayList<String> words ;
	private ArrayList<Integer> count;
	private ArrayList<String> temp;
	private ArrayList<String> temp2;
	
	private String wordToFind;
	private int count2;
	
	public WordHandler(String textIn) {
		String[] allWords = textIn.split("\\s+");
		words = new ArrayList<String>();
		count = new ArrayList<Integer>();
		temp2 = new ArrayList<String>();
		
		wordToFind = "";
		count2 = 0;
		
		addWords(allWords);
		analyze();
		
	}
	
	public void addWords(String[] textIn) {
		
		for(int i = 0; i < textIn.length; i++) {
			words.add(textIn[i]);
			temp2.add(textIn[i]);
		}
	}
	
	
	public void analyze() {
		analyzeFrequency();
		dumping();
	}

	private void analyzeFrequency() {
		temp = new ArrayList<String>();
		for(int i = 0; i < words.size(); i++) {
			if(temp.contains(words.get(i))) {
				int index = temp.indexOf(words.get(i));
				count.set(index, count.get(index)+1);
			}
			else {			
				temp.add(words.get(i));
				count.add(1);
			}
		}

	}
	
	private void dumping() {
		words.clear();
		for(int i = 0; i < temp.size(); i++) {
			words.add(temp.get(i));
		}
	}
	
	public int searchFor(String wordToSearch) {
		for(int i = 0; i < temp2.size(); i++) {
			if(temp2.get(i).equalsIgnoreCase(wordToSearch)) {
				count2++;
			}
		}
		
		return count2;
	}
	


	public String toString() {
		String toReturn = "The total number of unique \n words is: " + words.size() + "\n";
		for(int i = 0; i < words.size(); i ++) {
			toReturn += words.get(i) + ": " + count.get(i) + "\n";
		}
		return toReturn;
	}
	

	
	
}
