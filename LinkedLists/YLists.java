package LinkedLists;

public class YLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		YLists Y = new YLists();
		int[] arr = {1,2,3,4,5,6,7};
		Node L1 = Y.createLinkedList(arr);
		int[] arr2 = {11,22};
		Node L2 = Y.createLinkedList(arr2);
		//L2.next.next = L1.next.next.next.next.next;
		L2.print();
		System.out.println();
		L1.print();
		System.out.println();
		System.out.println(Y.findInterSection1(L1, L2).data);
	}
	
	public Node findInterSection1(Node head1, Node head2){
		int l1 = getLength(head1);
		int l2 = getLength(head2);
		Node firstPointer = head1;
		Node secondPointer = head2;
		int count = l1-l2;
		while(count-- > 0){
			firstPointer = firstPointer.next;
		}
		while(secondPointer != null && firstPointer != null){
			if(secondPointer.data == firstPointer.data)
				return firstPointer;
			secondPointer = secondPointer.next;
			firstPointer = firstPointer.next;
		}
		return firstPointer;
	}
	
	public int getLength(Node node){
		if(node == null)
			return 0;
		return 1+getLength(node.next);
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
