package stuModel;

//모델
public class StuModel {
	public StuModel(int kor, int eng, int math) { // 국영수 점수받음
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int kor;
	public int eng;
	public int math;
	public final int SUBJECTSU =3; // 과목수

	public double avgRt() {
		// 사용자에게 출력할 평균값 리턴
		double stuAvg = (this.kor + this.math + this.eng * 1.0) / SUBJECTSU; // 평균 계산
		return stuAvg;

	}

	public String GradeRt() {
		double stuAvg = avgRt();
		// 비교 ->기준점수에 따라 등급을 반환
		// ~80점: A
		if (stuAvg >= 80) {
			return "A";
		} else if (stuAvg >= 60) {
			return "B";
		} else {
			return "C";
		}

	}

}
