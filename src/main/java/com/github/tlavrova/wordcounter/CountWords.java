package com.github.tlavrova.wordcounter;
import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {
	public static void main (String args[]) throws Exception {
		System.out.println("Counting Words");
		FileReader fr = new FileReader("C:\\CountWords.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int count = 0;
		while (line != null){
			String []space = line.split(" ");
			for (String w : space){
				String stOnlyLetters = getOnlyLetters(w);
				if (!stOnlyLetters.isEmpty()){
					System.out.println(stOnlyLetters);
					count++;
				}
			}
			line = br.readLine();
		}
		System.out.println(count);
	}
	
	public static String getOnlyLetters(String str){
		String newstr = str.replaceAll("[^А-Яа-яA-Za-z]", "");
		if (newstr.isEmpty()){
			return "";
				
		}else{
			return newstr;
		}
	}
}