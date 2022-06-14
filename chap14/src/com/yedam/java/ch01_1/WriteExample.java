package com.yedam.java.ch01_1;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class WriteExample {


		public static void main(String[] args) throws Exception {
			OutputStream os = new FileOutputStream("d:test1");
			
			byte a = 10;
			byte b = 20;
			byte c = 30;
			
			os.write(a);
			os.write(b);
			os.write(c);
			
			os.flush();
			os.close();
			
			os = new FileOutputStream("d:test2");
			
			byte[] array1 = { 10, 20, 30 };
			os.write(array1);
			
			os.flush();
			os.close();
			
			os = new FileOutputStream("d:test3");
			
			byte[] array2 = { 10, 20, 30, 40, 50 };
			os.write(array2);
			
			os.flush();
			os.close();

	}

}
