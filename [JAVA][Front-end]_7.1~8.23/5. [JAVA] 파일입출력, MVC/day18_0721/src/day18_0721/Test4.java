package day18_0721;

import javax.swing.JOptionPane;

// swing 자바 GUI
// 사용xxxxxxx (현업에서 안씀)
// 크게 중요하지않으나 후에 개념설명할 때 이용하기 위함
public class Test4 {

	public static void main(String[] args) {
		// MVC흐름
		
		JOptionPane pane = new JOptionPane();
		
		String ans = pane.showInputDialog("질문내용","답변내용을 작성");
		System.out.println(ans);
		
		//사과를입력했을때 사과사진을나오게 하는것 = 컨트롤러(백엔드)
		
		
		/*버튼식
		String[] comboBox= {"사과","바나나","키위"};
		Object select=JOptionPane.showInputDialog(null, "질문내용", "제목", JOptionPane.QUESTION_MESSAGE, null, comboBox, comboBox[0]);
		      
		System.out.println(select);*/
		
	}

}
