package logic;

import java.io.*;
import entity.Punctuation;
import entity.Sentence;
import entity.ShapeFactory;
import entity.Text;
import entity.Word;

/**
 * implements main logic
 * 
 * @author Sveta 09.12.16
 *
 */
public class Logic {
	boolean flag;
	Word word = new Word();
	Punctuation punctuation = new Punctuation();
	Sentence sentence = new Sentence();
	Text text = new Text();
	ShapeFactory shapeFactory = new ShapeFactory();

	/**
	 * Read file char by char and split it to words, punctuational symbols and
	 * sentences.
	 * 
	 * @param reader
	 * @return formed text
	 */
	public Text readFile(FileReader reader) {
		try {
			int c;
			while ((c = reader.read()) != -1) {
				if (isPunctuation((char) c)) {
					Punctuation punctuation2 = shapeFactory.getPunct((char) c);
					punctuation.addSubparts(punctuation2);
					if (isEnd((char) c)) {
						flag = true;
					}
					continue;
				}

				if (!word.getSubparts().isEmpty() && !punctuation.getSubparts().isEmpty()) {
					Sentence s = shapeFactory.getSentence(word.getSubparts(), punctuation.getSubparts());
					sentence.addSubparts(s);
					if (flag) {
						Text t = new Text(sentence.getSubparts());
						text.addSubparts(t);
						sentence = new Sentence();
						flag = false;
					}
					word = new Word();
					punctuation = new Punctuation();
					Word word2 = shapeFactory.getWord((char) c);
					word.addSubparts(word2);
				}

				else {
					Word word2 = shapeFactory.getWord((char) c);
					word.addSubparts(word2);
				}
			}
			Sentence s = shapeFactory.getSentence(word.getSubparts(), punctuation.getSubparts());
			sentence.addSubparts(s);
			Text t = new Text(sentence.getSubparts());
			text.addSubparts(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * Find sentences that contains equal words and print out their total number
	 * 
	 * @param text
	 */
	public int find(Text text) {
		int countWords = 0;
		int countSentence = 0;
		String wordCompare;
		String wordAnother;
		// System.out.println("List of sentences with equal words:\n");
		for (Text s1 : text.getSubparts()) {
			for (int i = 0; i < s1.getSentence().size(); i++) {
				wordCompare = s1.getSentence().get(i).getWord().toString();
				for (int j = i + 1; j < s1.getSentence().size(); j++) {
					wordAnother = s1.getSentence().get(j).getWord().toString();
					if (wordCompare.equals(wordAnother)) {
						countWords++;
					}
				}
			}
			if (countWords != 0) {
				// s1.print(s1.getSentence());
				countSentence++;
				countWords = 0;
			}

		}
		return countSentence;
	}

	/**
	 * Check if symbol is .?! which is mean we reach the end of sentence
	 * 
	 * @param c
	 * @return true if symbol is .?!
	 */
	public boolean isEnd(char c) {
		if (c == '.' || c == '!' || c == '?') {
			return true;
		}
		return false;
	}

	/**
	 * Check if symbol is one of the punctuational symbols
	 * 
	 * @param c
	 * @return true if symbol is a punctuational symbol
	 */
	public boolean isPunctuation(char c) {
		if (c == ',' || c == ':' || c == ';' || c == '.' || c == '!' || c == '?' || c == '-' || c == '=' || c == '"'
				|| c == '\u0020' || c == '\n' || c == '\u2029' || c == '\u0009' || c == '\r' || c == '\t') {
			return true;
		}
		return false;
	}

	/**
	 * Print out the formed text
	 * 
	 * @param text
	 */
	public void printText(Text text) {
		for (Text s1 : text.getSubparts()) {
			s1.print(s1.getSentence());
		}
	}
}
