package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Calc;
//�帧�ľ�!
import view.CalcView;

/*
C controller ��Ʈ�ѷ�(���� �Ϲ���)
V --- M �̾��ִ� ����
�����--V--[C]--M--DB/����
����ڿ�û�� "���" ó�������� ����*/

//C
//M-V �̾��ִ� ����
public class CalcController implements ActionListener{
	CalcView view;
	public CalcController() {
		this.view=new CalcView(); // �ٸ������ڰ����� CalcVice�� �����
		this.view.btn.addActionListener(this); //-> GUI������� ũ�� �Ű� �Ƚᵵ�� // ����� �������� �׼Ǹ����ʸ� imp�Ѵ�. 
		// addActionListener �� �׼Ǹ����ʸ� �־��־���Ѵ�. -> imp�����ν� �׼Ǹ����� �� �Ǿ����� this�� ���ش�.
	}
	@Override
	// ���۸� ����~
	public void actionPerformed(ActionEvent e) {
		// GUI: �Է��� �׼��� view�� btn �׼��ΰ�? 
		if(e.getSource() == view.btn) {
			String n1 = view.n1.getText();
			String n2 = view.n2.getText();
			String op = view.op.getSelectedItem().toString();//����ڰ� ������ Ŭ���ϸ� ������Ʈ�� �������� toString�� �ٲ��ذ�
			
			///// 
		    Calc calc=new Calc(Integer.parseInt(n1),Integer.parseInt(n2),op); //Calc calc = new Calc(n1,n2,op);
	         String res=String.valueOf(calc.getRes());// getset ����(model����)
	         view.res.setText(res);

		}
		
	}
	
	
}
