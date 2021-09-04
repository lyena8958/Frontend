package stuController;

import java.util.InputMismatchException;
import java.util.Scanner;

import stuModel.StuModel;
import stuView.StuView;

public class Controller {

	public StuView view;
	public StuModel model;

	public void Crrstart() {
		view = new StuView();
		while (true) { // ����ڰ� �����ư �����������ݺ��Ѵ�.
			view.viewStart(); // ���α׷��ȳ�//�����Է�//����ó��
			model = new StuModel(view.eng, view.kor, view.math);

			view.showRes(model.GradeRt(), model.avgRt());

		}
	}

}
