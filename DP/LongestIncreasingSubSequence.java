package DP;

import utils.Utils;

public class LongestIncreasingSubSequence {
	
	public int LongIncrSeq(int[] arr){
		int dp[] = new int[arr.length];
		dp[arr.length-1] = 1;
		for(int indx = arr.length-2 ; indx >= 0 ; indx--){
			dp[indx] = 1;
			for(int j = indx+1 ; j < arr.length ; j++){
				if(arr[indx] < arr[j]){
					dp[indx] = Math.max(dp[indx], 1+dp[j]);
				}
			}
		}
		Utils.print(dp);
		return getMax(dp);
	}
	
	public int getMax(int[] arr){
		int max = 0;
		for(int i = 0 ; i< arr.length ; i++)
			max = Math.max(max, arr[i]);
		
		return max;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingSubSequence LIS = new LongestIncreasingSubSequence();
		int[] arr = {8,3,5,2,4,9,7,1};
		System.out.println(LIS.LongIncrSeq(arr));
	}

}
