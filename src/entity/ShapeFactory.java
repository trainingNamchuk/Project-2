package entity;

import java.util.HashMap;
import java.util.List;

/**
 * Form one of the following shapes: word, punctuation, sentence.
 * 
 * @author Sveta 09.12.16
 *
 */
public class ShapeFactory {
	private final HashMap<String, Word> wordMap = new HashMap<>();
	private final HashMap<String, Punctuation> punctMap = new HashMap<>();
	private final HashMap<String, Sentence> sentMap = new HashMap<>();

	public Word getWord(char c) {
		Word word = wordMap.get(String.valueOf(c));
		if (word == null) {
			word = new Word(c);
			wordMap.put(String.valueOf(c), word);
			// System.out.println("Creating word : " + c);
		}
		return word;
	}

	public Punctuation getPunct(char c) {
		Punctuation punctuation = punctMap.get(String.valueOf(c));
		if (punctuation == null) {
			punctuation = new Punctuation(c);
			punctMap.put(String.valueOf(c), punctuation);
			// System.out.println("Creating punctuation : " + c);
		}
		return punctuation;
	}

	public Sentence getSentence(List<Word> word, List<Punctuation> punctuation) {
		Sentence sentence = sentMap.get(word.toString());
		if (sentence == null) {
			sentence = new Sentence(word, punctuation);
			sentMap.put(word.toString(), sentence);
			// System.out.println("Creating word : " + word.toString());
		}
		return sentence;
	}
}
