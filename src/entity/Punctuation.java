package entity;

import java.util.List;

import logic.Print;

/**
 * Describes punctuational signs
 * 
 * @author Sveta 09.12.16
 *
 */
public class Punctuation extends Symbol<Punctuation> implements Print<Punctuation> {
	public Punctuation() {
		super();
	}

	public Punctuation(char c) {
		super();
		setSymbol(c);
	}

	@Override
	public String toString() {
		return String.valueOf(getSymbol());
	}

	/**
	 * print out the values of punctuation
	 */
	@Override
	public void print(List<Punctuation> list) {
		list.forEach(s -> System.out.print(s));
	}
}
