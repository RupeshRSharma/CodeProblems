/**
 * 
 */
package main.java.problems;

import java.util.Scanner;

/**
 * 
The first line contains an integer, , denoting the number of queries.
Each line  of the  subsequent lines contains three space-separated integers describing the respective , , and  values for that query.

For each query, print the corresponding series on a new line. Each series must be printed in order as a single line of  space-separated integers.

Sample Input

2
0 2 10
5 3 5

Sample Output

2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98

We then print each element of our series as a single line of space-separated values.


 * @author rupesh sharma
 *
 */
public class Equation1 {
	
	 public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int t=in.nextInt();
	        for(int i=0;i<t;i++){
	            int a = in.nextInt();
	            int b = in.nextInt();
	            int n = in.nextInt();
	            int result = a;
	            for(int j=1, k=1; j<=n; j++, k+=k){
	                result += b*k;
	                System.out.print(result+" ");
	            }
	            System.out.println();
	        }
	        in.close();
	    }

}
