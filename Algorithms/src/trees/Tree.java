/*package trees;

public class Tree<T extends Number> {

	private Tree<T> leftChild;
	private Tree<T> rightChild;
	private T info;

	Tree() {
		
	}

	Tree(T info, Tree<T> leftChild, Tree<T> rightChild) {
		this.info = info;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return info
			+ "\t" + leftChild
			+ "\t" + rightChild;
	}

	public <T extends Number> Tree<T> createTreeNode(T info) {
		Tree<T> node = new Tree<T>();
		node.info = info;
		node.leftChild = null;
		node.rightChild = null;
		return node;
	}

	public <T extends Number> Tree<T> insert(Tree<?> root, T info) {
		Tree<T> node = createTreeNode(info);
		if (root == null) {
			return node;
		}

		if (root.info == info) {
			System.out.println("Redundant value.");
			return root;
		}

		if(root.info > info) {
			root.rightChild = insert(root.rightChild, info);
		} else {
			root.leftChild = insert(root.leftChild, info);
		}
		return root;
	}
}
*/