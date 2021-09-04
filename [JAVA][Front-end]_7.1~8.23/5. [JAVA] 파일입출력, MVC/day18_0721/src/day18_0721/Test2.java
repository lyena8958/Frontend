package day18_0721;

import java.io.File; // io -> in&output
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) {
		
		// [파일 입출력]
		
		// C:\KIM_0622\resource\\
		
		String uri = "C:\\KIM_0622\\resource\\"; // 경로저장
		
		//File file = new File("C:\\KIM_0622\\resource\\apple.txt");
		File file = new File(uri,"apple.txt"); // 이렇게 만드는 경우가 많다!
		// File = new File("경로\\파일명.txt);
		// 저장된 파일을 가져오는 역할
		// 해당 파일이없으면 새로 생성해준다!
		// 경로 입력 "\\파일명"
		try {//createNewFile 파일생성
			file.createNewFile();// 메소드에서 오류를미뤄놓아 try-catch생성이필요함
		} catch (IOException e) {
			System.out.println("파일생성처리중에 문제발생!");
		}finally {
			System.out.println("-----파일생성작업-----");
		}
		
		
		//출력
		//인자는 파일객체를 넣던지, 경로를 넣던지 해야한다.
		// 보통은 파일객체를 넣는데 그이유는 파일이 바뀌어도, 새로생성하여 경로를 갖고와주기 때문
		//FileInputStream fis = new FileInputStream("C:\\KIM_0622\\resource\\apple.txt");
		
		//또 역시 오류미루기 되어 try-catch생성!
		// 파일이없다면 오류가 생김~ 그래서 파일객체를이용
		try {
			FileInputStream fis = new FileInputStream(file);
			
			//read는 마지막을 읽어들이면 -1를 반환한다.
			// 마지막(-1)이 아니라면 계속반복
			int data;//출력할 내용을갖고옴(한자씩)
			// 파일의 글자를 data가 저장한다. 만약 갖고올게 없다면 -1을 갖고온다. (TMI. -1이 텍스트에 입력되어있으면 -, 1 나눠서 가져온다.)
				while((data=fis.read()) != -1 ) { // c언어에서는 EOF->feof(다음이비었니?)
					System.out.print((char)data+" ");
			} 
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("파일을 읽어오는 중에 문제발생!");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 읽어오는중에 문제발생!");
		}finally {
			System.out.println("-----파일읽기완료----");
		}
		
		// 입력
		try {
			FileOutputStream fos = new FileOutputStream(uri+"banana.txt",true);
			// 파일이없다면 생성해주고,
			// 파일이있었다면 덮어쓰기가 진행됨
			
			// 생성자이용시 두번째 인자를 true로 설정하면
			// 이어쓰기가 진행됨
			
			fos.write(97); // 아스키코드 A
			fos.flush(); // 버퍼비우기
			fos.close(); //안정성문제로 작성하던 거는 닫아준다.
		} catch (FileNotFoundException e) {
			System.out.println("작성할 파일에 문제발생!");
		} catch (IOException e) {
			System.out.println("파일을 작성하는중에 문제발생!");
		}finally {
			System.out.println("------파일작성완료------");
		}
		
		
		
		
		
	}//main

}
