package StacksQueue;

import java.util.Stack;

public class StackTst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(9);
		st.push(4);
		EmptyStck(st);
		System.out.println(st);
	}
	
	public static void EmptyStck(Stack<Integer> stack){
		if(stack.isEmpty())
			return;
		int elem = stack.pop();
		EmptyStck(stack);
		InsertAtBottom(stack,elem);
	}
	
	public static void InsertAtBottom(Stack<Integer> stack, int ele){
		if(stack.isEmpty()){
			stack.push(ele);
			return;
		}
		int elem = stack.pop();
		InsertAtBottom(stack,ele);
		stack.push(elem);
		
	}

}
