package day18_0721;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) {
		String uri = "C:\\KIM_0622\\resource\\"; // 경로저장
		
		try {//
			FileInputStream fis = new FileInputStream(uri+"blog_배경3.PNG"); // 출력
			FileOutputStream fos = new FileOutputStream(uri+"tmtm.PNG");  // 입력
			
			byte[] b = new byte[1000]; // 넉넉히 1000바이트 생성
			int len;
			//아래 이용하기 위해 생성
			//fis.read(b) 읽어온 것을 b배열로 저장 -> 1000단위 미만까지
			// b는 파일의 용량을갖고와줌 (최대 1000바이트)
			
			//(len=fis.read(b)) ↓ 
			   // 파일의 용량을 b가(최대1000바이트)를 갖고오고, len에입력해준다. 만약 파일이없다면 -1을 갖고온다.
			while((len=fis.read(b)) != -1) { // 사진데이터까지
				System.out.println(len);
				fos.write(b, 0, len); // fos.write(b, off, len);
				// 바이트를 0번부터 len까지 (처음부터끝까지)
			}
			fos.flush();
			fos.close();
	
		} catch (FileNotFoundException e) {
			System.out.println("파일예외발생!");
		} catch (IOException e) {
			System.out.println("입출력처리예외발생!");
		}finally {
			System.out.println("=====사진예제완료=====");
		}

	}//main

}
