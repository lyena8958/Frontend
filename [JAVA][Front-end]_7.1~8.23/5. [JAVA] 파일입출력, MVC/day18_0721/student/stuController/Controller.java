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
		while (true) { // 사용자가 종료버튼 누를때까지반복한다.
			view.viewStart(); // 프로그램안내//성적입력//예외처리
			model = new StuModel(view.eng, view.kor, view.math);

			view.showRes(model.GradeRt(), model.avgRt());

		}
	}

}
