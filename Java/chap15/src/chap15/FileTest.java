package chap15;

import java.io.FileInputStream;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(FileInputStream file = new FileInputStream("D\\java7\\java\\file.text")){
			
		} 

		//if(!file.exists()) file.createNewFile();
		
	}

}
