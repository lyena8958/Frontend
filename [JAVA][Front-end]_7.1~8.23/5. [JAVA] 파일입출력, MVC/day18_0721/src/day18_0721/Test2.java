package day18_0721;

import java.io.File; // io -> in&output
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) {
		
		// [���� �����]
		
		// C:\KIM_0622\resource\\
		
		String uri = "C:\\KIM_0622\\resource\\"; // �������
		
		//File file = new File("C:\\KIM_0622\\resource\\apple.txt");
		File file = new File(uri,"apple.txt"); // �̷��� ����� ��찡 ����!
		// File = new File("���\\���ϸ�.txt);
		// ����� ������ �������� ����
		// �ش� �����̾����� ���� �������ش�!
		// ��� �Է� "\\���ϸ�"
		try {//createNewFile ���ϻ���
			file.createNewFile();// �޼ҵ忡�� �������̷���� try-catch�������ʿ���
		} catch (IOException e) {
			System.out.println("���ϻ���ó���߿� �����߻�!");
		}finally {
			System.out.println("-----���ϻ����۾�-----");
		}
		
		
		//���
		//���ڴ� ���ϰ�ü�� �ִ���, ��θ� �ִ��� �ؾ��Ѵ�.
		// ������ ���ϰ�ü�� �ִµ� �������� ������ �ٲ�, ���λ����Ͽ� ��θ� ������ֱ� ����
		//FileInputStream fis = new FileInputStream("C:\\KIM_0622\\resource\\apple.txt");
		
		//�� ���� �����̷�� �Ǿ� try-catch����!
		// �����̾��ٸ� ������ ����~ �׷��� ���ϰ�ü���̿�
		try {
			FileInputStream fis = new FileInputStream(file);
			
			//read�� �������� �о���̸� -1�� ��ȯ�Ѵ�.
			// ������(-1)�� �ƴ϶�� ��ӹݺ�
			int data;//����� �����������(���ھ�)
			// ������ ���ڸ� data�� �����Ѵ�. ���� ����ð� ���ٸ� -1�� ����´�. (TMI. -1�� �ؽ�Ʈ�� �ԷµǾ������� -, 1 ������ �����´�.)
				while((data=fis.read()) != -1 ) { // c������ EOF->feof(�����̺����?)
					System.out.print((char)data+" ");
			} 
			System.out.println();
		} catch (FileNotFoundException e) {
			System.out.println("������ �о���� �߿� �����߻�!");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("������ �о�����߿� �����߻�!");
		}finally {
			System.out.println("-----�����б�Ϸ�----");
		}
		
		// �Է�
		try {
			FileOutputStream fos = new FileOutputStream(uri+"banana.txt",true);
			// �����̾��ٸ� �������ְ�,
			// �������־��ٸ� ����Ⱑ �����
			
			// �������̿�� �ι�° ���ڸ� true�� �����ϸ�
			// �̾�Ⱑ �����
			
			fos.write(97); // �ƽ�Ű�ڵ� A
			fos.flush(); // ���ۺ���
			fos.close(); //������������ �ۼ��ϴ� �Ŵ� �ݾ��ش�.
		} catch (FileNotFoundException e) {
			System.out.println("�ۼ��� ���Ͽ� �����߻�!");
		} catch (IOException e) {
			System.out.println("������ �ۼ��ϴ��߿� �����߻�!");
		}finally {
			System.out.println("------�����ۼ��Ϸ�------");
		}
		
		
		
		
		
	}//main

}
