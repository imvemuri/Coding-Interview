package StacksQueue;

import java.util.Stack;

public class SortStackRecursn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortStackRecursn ssr = new SortStackRecursn();
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(9);
		st.push(4);
		st.push(0);
		ssr.sort(st);
		System.out.println(st);
	}
	
	public void sort(Stack<Integer> stack){
		if(stack.isEmpty())
			return;
		int elem = stack.pop();
		sort(stack);
		CreateSortStack(stack,elem);
		
	}
	public void CreateSortStack(Stack<Integer> stack,int ele){
		if(stack.isEmpty() || stack.peek() <= ele){
			stack.push(ele);
			return;
		} else {
			int pop = stack.pop();
			CreateSortStack(stack,ele);
			stack.push(pop);
		}
	}

}
