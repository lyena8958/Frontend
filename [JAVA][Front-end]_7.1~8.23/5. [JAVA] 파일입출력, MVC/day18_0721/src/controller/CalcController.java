package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Calc;
//흐름파악!
import view.CalcView;

/*
C controller 컨트롤러(백이 일반적)
V --- M 이어주는 역할
사용자--V--[C]--M--DB/서버
사용자요청을 "어떻게" 처리할지를 정의*/

//C
//M-V 이어주는 역할
public class CalcController implements ActionListener{
	CalcView view;
	public CalcController() {
		this.view=new CalcView(); // 다른개발자가만든 CalcVice를 갖고옴
		this.view.btn.addActionListener(this); //-> GUI기법으로 크게 신경 안써도됨 // 만들기 귀찮으니 액션리스너를 imp한다. 
		// addActionListener 는 액션리스너를 넣어주어야한다. -> imp함으로써 액션리스너 가 되엇으니 this를 해준다.
	}
	@Override
	// 동작만 구현~
	public void actionPerformed(ActionEvent e) {
		// GUI: 입력한 액션이 view의 btn 액션인가? 
		if(e.getSource() == view.btn) {
			String n1 = view.n1.getText();
			String n2 = view.n2.getText();
			String op = view.op.getSelectedItem().toString();//사용자가 연산을 클릭하면 오브젝트로 들어가있으니 toString로 바꿔준것
			
			///// 
		    Calc calc=new Calc(Integer.parseInt(n1),Integer.parseInt(n2),op); //Calc calc = new Calc(n1,n2,op);
	         String res=String.valueOf(calc.getRes());// getset 생성(model에서)
	         view.res.setText(res);

		}
		
	}
	
	
}
