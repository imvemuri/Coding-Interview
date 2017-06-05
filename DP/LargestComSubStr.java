package DP;

// Find the largest suffixes of all prefixes
// DP O(n*m) : Rec O(n2*m) . Can also be done through suffix tree
public class LargestComSubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestComSubStr lcs = new LargestComSubStr();
		lcs.substr_rec("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com");
		lcs.substr_dp("OldSite:GeeksforGeeks.org", "NewSite:GeeksQuiz.com");
	}
	
	public int substr_rec(String s1,String s2){
		int max = 0;
		int max_prefx = 0;
		int prev_max = 0;
		for(int pref_len = 1 ; pref_len <= s1.length() ; pref_len++){
			for(int j = 1 ; j <= s2.length() ; j++){
				if(s1.charAt(pref_len-1) == s2.charAt(j-1)){
					max = Math.max(max,1+checkRemSufix(s1,s2,pref_len-1,j-1));
					if(prev_max < max){
						max_prefx = pref_len;
					}
					prev_max = max;
				}
			}
		}
		System.out.println(s1.substring(max_prefx - max,max_prefx));
		System.out.println("Rec: "+max);
		return max;
	}
	
	public int checkRemSufix(String s1,String s2,int i,int j){
		if(i <= 0 || j <= 0)
			return 0;
		if(s1.charAt(i-1) == s2.charAt(j-1))
			return 1+checkRemSufix(s1,s2,i-1,j-1);
		else
			return 0;
	}
	
	public int substr_dp(String s1,String s2){
		int LCS[][] = new int[s1.length()+1][s2.length()+1];
		int result = 0;
		
		for(int row = 1 ; row <= s1.length() ; row++){
			for(int col = 1 ; col <= s2.length() ; col++){
				if(s1.charAt(row-1) == s2.charAt(col-1)){
					LCS[row][col] = 1+LCS[row-1][col-1];
					result = Math.max(result, LCS[row][col]);
				}
			}
		}
		System.out.println("DP : "+result);
		return result;
	}
	
}
