public class BST {

	private class Node {
		private int val;
		private Node left, right;
		private int size;

		public Node(int size, int val) {
			this.val = val;
			this.size = size;
			this.left = null;
			this.right = null;
		}

	}

	private Node root;

	// constructor
	public BST() {
	}

	// inserts a value to the tree
	public void put(int val) {

		root = put(root, val);

	}

	private Node put(Node x, int val) {
		if (x == null) {
			return new Node(1, val);
		}

		if (val > x.val) {
			x.right = put(x.right, val);
		} else if (x.val == val) {
			x.val = val;
		} else if (val < x.val) {
			x.left = put(x.left, val);
		}

		// x.size = 1+size(x.left) + size(x.right);

		return x;
	}

	public void put(int[] a) {
		for (int i = 0; i < a.length; i++) {
			this.put(a[i]);
		}
	}

	// finds the size of the tree
	private int size(Node x) {

		if (x == null) {
			return 0;
		}

		else {
			return x.size;
		}

	}

	// searches the tree for an entered value MUST ADD RECURSION
	public int search(int key) {
		int a[] = sortedTree();
		int j = 0;
		int hold = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i] == key) {
				hold = key;
				break;
			}
			j++;
			
		}
		if(hold != 0) {
			return hold;
		}
		else {
			System.out.println("Value Not Found");
			return 0;
		}
		/*int y = searchRecursive(x, key);

		if (y == key) {
			return key;
		} else {
			System.out.println("Value not Found");
			return 0;
		}
		*/

	}

	public int searchRecursive(Node x, int key) {

		if (x == null) {
			return 0;

		}
		if (x.val == key) {
			x = null;
			return key;
		}
		searchRecursive(x.left, key);
		searchRecursive(x.right, key);

		return 0;

	}

	/*
	 * public int get(int key) { Node x = root; int cmp = 0; while(x!=null) {
	 * 
	 * 
	 * if(key>val) { cmp = 1; } else if(key == val) { cmp = 0; } else if (key<val) {
	 * cmp = -1; } }
	 * 
	 * if (cmp < 0) { x = x.left; } else if (cmp >0) { x = x.right; } else if (cmp
	 * == 0) { return x.val; } return 0; }
	 */

	// determines the size
	public int returnSize() {
		/*
		 * Node x = root; Node y = root.left; int iter1 = 0; int iter2 = 0;
		 * 
		 * while (x!= null) { x = x.right; iter1++; } while(y != null) { iter2++; y =
		 * y.left; }
		 */
		int numNode = trueReturn(root);
		return numNode;
	}

	public int trueReturn(Node x) {
		int count = 1;
		if (x == null)
			return 1;
		if (x.left != null) {
			count += trueReturn(x.left);
		}
		if (x.right != null) {
			count += trueReturn(x.right);
		}
		return count;

	}

	// sorts the tree into an array
	public int[] sortedTree() {
		int treeLength = returnSize();
		int sorted[] = new int[treeLength];
		sorted = sortedRecursive(root, sorted);
		

		for (int k = 0; k < treeLength; k++) {
			System.out.println(sorted[k]);
		}
		System.out.println("above is the unsorted");
		mergeSort(sorted, 0, treeLength - 1);

		for (int k = 0; k < treeLength; k++) {
			System.out.println(sorted[k]);
		}

		return sorted;

	}

	public int[] sortedRecursive(Node x, int a[]) {
		countarray(x, a, 0);
		return a;

	}

	public int countarray(Node x, int a[], int offset) {
		a[offset] = x.val;
		System.out.println(x.val);
		System.out.println(offset);
		if (x.left != null) {
			offset = countarray(x.left, a, offset + 1);
		}
		if (x.right != null) {
			offset = countarray(x.right, a, offset + 1);
		}
		return offset;
	}

	// creates a new BST based on the sorted array
	public BST balanceTreeOne() {

		BST balancedTree = new BST();
		int a[] = sortedTree();
		balancedTree.put(this.sortedTree());

		return balancedTree;
	}

	// rotates a node to the right
	public Node rotateRight(Node h) {
		if (h.left == null) {
			return h;
		} else {
			Node x = h.left;
			h.left = x.right;
			x.right = h;

			// if(h==root) {
			// root = x;
			// }
			return x;
		}
	}

	// rotates a node to the left
	public Node rotateLeft(Node h) {
		if (h.right == null) {
			return h;
		} else {
			Node x = h.right;
			h.right = x.left;
			x.left = h;
			return x;
		}
	}

	// does the leg work of getting the tree into a right-leaning list
	public Node transformBase(Node x) {
		// Node iter = x;
		if (x == null) {
			return x;
		}

		while (x.left != null) {
		
			x = rotateRight(x);
			
		}

		if (x.right != null) {
			x.right = transformBase(x.right);
		}

		return x;

	}

	// calls transformBase recursively
	public void transformToList() {
		transformBase(root);
		Node x = root;

		while (x != null) {

			x = x.right;
		}
	}

	// balances the tree with no extra space used
	public void balanceTreeTwo() {

		transformToList();


		int N = returnSize();
		double log2 = Math.log(N) / Math.log(2);
		double pow = Math.floor(log2);
		double subpart = (int) Math.pow(2, pow);
		double M = (N + 1) - subpart;
		// use the floor function for the log2N

		Node iter = root;
		Node iter2 = null;
		Node iter3 = iter.right.right;
		for (int i = 0; i < M; i++) {
			System.out.println("test1");
			System.out.println(i);
			iter2.right = rotateLeft(iter);
			iter2 = iter2.right;
			iter = iter3;
			if(iter.right != null && iter.right.right !=null) {
				iter = iter.right.right;
			}
		}
		
		iter = root;
		iter2 = null;
		iter3 = iter.right.right;
		
		double K = Math.floor(pow - 1);

		// new stuff
		while(K > 1) {
			iter2.right = rotateLeft(iter);
			iter2 = iter2.right;
			iter = iter3;
			
			if(iter.right != null && iter.right.right !=null) {
				iter = iter.right.right;
			}
			K--;	
		}
		if (K == 1) {
			rotateLeft(root);
			return;
		}

	}

	// standard recursive mergesort to sort the array
	private void merge(int a[], int first, int mid, int last) {

		int length = returnSize();

		int temparray[] = new int[length];

		int first1 = first;
		int last1 = mid;
		int first2 = mid + 1;
		int last2 = last;
		int index = first1;
		while (first1 <= last1 && first2 <= last2) {
			if (a[first1] <= a[first2]) {
				temparray[index] = a[first1];
				first1++;
			} else {
				temparray[index] = a[first2];
				first2++;
			}
			index++;
		}
		while (first1 <= last1) {
			temparray[index] = a[first1];
			first1++;
			index++;
		}
		while (first2 <= last2) {
			temparray[index] = a[first2];
			first2++;
			index++;
		}
		for (index = first; index <= last; index++) {
			a[index] = temparray[index];
		}
	}

	public void mergeSort(int a[], int first, int last) {
		if (first < last) {
			int mid = first + (last - first) / 2;
			mergeSort(a, first, mid);
			mergeSort(a, mid + 1, last);
			merge(a, first, mid, last);
		}
	}

}

/*
 * int cmp = 0;
 * 
 * if(key>val) { cmp = 1; } else if(key == val) { cmp = 0; } else if (key<val) {
 * cmp = -1; }
 */