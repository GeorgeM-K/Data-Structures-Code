
	import java.util.Arrays;

	public class ArbirtraryQueueArray<randodata> {
		
		
		 
		
		
		private randodata s[];
		private int n = 0;
		
		public ArbirtraryQueueArray() {
			
			int baseCapacity =10;
			
			s = (randodata[]) new Object[baseCapacity];
			n = 0;
		}
		
		public ArbirtraryQueueArray(int baseCapacity) {
			 s = (randodata[]) new Object[baseCapacity]; 
			 
		}
		
		
		public boolean isEmpty() {
			
			return n == 0;
		}
		
		
		
		public void push(randodata data) {
			
			
			if(n == s.length) resize(2*s.length);
			s[n++] = data;
		}
		
		private void resize (int baseCapacity) {
			
			randodata copy[] = (randodata[]) new Object[baseCapacity];
			for (int i = 0; i < n; i++)
				copy[i] = s[i];
			s = copy;
		}
		
		public randodata pop() {
			
			randodata popped = s[--n];
			s[n] = null;
			if (n>0 && n == s.length/4) resize( s.length/2);
			return popped;
		}

	public void enqueue(randodata data) {
		
		if (n == 0) resize (2*s.length);
		s[n--] = data;
	}

	public randodata dequeue() {
		
		randodata dequeued = s[++n];
		s[n] = null;
		if (n < s.length/4 && n == 0) resize(s.length/2);
		
		return dequeued;
		
	}

	public randodata traverse(int index) {
		
		if(index<s.length) {
			return s[index];
		}
			else {
				System.out.println("Error index value is not in the array");
		}
		return null;
			
	}
}
