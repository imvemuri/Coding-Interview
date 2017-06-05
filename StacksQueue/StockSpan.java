package StacksQueue;

import utils.Utils;

// The span Si of the stock’s price on a given day i is defined as the maximum number of CONSECUTIVE days 
// just before the given day, for which the price of the stock on the current day is less than or equal to 
// its price on the given day.

public class StockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stock = {100,65,60,70,80,75,85};
		int[] sum = new int[stock.length];
		calculateSpan(stock,sum);
		Utils.print(sum);
	}
	
	static void calculateSpan(int price[], int S[]) {
	   S[0] = 1;
	   for(int i=1;i<price.length;i++){
	       int sum = 1;
	       int j = i - 1;
	       while(j>=0) {
	           if(price[j]<=price[i]){
	               sum = sum + S[j];
	               j = j - S[j];
	           }
	           else
	               break;
	       }
	       S[i] = sum;
	   }
	}

}
