package DP;

/*length   | 1   2   3   4   5   6   7   8  
  -------------------------------------------
  price    | 1   5   8   9  10  17  17  20 
 */
public class WoodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WoodCutting wc = new WoodCutting();
		int[] arr = {3,5,8,9,10,17,17,20};
		wc.cutRod(arr, 3);
	}
	
	
	public int woodCutter(int[] price,int cuts){
		int[] wc = new int[price.length+1];
		int max = Integer.MIN_VALUE;
		for(int i = 1 ; i <= cuts ; i++){
			for(int j = i ; j > 0 ; j--){
				max = Math.max(max,price[j-1]+wc[i-j]);
				wc[i] = max;
			}
		}
		System.out.println(max);
		return max;
	}
	
	 public int cutRod(int price[], int n){
        if (n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;
 
        // Recursively cut the rod in different pieces and
        // compare different configurations
        for (int i = 0; i<n; i++)
            max_val = Math.max(max_val, price[i] + cutRod(price, n-i-1));
 
        return max_val;
    }
}
