package StacksQueue;

import java.util.LinkedList;

public class StackUsingQueue {
	
	LinkedList<Integer> Q = new LinkedList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackUsingQueue sq = new StackUsingQueue();
		//sq.push(2);
		//sq.push(3);
		//sq.push(5);
		sq.pop();
		//sq.push(7);
		sq.pop();
		sq.push(4);
		sq.pop();
		sq.pop();
	}
	
	public void push(int x){
		Q.add(x);
		int size = Q.size();
		while(size > 1) {
			Q.add(Q.removeFirst());
			size--;
		}
	}
	
	public int pop(){
		if(Q.size() > 0 ) {
			int elem = Q.remove();
			System.out.println(elem);
			return elem;
		}
		return -1;
	}


}
