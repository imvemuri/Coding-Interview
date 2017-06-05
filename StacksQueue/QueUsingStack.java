package StacksQueue;

import java.util.Stack;

public class QueUsingStack {
	
	Stack<Integer> stack  = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueUsingStack STACK = new QueUsingStack();
		STACK.EnQ(3);
		STACK.EnQ(2);
		STACK.EnQ(1);
		STACK.Deq();
		STACK.EnQ(4);
		STACK.Deq();
		STACK.Deq();
		STACK.Deq();
	}

	public void EnQ(int x){
		Stack<Integer> dup  = new Stack<Integer>();
		int size = stack.size();
		while(size > 0){
			dup.push(stack.pop());
			size--;
		}
		stack.push(x);
		size = dup.size();
		while(size > 0){
			stack.push(dup.pop());
			size--;
		}

	}
	
	public int Deq(){
		if(!stack.isEmpty()) {
			int ele = stack.pop();
			System.out.println(ele);
			return ele;
		}
		return -1;
	}
}
