package LinkedLists;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList RLL = new ReverseLinkedList();
		int[] arr = {1,2,3,4,5};
		Node head = RLL.createLinkedList(arr);
		//RLL.reverseList(head, null,null).print();
		RLL.reverseList_iter(head).print();;

	}
	public Node reverseList_iter(Node curr){
		Node prev = null;
		while(curr != null){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
//	public Node reverseList_iter2(Node curr){
//		Node prev = null;
//		while(curr != null){
//			curr = (int)curr^curr.next^prev^(curr.next = prev)^(prev = curr);
//		}
//		return prev;
//	}
	
	
	public Node reverseList(Node curr, Node prev, Node newHead){
		if( curr.next == null){
			curr.next = prev;
			newHead = curr;
			return newHead;
		}
		Node temp = curr.next;
		curr.next = prev;
		return reverseList(temp,curr,newHead);
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
