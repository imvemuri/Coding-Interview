package LinkedLists;

public class ReverseKGroup {

	public int SIZE  = 3;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8};
		ReverseKGroup K = new ReverseKGroup();
		Node head = createLinkedList(arr);
		head.print();
		K.reverseKGroup(head,5).print();
		K.reverseKGroup_Rec(head, 9).print();
		
	}
	
	public Node reverseKGroup_Rec(Node head,int count){
		Node curr = head;
		Node prev = null;
		while(curr != null && count-- > 0){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		if(curr != null)
			head.next = reverseKGroup_Rec(curr,SIZE);
		return prev;
	}
	
	public Node reverseKGroup(Node head,int size){
		int length = getLength(head);
		int groups = length / size;
		Node newCurr = null;
		Node newHead = returnKthNode(head,size);
		for(int group = 0 ; group < groups ; group++){
			if(group == 0)
				newCurr = reverseGroup(head,null,size);
			else
				newCurr = reverseGroup(newCurr.next,newCurr,size);
		}
		reverseGroup(newCurr.next,newCurr,length%size);
		return newHead;		
	}
	
	public Node returnKthNode(Node node,int count){
		while(count-- > 1)
			node = node.next;
		return node;
	}
	
	public Node reverseGroup(Node Ghead,Node prev,int size){
		Node prev2 = prev;
		Node curr = Ghead;
		while(size-- > 0){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		if(prev2 != null)
			prev2.next = prev;
		Ghead.next = curr;
		return Ghead;
	}
	/*public Node reverse(Node curr, int k){
		Node head = curr;
		Node prev = null;
		while(k-- > 0){
			Node temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		head.next = curr;
		return head;
	}*/
	
	public int getLength(Node node){
		if(node == null)
			return 0;
		return 1+getLength(node.next);
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
