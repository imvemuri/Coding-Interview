package OrderStatistics;

import java.util.PriorityQueue;

public class KLargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		KLargest(arr,k);
	}
	
	public static void KLargest(int[] arr, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int index = 0;
		for(index = 0 ; index < k ; index++)
			pq.add(arr[index]);
		while(index < arr.length){
			if(pq.peek() < arr[index]){
				pq.poll();
				pq.add(arr[index]);
			}
			index++;
		}
		while(!pq.isEmpty())
			System.out.println(pq.poll());

	}

}
