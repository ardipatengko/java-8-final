package test;

import org.junit.Test;

import pckg.Words;

import static org.junit.Assert.*;

public class WordsTest {
	
	//to test if file is not exists
	@Test
	public void createFileTest(){
		String fileName = "words-list.txt";
		boolean result = true;
		assertEquals(Words.createFile(fileName), result);
	}
	
	@Test
	public void addToFileTest(){
		String fileName = "words-list.txt";
		String word = "Ardi";
		assertEquals(Words.addToFile(fileName, "Ardi"), word);
	}
	
	@Test
	public void findFirstTest(){
		String fileName = "words-list.txt";
		String word = "Hello";
		assertEquals(Words.findFirst(fileName), word);
	}
}
