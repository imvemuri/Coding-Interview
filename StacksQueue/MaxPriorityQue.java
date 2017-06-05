package StacksQueue;

import utils.Utils;

public class MaxPriorityQue {

	int HEAP_SIZE = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxPriorityQue HS = new MaxPriorityQue();
		int[] arr = {10,2,4,3,5,6,79};
		HS.BUILD_MAX_HEAP(arr);
		Utils.print(arr);
		HS.HEAP_INCREASE_KEY(arr,4,91);
		Utils.print(arr);
	}
	
	
	public void HEAP_INCREASE_KEY(int[] heap,int index,int byValue){
		heap[index-1] = byValue;
		while(index > 1 && heap[PARENT(index)-1] < heap[index-1]){
			exchange(heap,PARENT(index),index);
			index = PARENT(index);
		}
	}
		
	public int PARENT(int child){
		return child/2;
	}
	public int LEFT(int parent){
		return 2*parent;
	}
	public int RIGHT(int parent){
		return 2*parent+1;
	}
	
	public void exchange(int[] arr,int srcIndx,int destIndx){
		int temp = arr[srcIndx-1];
		arr[srcIndx-1] = arr[destIndx-1];
		arr[destIndx-1] = temp;
	}
	public int extractMax(int[] arr){
		int max = arr[0];
		arr[0] = arr[HEAP_SIZE-1];
		arr[HEAP_SIZE-1] = max;
		HEAP_SIZE = HEAP_SIZE-1;
		MAX_HEAPIFY(arr,HEAP_SIZE,0);
		System.out.println(max);
		return max;
	}
	
	public void heapSort(int[] arr){
		BUILD_MAX_HEAP(arr);
		for(int i = arr.length ; i >= 1 ; i--){
			int temp = arr[0];
			arr[0] = arr[i-1];
			arr[i-1] = temp;
			MAX_HEAPIFY(arr,i-1,0);
		}
	}
	
	public void BUILD_MAX_HEAP(int[] arr){
		HEAP_SIZE = arr.length;
		for(int i = arr.length/2 ; i >= 1 ; i--)
			MAX_HEAPIFY(arr,HEAP_SIZE,i);
	}
	public void MAX_HEAPIFY(int[] arr,int size,int node){
		System.out.println("node:"+node);
		int left = node*2;
		int right = left+1;
		int largest = node;
		if(left <= size && arr[left-1] > arr[node-1])
			largest = left;
		if(right <= size && arr[right-1] > arr[largest-1]){
			largest = right;
		}
		if(largest != node){
			int temp = arr[node-1];
			arr[node-1] = arr[largest-1];
			arr[largest-1] = temp;
			MAX_HEAPIFY(arr,size,largest);
		}
	}

}
