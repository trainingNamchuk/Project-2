package entity;

import java.util.LinkedList;
import java.util.List;

import logic.Print;

/**
 * Describes text
 * 
 * @author Sveta 09.12.16
 * 
 */
public class Text extends Symbol<Text> implements Print<Sentence> {
	private List<Sentence> sentence = new LinkedList<>();

	public List<Sentence> getSentence() {
		return sentence;
	}

	public Text() {
	}

	public Text(List<Sentence> sentence) {
		this.sentence.addAll(sentence);
	}

	/**
	 * print out the values of text
	 */
	@Override
	public void print(List<Sentence> list) {
		list.forEach(s -> s.print(s.getWord(), s.getPunctuation()));
	}

	@Override
	public String toString() {
		return sentence.toString();
	}
}
