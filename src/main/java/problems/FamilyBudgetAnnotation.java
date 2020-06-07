/**
 * 
 */
package main.java.problems;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

/**
 * Here, we partially define an annotation,  and a class, . In this problem, we give the user role and the amount of money that a user spends as inputs. Based on the user role, you have to call the appropriate method in the  class. If the amount of money spent is over the budget limit for that user role, it prints Budget Limit Over.

Your task is to complete the  annotation and the  class so that the  class works perfectly with the defined constraints.

Sample Input

3
SENIOR 75
JUNIOR 45
SENIOR 40

Sample Output

Senior Member
Spend: 75
Budget Left: 25
Junior Member
Spend: 45
Budget Left: 5
Senior Member
Spend: 40
Budget Left: 60
 * 
 * @author rupesh sharma
 *
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface FamilyBudget {
	String userRole() default "GUEST";

	int budgetLimit() default 100;
	// ~~Complete the interface~~
}

class FamilyMember {
	// ~~Complete this line~~
	@FamilyBudget(userRole = "SENIOR", budgetLimit = 100)
	public void seniorMember(int budget, int moneySpend) {
		System.out.println("Senior Member");
		System.out.println("Spend: " + moneySpend);
		System.out.println("Budget Left: " + (budget - moneySpend));
	}

	// ~~Complete this line~~
	@FamilyBudget(userRole = "JUNIOR", budgetLimit = 50)
	public void juniorUser(int budget, int moneySpend) {
		System.out.println("Junior Member");
		System.out.println("Spend: " + moneySpend);
		System.out.println("Budget Left: " + (budget - moneySpend));
	}
}

public class FamilyBudgetAnnotation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while (testCases > 0) {
			String role = in.next();
			int spend = in.nextInt();
			try {
				Class annotatedClass = FamilyMember.class;
				Method[] methods = annotatedClass.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(FamilyBudget.class)) {
						FamilyBudget family = method.getAnnotation(FamilyBudget.class);
						String userRole = family.userRole();
						int budgetLimit = family.budgetLimit();// ~~Complete this line~~;
						if (userRole.equals(role)) {
							if (budgetLimit >= spend) {
								method.invoke(FamilyMember.class.newInstance(), budgetLimit, spend);
							} else {
								System.out.println("Budget Limit Over");
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			testCases--;
		}
	}
}
