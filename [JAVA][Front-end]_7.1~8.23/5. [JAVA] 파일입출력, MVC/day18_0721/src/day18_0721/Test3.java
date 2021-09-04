package day18_0721;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test3 {

	public static void main(String[] args) {
		String uri = "C:\\KIM_0622\\resource\\"; // �������
		
		try {//
			FileInputStream fis = new FileInputStream(uri+"blog_���3.PNG"); // ���
			FileOutputStream fos = new FileOutputStream(uri+"tmtm.PNG");  // �Է�
			
			byte[] b = new byte[1000]; // �˳��� 1000����Ʈ ����
			int len;
			//�Ʒ� �̿��ϱ� ���� ����
			//fis.read(b) �о�� ���� b�迭�� ���� -> 1000���� �̸�����
			// b�� ������ �뷮��������� (�ִ� 1000����Ʈ)
			
			//(len=fis.read(b)) �� 
			   // ������ �뷮�� b��(�ִ�1000����Ʈ)�� �������, len���Է����ش�. ���� �����̾��ٸ� -1�� ����´�.
			while((len=fis.read(b)) != -1) { // ���������ͱ���
				System.out.println(len);
				fos.write(b, 0, len); // fos.write(b, off, len);
				// ����Ʈ�� 0������ len���� (ó�����ͳ�����)
			}
			fos.flush();
			fos.close();
	
		} catch (FileNotFoundException e) {
			System.out.println("���Ͽ��ܹ߻�!");
		} catch (IOException e) {
			System.out.println("�����ó�����ܹ߻�!");
		}finally {
			System.out.println("=====���������Ϸ�=====");
		}

	}//main

}
