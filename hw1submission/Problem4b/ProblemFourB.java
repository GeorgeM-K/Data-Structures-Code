import java.util.ArrayList;

	public class ProblemFourB{

		public void push(int s[][], int arbitraryvalue) {
			ArrayList<Integer> oneD = new ArrayList<Integer>();
			for(int i = 0; i < s.length; i++) {
				for(int j = 0; j< s[i].length; j++) {
					oneD.add(s[i][j]);
					}
						
					}
				
			for (int i = 0; i<oneD.size(); i++) {
				for (int j = i+1; j < oneD.size() -1; j++) {
					if (oneD.get(i)+oneD.get(j) == arbitraryvalue) {
						System.out.println( "(" + oneD.get(i) + ","+ oneD.get(j)+ ")" );
					}
			
		}
			}

		}
		
	}
	

