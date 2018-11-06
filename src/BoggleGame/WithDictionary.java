package BoggleGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WithDictionary {
	protected List<String> readDictionary() {
		String word;
		List<String> dictionary = new ArrayList<String>();
		String file = "/Users/dai/Documents/projects/BoggleGame/dict.txt";
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while ((word = bf.readLine()) != null) {
				dictionary.add(word);
			}
			bf.close();
		} catch (FileNotFoundException e) {
			System.out.println("Dictionary File Not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("INVALID INPUT");
			e.printStackTrace();
		}
		return dictionary;
	}
}
