package stuModel;

//��
public class StuModel {
	public StuModel(int kor, int eng, int math) { // ������ ��������
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int kor;
	public int eng;
	public int math;
	public final int SUBJECTSU =3; // �����

	public double avgRt() {
		// ����ڿ��� ����� ��հ� ����
		double stuAvg = (this.kor + this.math + this.eng * 1.0) / SUBJECTSU; // ��� ���
		return stuAvg;

	}

	public String GradeRt() {
		double stuAvg = avgRt();
		// �� ->���������� ���� ����� ��ȯ
		// ~80��: A
		if (stuAvg >= 80) {
			return "A";
		} else if (stuAvg >= 60) {
			return "B";
		} else {
			return "C";
		}

	}

}
