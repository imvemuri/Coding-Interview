package DP;

import utils.Utils;

public class MinPathMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MinPathMatrix MPM = new MinPathMatrix();
		int cost[][] = { 
				{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} 
                };
		System.out.println(MPM.minPath(cost));

	}
	
	public int minPath(int[][] path){
		int cost[][] = new int[path.length][path.length];
		int col = 1;
		int row = 1;
		cost[0][0] = path[0][0];
		for (col = 1; col < path.length; col++)
	        cost[col][0] = cost[col-1][0] + path[col][0];
	 
		for (row = 1; row < path.length; row++)
	        cost[0][row] = cost[0][row-1] + path[0][row];
	 
		for(row = 2 ; row <= path.length ; row++)
			for(col = 2 ; col <= path.length ; col++){
					cost[row-1][col-1] = path[row-1][col-1] + Math.min(cost[row-1][col-2], Math.min(cost[row-2][col-2], cost[row-2][col-1]));
			}
		Utils.print(cost);
		return cost[path.length-1][path.length-1];
	}

}
