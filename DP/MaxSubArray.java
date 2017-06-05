package DP;

public class MaxSubArray {
	// Don't reset when previous sum is less than current element ex : 1, -2, 1, 4
	// Watch out for 8, -1, -1, 4 ( needs two variables to hold current sum and max sum)
	// Watch out for first element
	// 

	public static void main(String[] args) {
		MaxSubArray msb = new MaxSubArray();
		int a[] = { -2, 4,-2,-1, -3};
		msb.maxSum(a);
		msb.maxSub(a);

	}	
	

	public void maxSum(int[] a){
		int max_sum = 0;
		int max_element = a[0];
		for(int i = 0; i<a.length;i++){
            max_element = Math.max(a[i],max_element);
			if(a[i]+max_sum > max_sum){
                max_sum+=a[i];
            }
		}
        if(max_sum == 0)
            max_sum = max_element;
		System.out.println(max_sum);
	}
	
	public void maxSub(int[] a){
		int prev_sum = a[0];
		int max_sum_from_max_pointer = 0;
		int max_element = a[0];
		for(int i = 0; i<a.length;i++)         
			max_sum_from_max_pointer = Math.max(a[i],max_element);
		for(int i = 0; i<a.length;i++){            
			max_element = Math.max(a[i],max_element);
			prev_sum = Math.max(prev_sum+a[i], a[i]);
			if(prev_sum > max_sum_from_max_pointer) {
				max_sum_from_max_pointer = prev_sum;
			}
		}
		System.out.println(max_sum_from_max_pointer);
	}
	
}
