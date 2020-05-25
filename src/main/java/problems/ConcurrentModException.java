/**
 * 
 */
package main.java.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * iterate over array list , it should show the scenarios where it will throw concurentModificationException and will not. 
 * Both in single threaded model.
 * 
 * @author rupesh sharma
 *
 */
public class ConcurrentModException {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		concurrentModSuccess();
		
		concurrentModError();

	}
	
	/**
	 * Concurrent modification exception error, when iterating over the list using the iterator
	 */
	private static void concurrentModError() {
		
		List<String> list = new ArrayList<>();
		list.add("Test1");
		
		for(String str: list) {
			list.remove(str);
		}
		
	}
	
	/**
	 * No Concurrent modification exception error, when iterating over the list using the traditional for loop
	 */
	private static void concurrentModSuccess() {
		
		List<String> list = new ArrayList<>();
		list.add("Test1");
		
		for(int i=0; i<list.size(); i++) {
			list.remove(i);
		}
		
		System.out.println("Concurrent Modification Success");
		
	}

}
