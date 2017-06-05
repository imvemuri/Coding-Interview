package LinkedLists;

public class AddLinkedLists {

	public static void main(String[] args) {
		
		AddLinkedLists al = new AddLinkedLists();
		// TODO Auto-generated method stub
		int[] arr1 = {9,5,2};
		int[] arr2 = {9,3,9};

		Node list1 = al.createLinkedList(arr1);
		Node list2 = al.createLinkedList(arr2);
		al.addList(list1, list2).print();;

	}
	
	public Node addList(Node l1, Node l2){
		
		Node result = null;
		int carry = 0;
		Node list1 = l1;
		Node list2 = l2;
		while(list1 != null && list2 != null){
			int data = list1.data + list2.data + carry;
			if(result == null){
				result = new Node(data%10);
				carry = data / 10;
				list1 = list1.next;
				list2 = list2.next;
			} else {
				carry = data / 10;
				result.add(new Node(data%10));
				list1 = list1.next;
				list2 = list2.next;
			}
		}
		while(list1 != null){
			int data = list1.data+carry ;
			Node temp = new Node(data%10) ;
			result.add(temp);
			carry = data / 10;
			list1 = list1.next;
		}
		while(list2 != null){
			int data = list2.data+carry ;
			Node temp = new Node(data%10) ;
			result.add(temp);
			carry = data / 10;
			list2 = list2.next;
		}
		if(carry > 0)
			result.add(new Node(carry));
		return result;
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
