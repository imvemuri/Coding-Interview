package DP;

public class SteppingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SteppingStairs ss = new SteppingStairs();
		System.out.println("Fibnoacci");
		System.out.println(ss.fib_steps(2));
		System.out.println("DP");
		System.out.println(ss.dp_steps(5));
		ss.steps_seq(4,"");

	}
	
	//Fibonacci 
	public int fib_steps(int n){
		if(n <= 1)
			return 1;
		return fib_steps(n-1)+fib_steps(n-2);
	}
	
	public void steps_seq(int n,String path){
		if(n == 0){
			System.out.println(path);
			return;
		}
		if(n == 1){
			System.out.println(path + 1);
			return;
		}
		steps_seq(n-1,path+"1-");
		steps_seq(n-2,path+"2-");
	}
	
	public int dp_steps(int n){
		int[] result = new int[n+1];
		result[0] = 0;
		result[1] = 1;
		for(int i = 2; i<n;i++)
			result[i] = result[i-1]+result[i-2];
		return result[n-1];
	}

}
