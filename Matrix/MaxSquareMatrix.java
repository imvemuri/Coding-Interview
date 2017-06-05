package Matrix;

public class MaxSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		
		MaxSquareMatrix MSM = new MaxSquareMatrix();
		MSM.MaxMatrix(m);
	}
	
	public int MaxMatrix(int[][] m){
		int[][] result = new int[m.length][m[0].length];
		int max = 0;
		for(int i = 0 ; i < m.length ; i++){
			for(int j = 0 ; j < m[0].length ; j++){
				if(m[i][j] == 0)
					result[i][j] = 0;
				else 
					result[i][j] = 1+getMin(result,i,j);
				max = Math.max(max, result[i][j]);
			}
		}
		System.out.println(max);
		return max;
	}
	
	public int getMin(int[][] m,int row,int col){
		if( row < 1 || col < 1 || col >= m[0].length || row >= m.length)
			return 0;
		return Math.min(m[row-1][col], Math.min(m[row][col-1], m[row-1][col-1]));
	}

}
