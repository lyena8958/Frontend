package controller;

import model.Calc;
import view.CalcConsolView;
//��� �ָܼ��
public class CalcController2 {
	CalcConsolView view;
	Calc model;
	
	public CalcController2(){
		view = new CalcConsolView();
	}
	public void start() {
		while(true) {
			
			view.startCalc();
			model=new Calc(view.n1,view.n2,view.op);
			view.showRes(model.getRes());
		}
		
	}
	
	
}
