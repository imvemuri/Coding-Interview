package Matrix;

public class SearchInSortedMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { 
				{10, 12, 13, 14},
                {41, 45, 46, 47},
                {81, 82, 83, 84},
                {121, 124, 125, 126}
               };
		int target = 121;
		searchSorted(matrix,target);
		SearchInSorted(matrix,target);
	}
	
	public static void searchSorted(int[][] m, int target){
		int rows = m.length;
		int row = 0;
		int col = m[0].length - 1;
		while(row < rows && col >= 0){
			System.out.println("row:"+row);
			System.out.println("col:"+col);
			if(m[row][col] == target){
				System.out.println("FOUND");
				return;
			}
			if(m[row][col] > target)
				col--;
			else
				row++;
		}
		System.out.println("NOT FOUND");
		
	}
	public static void SearchInSorted(int[][] m, int target){
		int rows = m.length;
		int high = m[0].length - 1;
		int rowNum = 0;
		while(rowNum < rows){
			int pos = BinarySearch(m,rowNum,0,high,target);
			System.out.println(pos);
			if(pos == -1)
				break ;
			if(m[rowNum][pos] == target){
				System.out.println("FOUND");
				return;
			} 
			if(pos != -1){
				rowNum = rowNum+1;
				high = pos;
			}
		}
		System.out.println("N.FOUND");
	}
	
	public static int BinarySearch(int[][] M, int row, int low, int high, int target){
		int mid = (low+high)/2;
		System.out.println("mid:"+mid);
		System.out.println("ROW:"+row);
//		System.out.println("MID:"+M[row][mid]);
//		System.out.println("MID+1:"+M[row][mid+1]);
		if(mid == 0 && M[row][mid] > target)
			return -1;
		if(mid == high || M[row][mid] == target || (M[row][mid] < target && M[row][mid+1] > target))
			return mid;
		if( M[row][mid] <= target){
			return BinarySearch(M,row,mid+1,high,target);
		}else{
			return BinarySearch(M,row,low,mid-1,target);
		}
	}
}
