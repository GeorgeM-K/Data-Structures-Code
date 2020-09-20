public class DaryHeap {

	private int n = 0;
	private int[] pq;
	private int d;

	DaryHeap(int d) {
		int baseLength = 10;
		pq = new int[baseLength];
		this.d = d;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public void insert(int i) {
		if (n >= pq.length - 1) {
			doubleArray();
		}
		n++;
		pq[n] = i;
		swim(n);

	}

	public int delMax() {
		if (n == 0) {
			return 0;

		}

		int max = pq[1];

		exch(1, n--);
		sink(1);
		assert pq[n + 1] == max;
		pq[n + 1] = -1;
		return max;

	}

	private void exch(int i, int j) {
		int swap = pq[i];
		pq[i] = pq[j];
		pq[j] = swap;
	}

	private void sink(int k) {
		
		int child;
		int temp = pq[k];
		while (getChild(k, 1) < n) {
			child = maxChild(k);
			if (pq[child] < temp) {
				pq[k] = pq[child];
			} else {
				break;
			}
			k = child;
		}
		pq[k] = temp;
	}

	private void swim(int k) {
		int temp = pq[k];
		
		while (k > 0 && pq[k] < pq[getParent(k)]) {
			pq[k] = pq[getParent(k)];
			k = getParent(k);
			
			pq[k] = temp;
		}
	}

	public void sort(int a[]) {
		int n = a.length;
		for (int k = n / 2; k >= 1; k--) {
			sink(a, k, n);
		}
		while (n > 1) {
			exch(a, 1, n--);
			sink(a, 1, n);
		}

	}

	public int[] daryHeapsort() {
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = pq[i];

		}
		sort(a);
		return a;
	}

	private void sink(int[] a, int k, int n) {
	
		int child;
		int temp = a[k];
		while (getChild(k, 1) < n) {
			child = maxChild(k);
			if (a[child] < temp) {
				a[k] = a[child];
			} else {
				break;
			}
			k = child;
		}
		a[k] = temp;

	}

	

	private void exch(int[] pq, int i, int j) {
		int swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	public void show() {
		for (int i = 0; i < pq.length; i++) {
			System.out.println(pq[i]);
		}
	}

	private void doubleArray() {
		resize(2 * n);
	}

	private void resize(int test) {
		int copy[] = new int[test];
		for (int i = 0; i < n; i++) {
			copy[i] = pq[i];
			pq = copy;
		}
	}

	private int getParent(int a) {
		int one = (a - 2);
		int index = (one / d) + 1;
		return index;
	}

	private int getChild(int child, int parent) {
		int one = parent - 1;
		int two = child + 1;
		int three = d * one;
		int four = three + two;

		return four;
	}

	private int maxChild(int k) {
		int desired = getChild(k, 1);
		int t = 2;
		int pos = getChild(k, t);
		while ((k <= d) && (pos < n)) {
			if (pq[pos] > pq[desired]) {
				desired = pos;
			}
			pos = getChild(k, t++);
		}
		return desired;
	}
}
