package pckg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Words {
	static Scanner scan = new Scanner(System.in);
	public static boolean createFile(String fileName){
		List<String> listString = new ArrayList<>();
		listString.add("Hello");
		listString.add("Put");
		listString.add("Mouse");
		try {
			Files.write(Paths.get(fileName), listString, Charset.defaultCharset());
			System.out.println("SUCCESS");
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FAILED!!");
		}
		return false;
	}
	
	public static List<String> getList(String fileName){
		try {
			return Files.lines(Paths.get(fileName)).collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return null;
	}
	
	public static void listWords(String fileName){
		System.out.printf("Your list words in %s file\n", Paths.get(fileName));
		System.out.printf("==================================\n");
		//Files.lines(Paths.get(fileName)).forEach(System.out::println);
		getList(fileName).forEach(System.out::println);
		System.out.printf("==================================\n\n");
	}
	
	public static void sortingList(String fileName){
		getList(fileName).stream().sorted((s1, s2) -> {
			if(s1.length() < s2.length()){
				return 1;
			}else if (s1.length() > s2.length()){
				return -1;
			}else{
				return 0;
			}
		}).forEach(System.out::println);
	}
	
	public static void findMatchWord(String fileName, int length){
		getList(fileName).stream().
		filter(word -> word.length() == length).forEach(System.out::println);
	}
	
	public static String findFirst(String fileName){
		return getList(fileName).stream().findFirst().get();
	}
	
	public static String addToFile(String fileName, String word){
		/*
		String words = "";
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName), UTF_8 ,  APPEND, CREATE)) {
			words = scan.nextLine().trim();
			while (!words.equals("_exit")) {
				System.out.println("Type '_exit' to end");
				writer.write(words);
				writer.newLine();
				words = scan.nextLine().trim();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		*/
		List<String> listString = new ArrayList<>();
		listString.add(word);
		try {
			Files.write(Paths.get(fileName), listString, UTF_8 ,  APPEND, CREATE);
			return word;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
