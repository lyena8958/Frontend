package day18_0721;

import javax.swing.JOptionPane;

// swing �ڹ� GUI
// ���xxxxxxx (�������� �Ⱦ�)
// ũ�� �߿����������� �Ŀ� ���伳���� �� �̿��ϱ� ����
public class Test4 {

	public static void main(String[] args) {
		// MVC�帧
		
		JOptionPane pane = new JOptionPane();
		
		String ans = pane.showInputDialog("��������","�亯������ �ۼ�");
		System.out.println(ans);
		
		//������Է������� ��������������� �ϴ°� = ��Ʈ�ѷ�(�鿣��)
		
		
		/*��ư��
		String[] comboBox= {"���","�ٳ���","Ű��"};
		Object select=JOptionPane.showInputDialog(null, "��������", "����", JOptionPane.QUESTION_MESSAGE, null, comboBox, comboBox[0]);
		      
		System.out.println(select);*/
		
	}

}
