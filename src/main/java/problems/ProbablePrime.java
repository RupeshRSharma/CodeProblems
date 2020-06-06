/**
 * 
 */
package main.java.problems;

import java.math.BigInteger;

/**
 * A prime number is a natural number greater than  whose only positive divisors are  and itself.
Given a large integer, , use the Java BigInteger class' isProbablePrime method to determine and print whether it's prime or not prime.

If  is a prime number, print prime; otherwise, print not prime.

Sample Input

13

Sample Output

prime

Explanation

The only positive divisors of  are  and , so we print prime.

 * @author rupesh sharma
 *
 */
public class ProbablePrime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new BigInteger("5").isProbablePrime(1)?"prime":"not prime");
	}

}
