package StacksQueue;

import utils.Utils;

public class NextGreaterElement {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4, 5, 2, 25};
		NGT(arr);
	}

	public static void NGT(int[] arr){
		int[] result = new int[arr.length]; 
		result[arr.length-1] = -1;
		for(int i = arr.length-2 ; i >= 0 ; i--){
			int gtElement = -1;
			int j  = i+1;
			while( j < arr.length){
				if(arr[j] > arr[i]){
					gtElement = arr[j];
					break;
				} else
					j++;
			}			
			result[i] = gtElement;
		}
		Utils.print(result);
	}
}
