package DP;

// Taken from Cormen
public class LargestCommonSubseq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		LargestCommonSubseq LCS = new LargestCommonSubseq();
		System.out.println(LCS.longestSubSeq(s1.toCharArray(), s2.toCharArray()));
	}
	
	// If charcter match then LCS is substring of remaining characters.
	public int longestSubSeq(char[] s1, char[] s2){
		int l1 = s1.length;
		int l2 = s2.length;
		int[][] LCS = new int[l1+1][l2+1];
		for(int i = 1 ; i <= l1 ; i++){
			for(int j = 1; j <= l2 ; j++){
				if(s1[i-1] == s2[j-1]){
					LCS[i][j] = LCS[i-1][j-1]+1;
				} else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		printArr(LCS);
		printSeq(s1,s2,LCS);
		return LCS[l1][l2];
	}
	
	public void printSeq(char[] s1, char[] s2,int[][] c){
		int l1 = 6;
		int l2 = 7;
		int index = c[l1][l2];
		for(int i = l1 ; i >=1 ;){
			for(int j = l2 ; j >=1 && i>=1 && index >=1 ;){
				System.out.println("("+i+","+j+")");
				if(c[i-1][j] == c[i][j-1]){
					System.out.println(s1[i-1]);
					i--;
					j--;
					index--;
				}else{
					if(c[i-1][j] > c[i][j-1])
						i--;
					else
						j--;
				}
			}
		}
	}
	
	public void printArr(int[][] arr){
		int l1 = 6;
		int l2 = 7;
		for(int i = 1 ; i <= l1 ; i++){
			for(int j = 1 ; j <= l2 ; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println("\n");
		}
	}
	
	
}
