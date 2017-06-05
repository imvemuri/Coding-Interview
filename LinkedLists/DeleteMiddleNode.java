package LinkedLists;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8};
		Node head = createLinkedList(arr);
		DeleteMiddleNode DM = new DeleteMiddleNode();
		DM.deleteMiddle(head).print();
	}
	
	public Node deleteMiddle(Node head){
		Node slow = head;
		Node prev = null;
		Node fastPointer = head;
		while(fastPointer != null){
			if(fastPointer.next != null){
				fastPointer = fastPointer.next.next;
				prev = slow;
				slow = slow.next;
			} else
				fastPointer = null;
		}
		prev.next = slow.next;
		return head;
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
