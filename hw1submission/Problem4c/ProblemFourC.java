
public class ProblemFourC {


		
		private int n = 0;
		private int baseCapacity = 10;
		public double s[] = new double [baseCapacity];
		
		
		
		
		
		
		public double ProblemFourC(int input) {
		
		for (double i = 0; i<input; i++) {
			for(double j = 0; j<input; j++) {
				for(double k = 0; k<input; k++) {
		
		double smallest = Math.pow(9,i)*Math.pow(15,j)*Math.pow(7,k);
		
		if(n == s.length) resize(2*s.length);
		s[n++] = smallest;
		
				}
			}
		}
		//sorting block
		for(int i = 0; i<s.length; i++) {
			for (int j = i+1; j<s.length; j++) {
				double placeholder;
				if (s[i]<s[j]) {
					placeholder = s[i];
					s[i] = s[j];
					s[j] = placeholder;
				}
		}
		}
		
		
		
		
		
		
		
		System.out.println(s[input]);
		
		//returns the correct value
		if(input<s.length) {
			return s[input];
			
		}
			else {
				System.out.println("Error index value is not in the array");
		}
		return 0;
		
			
		
		
	}
	
	
		
		
		
	
	
	private void resize (int baseCapacity) {
		
		double copy[] =  new double [baseCapacity];
		for (int i = 0; i < n; i++)
			copy[i] = s[i];
		s = copy;
	}
	

		
		
			
	
	
}
