package LinkedLists;

public class Node {
	
	Node next = null;
	int data;
	
	public Node(int d){
		this.data = d;
	}
	
	
	void addLast(int d){
		
		Node node = new Node(d);
		Node cur = this;
		while(cur.next!=null){
			cur = cur.next;
		}
		cur.next = node;
	}
	
	void add(int d){
		addLast(d);
	}
    void addLast(Node d){
		
		Node cur = this;
		while(cur.next!=null){
			cur = cur.next;
		}
		cur.next = d;
	}
	void add(Node d){
		addLast(d);
	}
	
	void print(){
		Node node = this;
		while(node != null) {
			System.out.print(node.data+"->");
			node = node.next;
		}
	}

}
