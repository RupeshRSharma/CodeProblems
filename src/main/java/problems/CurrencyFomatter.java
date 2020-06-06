/**
 * 
 */
package main.java.problems;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Format input payment to different currencies.
 * 
 * @author rupesh sharma
 *
 */
public class CurrencyFomatter {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double payment = scanner.nextDouble();
		scanner.close();

		// Write your code here.
		Locale indiaLocale = new Locale("en", "IN");

		/* Create NumberFormats using Locales */
		String us = NumberFormat.getCurrencyInstance(Locale.US).format(payment);
		String india = NumberFormat.getCurrencyInstance(indiaLocale).format(payment);
		String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
		String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

		System.out.println("US: " + us);
		System.out.println("India: " + india);
		System.out.println("China: " + china);
		System.out.println("France: " + france);
	}

}
