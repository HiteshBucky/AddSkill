import java.util.*;

class MinStack {
	int top = -1;
	List<Integer> stack;
	int minElement = -1;

	/** initialize your data structure here. */
	public MinStack() {
		stack = new ArrayList<>();
	}

	public void push(int x) {
		//Stack is empty
		if (top == -1 ) {
			stack.add(x);
			minElement = x;
		} else { //Stack is not emepty
			if (x >= minElement)
				stack.add(x);
			else {
				stack.add(2 * x - minElement);
				minElement = x;
			}
		}
		top++;
	}

	public void pop() {
		int temp = stack.get(top);
		if (temp < minElement)
			minElement = 2 * minElement - temp;
		stack.remove(top);
		top--;
	}

	public int top() {
		return stack.get(top);
	}

	public int getMin() {
		return minElement;
	}
}

class Stack_Get_Min {
	public static void main(String[] args) {
		MinStack myStack = new MinStack();
		myStack.push(10);
		myStack.push(20);
		myStack.push(30);
		myStack.push(40);
		myStack.push(50);

		myStack.pop();
		myStack.pop();


		System.out.println(myStack.stack);
		System.out.println(myStack.getMin());
	}
}














class MinStack {

	Stack<Integer> mainStack;
	Stack<Integer> minimumStack;


	public MinStack() {
		mainStack = new Stack<>();
		minimumStack = new Stack<>();
	}

	public void push(int x) {
		mainStack.push(x);
		if (minimumStack.isEmpty() || x <= minimumStack.peek()) // If we encounter new minimum then push it into min stack
			minimumStack.push(x);
	}

	public void pop() {
		if (mainStack.pop().equals(minimumStack.peek())) //If the poped element of main stack is equals to mini then remove it from min
			minimumStack.pop();

	}

	public int top() {
		return mainStack.peek();
	}

	public int getMin() {
		return minimumStack.peek();
	}
}