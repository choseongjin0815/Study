package chap2;

public class ExDouble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dnum = 1D;
		for(int i = 0; i < 10000; i++) {
			dnum = dnum + 0.1;
			
		}
		
		int a[] = new int[10];
		for(int i = 0; i < a.length; i++) {
			a[i] = i;
			System.out.println(a[i]);
		}
		 
		
		System.out.println("Double Num : " + dnum);
	}
	
}
