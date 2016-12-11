package entity;

import java.util.List;

import logic.Print;

/**
 * Describes word
 * 
 * @author Sveta 09.12.16
 *
 */
public class Word extends Symbol<Word> implements Print<Word> {
	public Word() {
	}

	public Word(char c) {
		super();
		setSymbol(c);
	}

	/**
	 * print out the values of word
	 */
	@Override
	public void print(List<Word> list) {
		list.forEach(s -> System.out.print(s));

	}

	@Override
	public String toString() {
		return String.valueOf(getSymbol());
	}
}
