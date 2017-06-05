package DP;

public class LongestPalindromeSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromeSubsequence LPS = new LongestPalindromeSubsequence();
		String source = "GEEKSFORGEEKS";
		System.out.println(LPS.LongestPalSubeq(source, 0, source.length()-1));
	}
	
	public int LongestPalSubeq(String source , int start, int end){
		if(start == end)
			return 1;
		if(start > end)
			return 0;
		if(source.charAt(start) == source.charAt(end))
			return 2+LongestPalSubeq(source,start+1,end-1);
		else return Math.max(LongestPalSubeq(source,start+1,end),LongestPalSubeq(source,start,end-1));
	}

}
