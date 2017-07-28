package com.github.tlavrova.wordcounter;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import com.github.tlavrova.wordcounter.CountWords;

public class CountWordsTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testMain() {
		fail("Not yet implemented");	//???
	}

	public void testGetOnlySmallLettersNotEmpty() {
		String str = "МнОгО,иДрУгИхХаРаКтЕрИсТиКдОлЯоПтИчЕсКоГоИзЛуЧеНиЯмЕнЬшЕтОлЩиНыГаЛаКтИкИ.";
		String strLowCase = CountWords.getOnlySmallLetters(str);
		assertEquals("многоидругиххарактеристикдоляоптическогоизлученияменьшетолщиныгалактики", strLowCase);		
	}
	
	public void testGetOnlySmallLettersIsEmpty() {
		String str = ",.";
		String strLowCase = CountWords.getOnlySmallLetters(str);
		assertEquals("", strLowCase);		
	}

	public void testMakeWordList() throws FileNotFoundException {
//		File f = new File("C:\\testCountWords.txt");
//		HashMap<String, Integer> hm = CountWords.makeWordList(f);		
	}

	public void testGetFile() {
		File f = CountWords.getFile();
		assertTrue(f.exists());
	}
}
