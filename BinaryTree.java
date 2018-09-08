
public class BinaryTree {
	
	static void completeBinaryTree(Node node,int level){
		level--;
		if(level == 0){
			return;
		}
		node.left = new Node(node.key*2+1,(char)(node.key*2+1+'A'));
		node.right =new Node(node.key*2+2,(char)(node.key*2+2+'A'));
		completeBinaryTree(node.left, level);
		completeBinaryTree(node.right, level);
	}
	
	static Object findObj(Node tree,Object data){
		 
		if(tree.data == data){
			System.out.println(tree.key);
			return tree.key;
		}
		
		 if(tree.left == null || tree.right == null){
				System.out.println("Does not exist");
				return -1;
		}
			
			System.out.println(".");
			return null;
	}

	public static void main(String[] args) {
		
		Node tree = new Node(0,'A');
		completeBinaryTree(tree, 4);
		
		System.out.println(findObj(tree, 'C'));
	}

}

class Node{
	
	int key;
	Object data;
	Node left,right;
	public Node(int key,Object data) {
		this.key = key;
		this.data = data;
		left = right = null;
	}
	
}
