package chap4;

public class Mtable {

	public static void main(String[] args) {
		/*	int res = 0;
			int[] arr =	new int[]  {1,2,3,4,5,6,7,8,9,10};
		
			for(int i = 2; i < 10; i++ ) {
			
			for(int j = 1; j < 10; j++) {
				res = i * j;
				System.out.println(i + "*" + j + "=" + res);
			}
		}
		*/
		
		//한줄에서 전부 출력하는 식으로
		int res = 0;
		
		int cnt = 0;
		for(int i = 2; i < 10; i++) {
			
				if (i == 2) {
					System.out.println(i + "단" + "      " + (i + 1) + "단" + "      " + (i + 2) + "단" + "      " + (i + 3) + "단" + "      " );
				
					for(int j = 1; j < 10; j++) {
						System.out.print(i + "*" + j + "=" + (i + cnt)*j + "    " );
						System.out.print((i + 1) + "*" + j + "=" + (i + cnt + 1)*j + "    ");
						System.out.print((i + 2) + "*" + j + "=" + (i + cnt + 2)*j + "    ");
						System.out.print((i + 3) + "*" + j + "=" + (i + cnt + 3)*j + "    ");
						System.out.println();
						
			
					}
				}
			
		
				if (i == 6) {
					System.out.println(i + "단" + "      " + (i + 1) + "단" + "      " + (i + 2) + "단" + "      " + (i + 3) + "단" + "      " );
				
				
					for(int k = 1; k < 10; k++) {
						System.out.print(i + "*" + k + "=" + (i + cnt)*k + "    ");
						System.out.print((i + 1) + "*" + k + "=" + (i + cnt + 1)*k + "    " );
						System.out.print((i + 2) + "*" + k + "=" + (i + cnt + 2)*k + "    " );
						System.out.print((i + 3) + "*" + k + "=" + (i + cnt + 3)*k + "    " );
						System.out.println();
						
					}
			}
			
		
	}
	}
}


/* 2단    3단 	4단	 	5단
  ...   ....   ...     ....
 6		7 		8		9
*/