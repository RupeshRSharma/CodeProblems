/**
 * 
 */
package main.java.problems;

import java.util.Stack;

/**
 * 1. Program to create a stack , 
 * add one more method to it getMin() : which gives the minimum of stack at given point in time but with time complexity O(1)
 * 
 * @author rupesh sharma
 *
 */
public class StackMinO1 {

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		StackImpl stack = new StackImpl();
		stack.push(11);
		stack.push(9);
		stack.push(3);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
		stack.push(5);
		stack.push(7);
		stack.push(3);
		stack.pop();
		System.out.println(stack.getMin());

	}

}

/**
 * Stack implementation - FILO/LIFO - First In Last Out/ Last In First Out
 *  - peek - Get the item at top of the stack
 *  - push - Push the item to top of the stack
 *  - pop - Remove the top item from the stack
 *  - getMin - Get the minimum item from the stack with complexity O(1)
 *
 */
class StackImpl{
	
	// Stack to store the items
	Stack<Integer> stack = new Stack<>();
	
	// Minimum value
	Integer min;
	
	/**
	 * Get the item at top of the stack
	 * 
	 * @return top element
	 */
	public Integer peek() {
		if(this.stack.isEmpty()) {
			return -1;
		}else {
			return this.stack.peek();
		}
	}
	
	/**
	 * Push the item to top of the stack
	 * 
	 * @return the item added
	 */
	public Integer push(Integer item) {
		if(this.stack.isEmpty()) {
			this.min = item;
			this.stack.push(item);		
		}else {
			if(this.min > item) {
				this.stack.push(2*item - this.min);
				this.min = item;
			}else {
				this.stack.push(item);	
			}
		}
		
		return item;	
	}
	
	/**
	 * Remove the top item from the stack
	 * 
	 * @return item removed from the stack
	 */
	public Integer pop() {
		if(this.stack.isEmpty()) {
			return -1;	
		}
		
		Integer item = this.stack.pop();
		
		if(this.min > item) {
			this.min = 2*this.min - item;
		}
		
		return item;	
	}
	
	/**
	 * Get the minimum item from the stack with complexity O(1)
	 * 
	 * @return minimum item, -1 if stack is empty
	 */
	public Integer getMin() {
		if(this.stack.isEmpty()) {
			return -1;
		}else {
			return this.min;
		}
	}
	
}