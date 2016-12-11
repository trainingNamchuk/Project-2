package entity;
import java.util.LinkedList;
import java.util.List;
/**
 *  Describes symbol
 * @author Sveta 09.12.16
 *
 * @param <T>
 */
public abstract class Symbol<T> {
	private char symbol;
	private List<T> subparts;

	Symbol() {
		this.subparts = new LinkedList<>();
	}

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public List<T> getSubparts() {
		return subparts;
	}

	public void addSubparts(T subparts) {
		this.subparts.add(subparts);
	}

}
