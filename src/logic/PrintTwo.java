package logic;

import java.util.List;

/**
 * Interface for printing 2 lists
 * 
 * @author Sveta 09.12.16
 *
 * @param <T>
 * @param <T2>
 */
public interface PrintTwo<T, T2> {
	void print(List<T> list, List<T2> list2);
}
