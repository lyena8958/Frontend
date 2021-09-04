package view;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
V view ��(����Ʈ���尡 �Ϲ���)
������-ȭ�鿡 ����� �����ִ� �۾�
�����(Ŭ���̾�Ʈ)�� ���� ȭ��,������
��û�� ������ �� �ִ� ��ư*/

// V
// ����ڰ� ��� ����ϸ� �������� �������ΰ� �ڵ�!
public class CalcView extends JFrame{//������ ���� �������� ��Ű�� ���� ����
	//M -> V ��������� �뷫���� ������� ���ֱ�( a,b = res) ����� �Ѱ����´�.
	   public JTextField n1,n2;
	   public JComboBox<String> op;
	   public JButton btn;
	   public JLabel res;
	   
	   JPanel panel;
//add action�� �������� : ��Ʈ�ѷ��� �ϴºκ�(����)
	public CalcView() {//����ڰ� �־�??
		setTitle("���� �ǽ�");
		int size = 10;
		n1=new JTextField(size); // ��Ʈũ��
		n2=new JTextField(size);
		
		//�� ������ �� size�� �ƴ϶� �����ڰ� ���� �־��ش�.(��ưȰ��)
		op=new JComboBox();
		op.addItem("+"); // ��Ҹ� �ڽ����־ ���(����ڰ� �Է¾��ϰ� ����-��Ÿ����)
		op.addItem("-");
		
		btn = new JButton("����ϱ�"); // ����ϱ� ��ư����
		res = new JLabel();
		
		setLayout(new FlowLayout());
		panel = new JPanel();
		panel.add(n1);
		panel.add(op);
		panel.add(n2);
		panel.add(btn);
		
		add(panel);
		add(res);
		
		setVisible(true);
		setSize(400,300);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void reset() {
		//���ڸ� �־�ξ��� ������ ��ĭ �־���
		n1.setText("");
		n2.setText("");
	}
}
