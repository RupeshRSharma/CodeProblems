package main.java.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrate how hashcode and equals works in Java with test using HashMap.
 * 
 * @author rupesh sharma
 *
 */
public class Employee {

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	private String name;

	private int salary;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return 20;

	}

	@Override
	public boolean equals(Object o) { 
		
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee simpson = (Employee) o;
        return name.equals(simpson.name);
	}

	public static void main(String[] args) {

		Employee e1 = new Employee("Emp1", 6000);
		Employee e2 = new Employee("Emp2", 20);

		Map<Employee, Integer> map = new HashMap<>();
		map.put(e1, 100);
		map.put(e2, 200);

		System.out.println(map.get(e1));
		
		System.out.println(filter(Arrays.asList(e1, e2)).size());

		Float f1 = new Float("3.0");
		int x = f1.intValue();
		byte b = f1.byteValue();
		double d = f1.doubleValue();
		System.out.println(x + b + d);

		int mask = 0x000F;
		int value = 0x2222;

		System.out.println(mask & value);

	}

	private static List<Employee> filter(List<Employee> list) {
		return list.stream().distinct().filter(emp -> emp.salary > 5000 && emp.salary < 10000)
				.sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());

	}

}
