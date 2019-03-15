import java.util.Scanner;

public class COAppView implements AppView {
	DataHandler data;
	String ans, fileName, searchWord;
	Scanner sc;
	boolean searchForWord;
	int wordCount;
	
	public COAppView() {
		wordCount = 0;
		ans = null;
		searchWord = null;
		fileName = null;
		data = new DataHandler();
		sc = new Scanner(System.in);
		searchForWord = false;
	}
	
	
	@Override
	public void run() {
		getInput();
		data.getData(fileName);
		display();
		searchWord();
		
	}
	
	public void getInput() {
		System.out.println("Enter your file name?");
		fileName = sc.next();
	}
	
	public void display() {
		System.out.println("HERE IS YOUR DOCUMENTS");
		System.out.println(data.getTextIn());
		System.out.println("HERE IS YOUR ANALYZE RESULT");
		System.out.println(data.getDocument());
	}
	
	public void searchWord() {
		System.out.println("DO YOU WANT TO SEARCH FOR A WORD IN PARTICULAR(y/n)?:");
		ans = sc.next();
		if(ans.equalsIgnoreCase("y")) {
			searchForWord = true;
		}
		
		while(searchForWord) {
			System.out.println("Enter your word to  find");
			searchWord = sc.next();
			wordCount = data.searchData(searchWord);
			System.out.println("Your word \"" + searchWord + "\" appears " + wordCount + " times");
			System.out.println("Do you want to continue?");
			ans = sc.next();
			if(ans.equalsIgnoreCase("y")) {
				searchForWord = true;
			}
			else {
				searchForWord = false;
				wordCount = 0;
				searchWord = null;
			}
			
		}
		
	}

}
