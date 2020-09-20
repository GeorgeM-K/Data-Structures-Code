
public class Problem3 {

	private Node sortedHead = null;
	private Node unsortedHead = null;
	
	private class Node{
		
		private int data;
		private Node next;
		
	}
	
	public boolean isEmpty() {
		return unsortedHead == null;
		
	
	}
	public void push (int data) {
		
		Node oldhead = unsortedHead;
		
		unsortedHead = new Node();
		
		unsortedHead.data = data;
		
		unsortedHead.next = oldhead;
		
		oldhead = sortedHead;
		
		sortedHead = new Node();
		
		sortedHead.data = data;
		
		sortedHead.next = oldhead;
	}
	
	
	public int peek() {
		 
		int data = unsortedHead.data;
		
		return data;
	}
	
	public int pop() {
		
		int data = sortedHead.data;
		
		sortedHead = sortedHead.next;
		
		
		if(data == unsortedHead.data) {
			unsortedHead = unsortedHead.next;
			
		}
		
		Node iter = unsortedHead;
		
		while (iter != null && iter.next != null) {
			
			if(iter.next.data == data) {
				iter.next = iter.next.next;
				break;
			}
			
				iter = iter.next;	
		}
		
		return data;
		
		
		
	}

	
	
	
	public void InsertionSort() {
		
		
		int placeholder = 0;
		
		if(unsortedHead.next != null) {
		Node iter = unsortedHead.next;
		
		
		while(iter != null) {
			if(unsortedHead.data < iter.data) {
				
				iter.data = placeholder;
				iter.data = unsortedHead.data;
				sortedHead.data = iter.data;
			}
			
			System.out.println("Swapped" + sortedHead.data + "with" + iter.data);
			
			iter = iter.next;
				
				
				
		
		
		
		
		

}
			
			System.out.println("Finished Sorting");
		}
		}

	
	public int PastPeek() {
		
		int data = unsortedHead.data;
		
		return data;
		
		
		
		
		
	}
	
}
