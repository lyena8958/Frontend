package day17_0720;

import java.util.HashMap;
import java.util.HashSet;

public class Test3 {

	public static void main(String[] args) {
		
		// ������ ���������� �÷����̴�.
		//  �ߺ��� ��������ʴ´�. == �Է��� �����ʴ´�.(size���̵� �ߺ������� ���̰�����)
		// ����(Set), Map
		HashSet hs = new HashSet();
		hs.add(10);
		hs.add(20);
		hs.add(30);
		hs.add(10);
		hs.add(20);
		hs.add(30);
		System.out.println(hs.size()); // hash�ڵ�� ���� �ּҼ����� ���´�.
		
		System.out.println();
		
		// ���� key-value ������ �̷���� �����͸� �����Ѵ�.
		// key: ������
		// value: �ߺ��ɼ����ִ� ��
		HashMap<Integer, String> map1 = new HashMap();
		// <String, String>
		map1.put(1, "ȫ�浿"); // put(key, value);s
		map1.put(2, "�Ƹ�");
		map1.put(3, "�ƹ���");
		map1.remove(2); // �����ͻ���: ������ �ĺ���, key���� ���� �Ǵ��Ѵ�.
		System.out.println(map1.get(3));
		
		
		
		
		
		
	}

}
