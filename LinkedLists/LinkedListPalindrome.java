package LinkedLists;

public class LinkedListPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,4,3,2,1};
		Node head = createLinkedList(arr);
		LinkedListPalindrome LLP = new LinkedListPalindrome();
		//LLP.getMiddle(head, 8).print();
		System.out.println(LLP.palindrome(LLP.new Left(head),head));
	}
	
	public Node getMiddle(Node node, int length){
		if(length == 0 || length == 1)
			return node;
		return getMiddle(node.next,length-2);
	}
	class Left{
		Node node;
		public Left(Node node){
			this.node = node; 
		}
	}
	
	public boolean palindrome(Left node, Node right){
		if(right == null)
			return true;
		boolean isPal = palindrome(node,right.next);
		if(!isPal)
			return false;
		boolean isPal1 = (node.node.data == right.data);
		if(isPal1)
			node.node = node.node.next;
		return isPal1;
	}
	
	public static Node createLinkedList(int[] arr){
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
