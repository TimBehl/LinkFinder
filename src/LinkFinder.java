import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;


public class LinkFinder {
		
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fstream = new FileInputStream("Links/neumont.edu");
		LinkFinder finder = new LinkFinder();
		finder.processPage(fstream);
	}
	
	public void processPage(InputStream in){
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		
		try {
			while((strLine = br.readLine()) != null){
				System.out.println(strLine);
			}
		} catch (IOException e) {
			System.out.println("IO Exception.");
			e.printStackTrace();
		}
	}
	
	public Iterator<String> getLinks(){
		return null;
	}
	
}