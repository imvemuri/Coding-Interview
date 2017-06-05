package LinkedLists;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Palindrome pl = new Palindrome();
		int[] arr = {1,2,3,2,1};
		pl.createLinkedList(arr);
	}
	
	public Node createLinkedList(int[] arr){
		Node node = null ;
		for(int i : arr){
			if(node == null)
				node = new Node(i);
			else
				node.add(i);
		}
		return node;
	}

}
