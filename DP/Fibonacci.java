package DP;

// 5 ways of getting fibonacci series.
public class Fibonacci {

	/*
	 * Fib(k+1) = First element of A^n-1 matrix where A = {{1,1},{1,0}}
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fibonacci fib = new Fibonacci();
//		/fib.linearTimeConstSpace(8);
		fib.MatrixExpoLogn(4);

	}
	
	// Simple and efficient
	public void linearTimeConstSpace(int n){
		int first = 0;
		int second = 1;
		int result = 0;
		for(int num = 2;num<n;num++){
			result = first+second;
			first = second;
			second = result;
		}
		System.out.println("Result:"+result);
	}
	
	// Using the eigen values
	public void MatrixExpoLin(int n){
		int f[][] = {{1,1},{1,0}};
		int M[][] = {{1,1},{1,0}};
		for(int i = 2;i<n;i++){
			int first  =  f[0][0]*M[0][0] + f[0][1]*M[1][0];
			int second =  f[0][0]*M[0][1] + f[0][1]*M[1][1];
			int third  =  f[1][0]*M[0][0] + f[1][1]*M[1][0];
			int fourth =  f[1][0]*M[0][1] + f[1][1]*M[1][1];
			f[0][0] = first;
			f[0][1] = second;
			f[1][0] = third;
			f[1][1] = fourth;
		}
		System.out.println("Result:"+f[0][0]);
	}
	
	public void MatrixExpoLogn(int n){
		int f[][] = {{1,1},{1,0}};
		power(f,n);
		System.out.println(f[0][0]);
	}
	
	public void power(int[][] f,int n){
		int M[][] = {{1,1},{1,0}};
		if(n == 0 || n ==1)
			return;
		power(f,n/2);
		multiply(f,f);
		if(n%2 == 1)
			multiply(f,M);
	}

	void multiply(int f[][],int M[][]){
		int first  =  f[0][0]*M[0][0] + f[0][1]*M[1][0];
		int second =  f[0][0]*M[0][1] + f[0][1]*M[1][1];
		int third  =  f[1][0]*M[0][0] + f[1][1]*M[1][0];
		int fourth =  f[1][0]*M[0][1] + f[1][1]*M[1][1];
		f[0][0] = first;
		f[0][1] = second;
		f[1][0] = third;
		f[1][1] = fourth;
	}



}
