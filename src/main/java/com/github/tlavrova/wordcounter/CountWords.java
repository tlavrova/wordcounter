package com.github.tlavrova.wordcounter;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CountWords {
	public static void main (String args[]) throws Exception {
		System.out.println("Counting Words");
		HashMap<String, Integer> listOfWords = makeWordList();
		System.out.println(listOfWords);
	}
	
	public static String getOnlySmallLetters(String str) {
		String newstr = str.replaceAll("[^А-Яа-яA-Za-z]", "");
		String strLowCase = newstr.toLowerCase();
		if (strLowCase.isEmpty()) {
			return "";				
		} else {
			return strLowCase;
		}
	}
	
	public static HashMap<String, Integer> makeWordList() throws FileNotFoundException {
		File text = new File("C:\\CountWords.txt"); 
		Scanner scan = new Scanner(text);
		HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();
		//Scanner scan1 = new Scanner(scan1);
		int countWord = 0;
		while (scan.hasNextLine()) {
			String word = scan.next();	//scanner automatically uses " " as a delimeter
			String wordOnlyLetters = getOnlySmallLetters(word);
			if (!wordOnlyLetters.isEmpty()) {
				if (!listOfWords.containsKey(wordOnlyLetters)) {	//add word if it isn't added already
					listOfWords.put(wordOnlyLetters, 1);		//first occurance of this word
				}
				else {
					countWord = listOfWords.get(wordOnlyLetters) + 1;	//get current count and increment
					//now put the new value back in the HashMap
					listOfWords.remove(wordOnlyLetters);			//first remove it (can't have duplicate keys)
					listOfWords.put(wordOnlyLetters, countWord);	//now put it back with new value
 				}
			}
		}
		scan.close();
		return listOfWords;
	}
}