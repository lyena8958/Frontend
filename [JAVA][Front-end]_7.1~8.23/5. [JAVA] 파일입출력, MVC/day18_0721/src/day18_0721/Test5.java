package day18_0721;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//awt update-> swing : 자바의 확장버전
import javax.swing.JTextArea;
//★->만든 패키지 vmc 참고하면서볼것 
public class Test5 {
	// swing 자바 GUI
	// 사용xxxxxxx (현업에서 안씀)
	// 크게 중요하지않으나 후에 개념설명할 때 이용하기 위함
	public static void main(String[] args) {
		//화면에 올라가는 스타일이있구나~ 이정도만 알아도될듯
		// 흐름만 
		
		//css 프론트 딴에서 하는것들
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(new JLabel("GUI실습중"),BorderLayout.NORTH);
		frame.add(panel);
		
		
		JButton btn = new JButton("클릭!");
		//버튼 요청에 따른 수행 ->
		panel.add(btn,BorderLayout.SOUTH);
		
		JTextArea tarea = new JTextArea();
		panel.add(tarea, BorderLayout.CENTER);
		
		// ActionListener 메소드를 오버라이딩
		// addActionListener ->액션을 하기위해 add

		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tarea.append("글을 추가합니다!\n"); // 클릭을 하는 순간 멘트가 생성됨
				
			}// 클릭받을준비 하는 동작설정
			
		});
		
		// 이미지 액션 
		// 파일입출력처럼 파일위치를 갖고오면됨
		ImageIcon img = new ImageIcon("C:\\KIM_0622\\resource\\tmtm.PNG");
		JButton btn2 = new JButton("사진버튼",img);
		panel.add(btn2,BorderLayout.EAST);
		
		frame.setVisible(true);
		frame.setSize(500,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setVisible(true);
		frame.setSize(500,400);
		
		//--> x버튼을 눌러도 콘솔이 안끝남
		//그래서 백엔드는 버튼활성화를 해야한다.

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
