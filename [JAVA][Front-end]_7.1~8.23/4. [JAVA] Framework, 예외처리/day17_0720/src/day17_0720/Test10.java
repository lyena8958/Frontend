package day17_0720;

class MyException extends Exception{
	MyException(){
		super("�������翹��Ŭ����");
	}
}

public class Test10 {
	//throw  / throws
static void func1() throws Exception { //Exception =>� ������ �߻������𸣹Ƿ� �μ��Ǻҷ���
	int a=10, b=0;
	//try-catch ���� �ϳ�->���ο����ϰ�;�!
	System.out.println(a/b); //�����߻�����
	System.out.println("func1()ȣ���");//�������߻��ϸ� �Ʒ� ��ɹ��� ���������ʴ´�.
}
static void func2() throws Exception {
	Exception excep =new Exception("�������翹�ܰ�ü");
	throw excep;
}
static void func3() throws MyException {//�ƴ� �� ����ٰ� �ϱ������?(2) ���ο� ���ѱ��
	MyException my = new MyException();
	throw my;//���⼭ try-catch�� �ؾ��ϳ�(1)
}
	public static void main(String[] args) {
		
		// ����ó�� �̷�� : throws
		
		 try {
			//func1();
			 //func2();
			 func3();
		}
		 catch(MyException e) {
			System.out.println("ó���Ϸ�");
		}
		 catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("����ó���Ϸ�");
			System.out.println(e.getMessage());
		}

		// ����: ��ó���� �ؾ��ϴ� ����
		//func1();�ݵ�� ó���� �����ʾƵ� ������ ���� - ArithmeticException : �ؼ� try-catch�� �����ϰ���������

	}//main����

}
