package DP;

public class MinimumInsertionsPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abede";
		MinimumInsertionsPalindrome MIP = new MinimumInsertionsPalindrome();
		System.out.println(MIP.MinInsertions(s,0,s.length()-1));
		MIP.MinInsert(s);
	}
	
	public int MinInsertions(String s, int low, int end){
		if(low > end)
			return 0;
		if(low == end)
			return 0;
		if(s.charAt(low) == s.charAt(end))
			return MinInsertions(s,low+1,end-1);
		else
			return 1+Math.min(MinInsertions(s,low,end-1), MinInsertions(s,low+1,end));
	}
	
	public int MinInsert(String s){
		int[][] TAB = new int[s.length()][s.length()];
		for(int row = 0 ; row < s.length() ; row++)
				TAB[row][row] = 0; 
		
		for(int start = 0 ; start <= (s.length() - 2) ; start++){
			if(s.charAt(start) == s.charAt(start+1))
				TAB[start][start+1] = 0;
			else 
				TAB[start][start+1] = 1;
		}
		
		for(int len = 3 ; len <= s.length() ; len++){
			for(int start = 0 ; start <= (s.length() - len) ; start++){
				int end = start + len - 1;
				if(s.charAt(start) == s.charAt(end)){
					TAB[start][end] =  TAB[start+1][end-1];
				} else {
					TAB[start][end] =  Math.min(TAB[start][end-1],TAB[start+1][end])+1;
				}
			}
		}
		System.out.println(TAB[0][s.length()-1]);
		return TAB[0][s.length()-1];
	}

}
