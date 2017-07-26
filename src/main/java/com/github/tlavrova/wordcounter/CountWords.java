package com.github.tlavrova.wordcounter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CountWords {
	public static void main (String args[]) throws Exception {
		System.out.println("Counting Words");
		HashMap<String, Integer> listOfWords = makeWordList();
		System.out.println(listOfWords);
//		FileReader fr = new FileReader("C:\\CountWords.txt");
//		BufferedReader br = new BufferedReader(fr);
//		String line = br.readLine();
//		int count = 0;
//		while (line != null){
//			String []space = line.split(" ");
//			for (String w : space){
//				String stOnlyLetters = getOnlyLetters(w);
//				if (!stOnlyLetters.isEmpty()){
//					System.out.println(stOnlyLetters);
//					count++;
//				}
//			}
//			line = br.readLine();
//		}
//		System.out.println(count);
	}
	
	public static String getOnlyLetters(String str){
		String newstr = str.replaceAll("[^А-Яа-яA-Za-z]", "");
		if (newstr.isEmpty()){
			return "";
				
		}else{
			return newstr;
		}
	}
	
	public static HashMap<String, Integer> makeWordList() throws FileNotFoundException{
		File text = new File("C:\\CountWords.txt"); 
		Scanner scan = new Scanner(text);
		HashMap<String, Integer> listOfWords = new HashMap<String, Integer>();
		//Scanner scan1 = new Scanner(scan1);
		int countWord = 0;
		while (scan.hasNextLine()){
			String word = scan.next();	//scanner automatically uses " " as a delimeter
			String wordOnlyLetters = getOnlyLetters(word);
			if (!wordOnlyLetters.isEmpty()){
				if(!listOfWords.containsKey(wordOnlyLetters)){	//add word if it isn't added already
					listOfWords.put(wordOnlyLetters, 1);		//first occurance of this word
				}
				else{
					countWord = listOfWords.get(wordOnlyLetters) + 1;	//get current count and increment
					//now put the new value back in the HashMap
					listOfWords.remove(wordOnlyLetters);			//first remove it (can't have duplicate keys)
					listOfWords.put(wordOnlyLetters, countWord);	//now put it back with new value
 				}
			}
		}
		return listOfWords;
	}
}