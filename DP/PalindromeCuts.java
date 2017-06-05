package DP;

public class PalindromeCuts {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeCuts pp = new PalindromeCuts();
		pp.minPalindPart("cabababc");
		pp.minPalindromePart("cabababc");
	}
	
	public void minPalindromePart(String src){
		int[][] cost = new int[src.length()+1][src.length()+1];
		boolean[][] ispalind = new boolean[src.length()+1][src.length()+1];
		for(int i = 1 ; i <= src.length() ; i++)
			ispalind[i][i] = true;
		
		for(int len = 2 ; len <= src.length() ; len++){
			for(int startpoint = 1 ; startpoint <= src.length()-len+1; startpoint++){
				int endpoint = startpoint+len-1;
				cost[startpoint][endpoint] = len;
				if(src.charAt(startpoint-1) == src.charAt(endpoint-1) && (len <= 3 || ispalind[startpoint+1][endpoint-1])){
						cost[startpoint][endpoint] = 0;
						ispalind[startpoint][endpoint] = true;
				} else {
					for(int splitpoint = startpoint ; splitpoint < endpoint ; splitpoint++){
						cost[startpoint][endpoint] = Math.min(cost[startpoint][endpoint], 
								cost[startpoint][splitpoint] + cost[splitpoint+1][endpoint]+1);
					}
				}
			}
		}
		System.out.println(cost[1][src.length()]);
	}
	
	public void minPalindPart(String src){
		
		int[][] minPart = new int[src.length()+1][src.length()+1];
		int[][] part = new int[src.length()+1][src.length()+1];
		
		for(int i = 1 ; i < src.length() ; i++)
			minPart[i][i] = 0;
		
		for(int len = 2 ; len <= src.length() ; len++){
			for(int startpoint = 1 ; startpoint <= src.length() - len+1 ; startpoint++){
				int endpoint = startpoint+len-1;
				minPart[startpoint][endpoint] = Integer.MAX_VALUE;
				if(isPalindrome(src.substring(startpoint-1, endpoint)))
					minPart[startpoint][endpoint] = 0; 
				else {
					for(int splitpoint = startpoint ; splitpoint < endpoint ; splitpoint++){
						int cur_cost = minPart[startpoint][splitpoint]+minPart[splitpoint+1][endpoint]+1;
						if(cur_cost < minPart[startpoint][endpoint]){
							minPart[startpoint][endpoint] = cur_cost;
							part[startpoint][endpoint] = splitpoint;
						}
					}
				}
			}
		}
		//print(part);
		System.out.println(minPart[1][src.length()]);
	}
	
	public void print(int[][] cost){
		for(int row = 0 ; row <= 5 ; row++){
			for(int col = 0 ; col <= 5; col++){
				System.out.print(cost[row][col]+" ");
			}	
			System.out.println();
		}
	}
	
	public boolean isPalindrome(String str){
		return isPalindrome(str.toCharArray());
	}

	public boolean isPalindrome(char[] str){
		if(str.length <= 1)
			return true;
		
		int low = 0;
		int high = str.length - 1;
		
		while(low < high){
			if(str[low] == str[high]){
				low++;
				high--;
			}
			else return false;
		}
		return true;
	}

}
