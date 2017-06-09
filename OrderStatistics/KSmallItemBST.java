package OrderStatistics;

import trees.and.graphs.Node;
import trees.and.graphs.TreeUtil;

// There are couple of methods.
// Using inorder traversal
// Using total node count, left node counts.

public class KSmallItemBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KSmallItemBST kbst = new KSmallItemBST();
		kbst.KthNode();
	}
	public void KthNode(){
		Node root = TreeUtil.createBinarySearchTree();
		ComputeStats(root);
		for(int i = 1 ; i <= root.totalNodes ; i++) {
			int[] count ={0};
			System.out.println("Order:"+i);
			inOrder(root,count,i);
		}
	}
	// Stores the count at every node in the occurence of their in order traversal.
	public void inOrder(Node node, int[] count,int target){
		if(node.isLeaf()){
			count[0] = count[0] + 1;
			if(count[0] == target)
				System.out.println(node);
			return;
		}
		inOrder(node.left,count,target);
		count[0] = count[0] + 1;
		if(count[0] == target) {
			System.out.println(node);
			return;
		}
		if(count[0] > target);
		else inOrder(node.right,count,target);
	}
	
	// This method computes total left nodes and right nodes at each node. 
	public Node ComputeStats(Node node){

		if(node == null)
			return null;

		Node left = ComputeStats(node.left);
		Node right = ComputeStats(node.right);
		if(left == null && right == null)
			node.totalNodes = 1;
		else if(left != null && right != null){
			node.leftNodes = left.totalNodes;
			node.rightNodes = right.totalNodes;
			node.totalNodes = left.totalNodes+right.totalNodes+1;
		} else if( left != null){
			node.leftNodes = left.totalNodes;
			node.rightNodes = 0;
			node.totalNodes = node.leftNodes+1;
		} else {
			node.leftNodes = 0;
			node.rightNodes = right.totalNodes;
			node.totalNodes = node.rightNodes+1;
		}
		return node;
	}
	// This uses totalnodes at each node and then it takes the path.
	public Node getKNode(Node node,int k){
		if(node.totalNodes < k)
			return null;
		if(node.leftNodes+1 == k)
			return node;
		else if(node.leftNodes+1 > k)
			return getKNode(node.left,k);
		else return getKNode(node.right, k-node.leftNodes-1);
	}

}
