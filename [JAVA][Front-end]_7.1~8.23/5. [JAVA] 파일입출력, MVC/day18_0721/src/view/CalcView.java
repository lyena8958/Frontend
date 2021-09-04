package view;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
V view 뷰(프론트엔드가 일반적)
디자인-화면에 결과를 보여주는 작업
사용자(클라이언트)가 보는 화면,브라우저
요청을 실행할 수 있는 버튼*/

// V
// 사용자가 어떻게 사용하면 편리할지를 초점에두고 코딩!
public class CalcView extends JFrame{//협업할 때는 변수명을 지키는 것이 좋다
	//M -> V 담당자한테 대략적인 계산방식을 알주기( a,b = res) 결과가 한개나온다.
	   public JTextField n1,n2;
	   public JComboBox<String> op;
	   public JButton btn;
	   public JLabel res;
	   
	   JPanel panel;
//add action이 없는이유 : 컨트롤러가 하는부분(로직)
	public CalcView() {//사용자가 있어??
		setTitle("계산기 실습");
		int size = 10;
		n1=new JTextField(size); // 폰트크기
		n2=new JTextField(size);
		
		//★ 연산을 위 size가 아니라 개발자가 직접 넣어준다.(버튼활용)
		op=new JComboBox();
		op.addItem("+"); // 요소를 박스에넣어서 사용(사용자가 입력안하고 선택-오타방지)
		op.addItem("-");
		
		btn = new JButton("계산하기"); // 계산하기 버튼생성
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
		//숫자를 넣어두었던 공간에 빈칸 넣어줌
		n1.setText("");
		n2.setText("");
	}
}
