package day18_0721;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//awt update-> swing : �ڹ��� Ȯ�����
import javax.swing.JTextArea;
//��->���� ��Ű�� vmc �����ϸ鼭���� 
public class Test5 {
	// swing �ڹ� GUI
	// ���xxxxxxx (�������� �Ⱦ�)
	// ũ�� �߿����������� �Ŀ� ���伳���� �� �̿��ϱ� ����
	public static void main(String[] args) {
		//ȭ�鿡 �ö󰡴� ��Ÿ�����ֱ���~ �������� �˾Ƶ��ɵ�
		// �帧�� 
		
		//css ����Ʈ ������ �ϴ°͵�
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(new JLabel("GUI�ǽ���"),BorderLayout.NORTH);
		frame.add(panel);
		
		
		JButton btn = new JButton("Ŭ��!");
		//��ư ��û�� ���� ���� ->
		panel.add(btn,BorderLayout.SOUTH);
		
		JTextArea tarea = new JTextArea();
		panel.add(tarea, BorderLayout.CENTER);
		
		// ActionListener �޼ҵ带 �������̵�
		// addActionListener ->�׼��� �ϱ����� add

		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tarea.append("���� �߰��մϴ�!\n"); // Ŭ���� �ϴ� ���� ��Ʈ�� ������
				
			}// Ŭ�������غ� �ϴ� ���ۼ���
			
		});
		
		// �̹��� �׼� 
		// ���������ó�� ������ġ�� ��������
		ImageIcon img = new ImageIcon("C:\\KIM_0622\\resource\\tmtm.PNG");
		JButton btn2 = new JButton("������ư",img);
		panel.add(btn2,BorderLayout.EAST);
		
		frame.setVisible(true);
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
		frame.setSize(500,400);
		
		//--> x��ư�� ������ �ܼ��� �ȳ���
		//�׷��� �鿣��� ��ưȰ��ȭ�� �ؾ��Ѵ�.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
