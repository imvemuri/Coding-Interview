package DP;

import utils.Utils;

public class MinimumJumpsEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		minJumps(arr);
	}
	
	public static  int minJumps(int[] arr){
		int result[] = new int[arr.length];
		System.out.println(arr.length);
		for(int i = arr.length - 2 ; i >=0 ; i--){
			if(arr[i] >= (arr.length - i-1))
				result[i] = 1;
			else {
				int start = i+1;
				int count = arr[i];
				int min = Integer.MAX_VALUE;
				while( start < arr.length - 1 && count > 0){
					if(min > result[start])
						min = result[start];
					start++;
					count--;
				}
				result[i] = min+1;
			}
		}
		Utils.print(result);
		System.out.println(result[0]);
		return result[0];
	}

}
