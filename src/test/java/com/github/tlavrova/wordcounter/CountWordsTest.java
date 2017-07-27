package com.github.tlavrova.wordcounter;

import junit.framework.TestCase;
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

	public void testMakeWordList() {
		fail("Not yet implemented");
	}

	public void testGetFile() {
		fail("Not yet implemented");
	}

}
