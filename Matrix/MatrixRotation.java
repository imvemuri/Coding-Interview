package Matrix;

public class MatrixRotation {

	// Matrix rotation by 90 degrees clock wise
	// watch out for corner elements. For every column only three elements needs to be rotated.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'a','b','c','d'},{'e','1','2','f'},{'g','3','4','h'},{'i','k','l','m'}};
		MatrixRotation mr = new MatrixRotation();
		mr.print(matrix);
		System.out.println("After");
		mr.rotate(matrix);
	}
	
	public void rotate(char[][] matrix){
		int dimension = 4;
		for(int layer = 0 ; layer < 2 ; layer++) {
			int max_ele = dimension-1-layer;
			for(int col =  layer; col < max_ele ; col++) {
				char temp = matrix[layer][col];
				
				matrix[layer][col] = matrix[3-col][layer];
				
				matrix[3-col][layer] = matrix[3-layer][3-col];
				
				matrix[3-layer][3-col] = matrix[col][3-layer];
				
				matrix[col][3-layer] = temp;
				//break;
			}
		}
		print(matrix);
	}
	
	public void print(char[][] matrix){
		for(int i = 0 ; i<4;i++) {
			for(int j=0; j<4;j++) {
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
	


}
