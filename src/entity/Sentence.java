package entity;

import java.util.LinkedList;
import java.util.List;

import logic.PrintTwo;

/**
 * Describes sentence
 * 
 * @author Sveta 09.12.16
 *
 */

public class Sentence extends Symbol<Sentence> implements PrintTwo<Word, Punctuation> {
	private List<Word> word = new LinkedList<>();
	private List<Punctuation> punctuation = new LinkedList<>();

	public List<Word> getWord() {
		return word;
	}

	public List<Punctuation> getPunctuation() {
		return punctuation;
	}

	public Sentence() {
	}

	public Sentence(List<Word> word, List<Punctuation> punctuation) {
		this.word.addAll(word);
		this.punctuation.addAll(punctuation);
	}

	@Override
	public String toString() {
		return word + "" + punctuation;
	}

	/**
	 * print out the values of sentence
	 */
	@Override
	public void print(List<Word> list, List<Punctuation> list2) {
		list.forEach(s -> System.out.print(s));
		list2.forEach(s -> System.out.print(s));

	}
}
