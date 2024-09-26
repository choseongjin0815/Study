package chap7;

public class Study {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1)
		int[] a = new int[3];
		
		//2)
		int[] a1 = new int[] {1,2,3};
		
		//3)
		int[] a2 = {1,2,3};
		
		//2차원 Array 할당방법
		//1-1)
		int[][] b = new int[3][2];
		b[0][0] = 1;
		b[0][1] = 2;
		//1-2)
		int[][]b1 = new int[3][];
		b1[0] = new int[3];
		b1[0][1] = 3;
		
		//2)
		int[][] b2= new int[][] {{1,2,3},{4,5,6}};
		
		//3)
		int[][] b3 = {{1,2,3}, {4,5,6}};
		
		String str = "aaaaasdd";
		//System.out.println(str[0]);

	}

}
