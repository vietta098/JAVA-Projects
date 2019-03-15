import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataHandler {
	WordHandler word;
	String textIn, buffer;
	
	public DataHandler() {
		this.word = word;
	}
	
	public void getData(String fileName) {
		textIn = "";
		try {
			FileReader fileReader = new FileReader(fileName);            
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((buffer = bufferedReader.readLine()) != null) {
            	textIn += buffer + "\n";
            }
            
           word = new WordHandler(textIn);
           fileReader.close();
           bufferedReader.close();
           
		}
		catch(IOException e) {
			System.out.println("Can't read file");
			e.printStackTrace();
		}
	}
	
	public int searchData(String wordIn ) {
		return word.searchFor(wordIn);
	}
	

	
	public WordHandler getDocument() {
		return word;
	}
	
	public String getTextIn() {
		return textIn;
	}
	
	public String getDocumentAsString() {
		return word.toString();
	}
	

}
