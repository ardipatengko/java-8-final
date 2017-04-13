package pckg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	static String fileName = "words-list.txt";
	public static void main(String[] args){
		//simple animal words
		MainMenu();
	}
	
	static void MainMenu(){
		Scanner scan = new Scanner(System.in);
		System.out.printf("1. Create a file\n");
		System.out.printf("2. List of Words\n");
		System.out.printf("3. Find words with length\n");
		System.out.printf("4. Sorting list of words\n");
		System.out.printf("5. Add to File\n");
		System.out.print("Choose your menu: ");
		int answer = scan.nextInt();
		switch (answer) {
		case 1:
			Words.createFile(fileName);
			MainMenu();
			break;
		case 2:
			Words.listWords(fileName);
			MainMenu();
			break;
		case 3:
			System.out.print("Your preferred length: ");
			int search = scan.nextInt();
			Words.findMatchWord(fileName, search);
			MainMenu();
			break;
		case 4:
			Words.sortingList(fileName);
			MainMenu();
			break;
		case 5:
			System.out.print("Your words: ");
			String word = scan.next().trim();

			Words.addToFile(fileName, word);
			MainMenu();
			break;
		default:
			break;
		}
	}
}
