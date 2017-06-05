package StacksQueue;

import java.util.HashMap;
import java.util.Stack;

public class MatchingParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValid("[[))");
	}
	public static boolean isValid(String s) {
	        
	        if(s == null || s.length() == 1)
	            return false;
	        HashMap<Character,Character> open = new HashMap<Character,Character>();
	        open.put(')','(');
	        open.put('}','{');
	        open.put(']','[');
	        Stack<Character> stack = new Stack<Character>();
	        int start = 0;
	        while(start < s.length()){
	            char current = s.charAt(start);
	            if(!open.containsKey(current))
	                stack.push(current);
	            else {
	                if(stack.size() == 0 || open.get(current) != stack.pop())
	                    return false;
	            }
	            start++;
	        }
	        return (stack.size() == 0 ? true : false);
	    }
}
