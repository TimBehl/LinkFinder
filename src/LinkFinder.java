import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkFinder {
	
	ArrayList<String> listOfLinks = new ArrayList<String>();
	
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fstream = new FileInputStream("Links/neumont.edu");
		LinkFinder finder = new LinkFinder();
		finder.processPage(fstream);
		Iterator<String> listIterator = finder.getLinks();
		while(listIterator.hasNext()){
			System.out.println(listIterator.next());
		}
	}
	
	public void processPage(InputStream in){
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		
		try {
			while((strLine = br.readLine()) != null){
				String pattern = ".*[Aa]\\s+[Hh][Rr][Ee][Ff]\\s*=\\s*\"(.*?)\".*";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(strLine);
				if(m.matches()){
					listOfLinks.add(m.group(1));
				}
			}
		} catch (IOException e) {
			System.out.println("IO Exception.");
			e.printStackTrace();
		}
	}
	
	public Iterator<String> getLinks(){
		return listOfLinks.iterator();
	}
}