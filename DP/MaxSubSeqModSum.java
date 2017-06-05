package DP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MaxSubSeqModSum {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MaxSubSeqModSum mssms = new MaxSubSeqModSum();
		//mssms.bruteforce();
		//System.out.println(System.currentTimeMillis()-currtime);
		File file = new File("C:/Users/vemurI/Desktop/input01.txt");
        Scanner in = new Scanner(file);
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/vemurI/Desktop/out01.txt"));
        int test_cases   = in.nextInt();
        while(test_cases-- > 0){
        	int arr_size = in.nextInt();
            long mod = in.nextLong();
            long arr[] = new long[arr_size];
            for(int i = 0; i < arr_size; i++)
               arr[i] = in.nextLong();
            out.write(String.valueOf(mssms.prefix(arr,mod)));
            out.newLine();
            out.flush();
        }in.close();out.close();
	}
	
	public void print(prefx[] arr){
		for(int i = 0; i< arr.length ; i++)
			System.out.print(arr[i].getValue()+" ");
		System.out.println();
	}
	
	public long prefix(long[] arr,long mod){
	
		prefx[] prefix = new prefx[arr.length];
		prefx p = new prefx(0,arr[0]%mod);
		prefix[0] = p;
		long max = 0;
		for(int i = 1 ; i< arr.length ; i++){
			p = new prefx(i,(prefix[i-1].getValue()%mod+arr[i]%mod)%mod);
			prefix[i] = p;
			System.out.println(prefix[i]);
		}
		
		Arrays.sort(prefix);
		for(int i = 1; i< arr.length ; i++){
			if(prefix[i].getValue() > prefix[i-1].getValue() && prefix[i].getIndex() < prefix[i-1].getIndex()){
				//System.out.println(prefix[i].getValue() - prefix[i-1].getValue());
				max = (prefix[i-1].getValue() - prefix[i].getValue() + mod)%mod;
				//break;
			}
		}
		
		print(prefix);
		
		for(int i = 0; i< arr.length ; i++)
			max = Math.max(prefix[i].getValue(), max);
		System.out.println("Max:"+max);
		return max;
	}
	
	private class prefx implements Comparable<prefx>{
		
		private long index = 0;
		private long value = 0;
		
		private long getIndex(){
			return this.index;
		}
		
		private long getValue(){
			return this.value;
		} 
		
		public String toString(){
			return "Value:"+String.valueOf(this.value)+" and Index "+this.index;
		}
		public prefx(long index, long value){
			this.index = index;
			this.value = value;
		}
		
		
		@Override
		public int compareTo(prefx o) {
			// TODO Auto-generated method stub
			if(this.value > o.value)
				return 1;
			else if(this.value < o.value)
				return -1;
			else return 0;
		}
		
	}
	
	long max(long a,long b,long c){
		return Math.max(Math.max(a, b), c);
	}
	
	// To calculate subset of size n, we need to add next element to every subset(continuous) of n-1.
	// For an array of 5 there are 1-5 ele subset, 2-4 ele subsets, 3-3 ele subsets, 2-4 ele subsets, 5-1 ele subsets.
	// sub(size_subset,num_of_sub) and arr be the input.
	// arr = { 3,3,9,9,5} = sub(1,1) = {3}. sub(1,2) = {3}. sub(1,3) = {9}.sub(1,4) = {9}. sub(1,5) = {5} 
	// sub(2,1) = sub(1,1)+arr[2] ; sub(2,2) = sub(1,2)+arr[3] ; sub(2,3) = sub(1,3)+arr[4] ; sub(2,4) = sub(1,4)+arr[5] 
	public long dp(long[] arr,long mod){
		long[] level_arr_sum = new long[arr.length];
		long max_sum = 0;
		for(int level = 0 ; level < arr.length ; level++){
			if(level == 0){
				for(int i = 0 ; i<arr.length;i++)
					level_arr_sum[i]  = arr[i] % mod;
				max_sum = max(level_arr_sum);
			} else {
				int elem = 0;
				for(elem = 0 ; elem < arr.length-level ; elem++) 
					level_arr_sum[elem] = ( level_arr_sum[elem]%mod + arr[elem+level] % mod ) % mod;
				while(elem < arr.length){
					level_arr_sum[elem] = 0;
					elem++;
				}
				long level_sum = max(level_arr_sum);
				if(max_sum < level_sum)
					max_sum = level_sum;
			}
		}
		//System.out.println(max_sum);
		return max_sum;
	}
	
	public long max(long[] arr){
		long max = arr[0];
		for (int counter = 1; counter < arr.length; counter++){
		     if (arr[counter] > max) {
		    	 max = arr[counter];
		     }
		}
		return max;
	}
	
	public void bruteforce() throws Exception{
		
		File file = new File("C:/Users/vemurI/Desktop/input04.txt");
        Scanner in = new Scanner(file);
        BufferedWriter out = new BufferedWriter(new FileWriter("C:/Users/vemurI/Desktop/out02.txt"));
        int test_cases   = in.nextInt();
        while(test_cases > 0){
        	int arr_size = in.nextInt();
            long mod = in.nextLong();
            long arr[] = new long[arr_size];
            for(int i = 0; i < arr_size; i++)
                arr[i] = in.nextLong();
            long max_sum = 0;
            // Total subsets
		    for(int subset = 1; subset <= arr.length ; subset++){ 
		    	// Num of elements to be in subset eg : For subset of size 3, last 2 elements will be excluded 
			    for(int indx = 0; indx < arr.length - subset + 1 ; indx++){ 
                    int num_elements = subset;
                    int temp = indx;
                    long sum = 0;
                    // number of elements to be added
                    while(num_elements > 0){
                        sum+=arr[temp];
                        num_elements--;
                        temp++;
                        sum = sum % mod;
                    }
                    if(max_sum < sum)
                        max_sum = sum;
                    sum = 0;
                }
		     }
		     out.write(max_sum+"");
		     out.newLine();
		     out.flush();
             test_cases--;
        } in.close(); out.close();
	}
}
