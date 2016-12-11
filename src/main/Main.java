package main;

import java.io.FileNotFoundException;
import java.io.FileReader;

import entity.Text;
import logic.Logic;

/**
 * Run logic of program
 * 
 * @author Sveta 09.12.16
 *
 */
public class Main {

	public static void main(String[] args) {
		Logic logic = new Logic();
		Text text = new Text();
		FileReader reader;
		try {
			reader = new FileReader("C:\\Users\\Sveta\\Desktop\\test.txt");
			text = logic.readFile(reader);
			 //logic.printText(text);
			System.out.println("The total number of sentences with equal words is : " + logic.find(text));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
