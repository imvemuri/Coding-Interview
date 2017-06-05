package StacksQueue;
import java.util.*;
public class ReverseStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		ReverseStack reverse = new ReverseStack();
		System.out.println("BEFORE: "+st);
		reverse.reverse(st);
		System.out.println("AFTER:  "+st);
	}
	
	public void reverse(Stack<Integer> st){
		if(st.isEmpty())
			return;
		else {
			int ele = getBottom(st);
			reverse(st);
			st.push(ele);
		}
	}
	
	public int getBottom(Stack<Integer> stack){
		int bottom = 0;
		if(stack.size() == 1)
			return stack.pop();
		else {
			int ele = stack.pop();
			bottom = getBottom(stack);
			stack.push(ele);
		}
		return bottom;
	}
}
