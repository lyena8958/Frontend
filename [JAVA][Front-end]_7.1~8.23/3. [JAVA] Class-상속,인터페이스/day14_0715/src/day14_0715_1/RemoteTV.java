package day14_0715_1;
//serviceTV , useTV... �������̽��� ���� �̸��� ������
public interface RemoteTV { //�������̽��� ��� �޼ҵ尡 �߻�޼ҵ��̴�.
	void soundUp();// �߻�޼���
	public abstract void soundDown();
	// public, abstract�� �����Ǿ�����!!!
	
	//{ 
//		System.out.println("�Ҹ�++");
//	}
}
// public interface TV 
//	Ŭ������ �ƴ� 
//	�������̽�
//	 -> ��ü�� ����xxx
//	 => public abstract�� ��� �޼��忡 �ٴ´�!

// Q&A
//���� �򰥷��� �׷�����..! �������̽��� Ŭ�����鿡�� "���"�� �ο����ֱ� ���� �����Ǵ°� �´ٶ�� ����ǳ���?
// -> �� ��Ȯ�մϴ�!