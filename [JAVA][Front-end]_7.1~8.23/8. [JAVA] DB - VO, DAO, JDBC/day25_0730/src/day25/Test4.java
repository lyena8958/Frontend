package day25;

public class Test4 {

	public static void main(String[] args) {
		String str = "<span>�Ĵ����� ��������</span>";
		// <>ǥ�ð� ���������
		str = str.substring(6, str.length()-7);
		System.out.println(str);

	}

}
