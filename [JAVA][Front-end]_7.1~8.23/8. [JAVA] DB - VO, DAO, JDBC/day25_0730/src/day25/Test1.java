package day25;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model_student.StudentDAO2;
import model_student.StudentVO;

public class Test1 {

	public static void main(String[] args) {
		// ���� ������ �̿��ϵ��� �ǽ�
		
		Scanner sc = new Scanner(System.in);
		// ������� ��û�� ���� ��ĳ�� ��ü
		
		StudentDAO2 dao = new StudentDAO2();
		// student ���̺�� DB�����ϴ� ��ü
		
		Random rand = new Random();
		// ������ �������� �����ϴ� ��ü
		
		StudentVO vo = new StudentVO();
		// DAO�� ���ڷ� ����ϴ� ��ü (CRUD ������ ��ü)
		
		while(true) {

			System.out.println("1.�Է� 2.���� 3.���� 4.�˻� 5.������ 6.����");
			int act =sc.nextInt();
			if(act==1) {
				System.out.println("�̸��Է�");
				String name = sc.next();
				int score1 =  rand.nextInt(101);
				int score2 =  rand.nextInt(101);
				vo.setName(name);
				vo.setScore1(score1);
				vo.setScore2(score2);
				dao.insertStu(vo);
			}
			else if(act==2) {//���������� --> ����������
				System.out.println("��������");
				System.out.println("�α���-����ó��");
				System.out.println("�ٲ� �л��� ��ȣ�Է�"); // �α���(����)
				int num = sc.nextInt(); // �α����Է�
				vo.setNum(num);
				vo = dao.selectOne(vo); //�α����� �ؼ� ������������ �����ִ� ����
				// �α������� -> ���������� -> ��������
				
				// dao.selectOnt(vo)���� �α����� �ȵǾ� null�� ��ȯ�޾Ҵٸ� 
				if(vo==null) {
					System.out.println("�˻������ �����ϴ�!");
					vo = new StudentVO(); // vo�ʱ�ȭ(�����ָ� null�� �����Ǳ� ������ Ÿ ��忡�� ������)
					continue;
				}
				
				System.out.println("����������: "+vo);
				System.out.println("1.�̸� 2.����");
				act= sc.nextInt();
				if(act==1) {
					System.out.println("���ο��̸��Է�");
					String name = sc.next();
				}
				else { //����
					int score1 = 0;
					int score2 = 0;
					System.out.println("�������¿Ϸ�");
					vo.setScore1(score1);
					vo.setScore2(score2);
				}
				dao.updateStu(vo);
				
			}
			else if(act==3) { //����
				//  1) ȸ��Ż��	- �Ϲ�����
				/*System.out.println("��������");
				System.out.println("�α���-����ó��");
				System.out.println("������ �л��� ��ȣ�Է�"); // �α���(����)
				int num = sc.nextInt(); // �α����Է�
				vo.setNum(num);
				vo = dao.selectOne(vo); //�α����� �ؼ� ������������ �����ִ� ����
				
				if(vo==null) {
					System.out.println("�˻������ �����ϴ�!");
					vo = new StudentVO(); // vo�ʱ�ȭ(�����ָ� null�� �����Ǳ� ������ Ÿ ��忡�� ������)
					continue;
				}
				
				// �α�������->���������� ->ȸ��Ż��
				System.out.println("����������: "+vo);
				System.out.println("ȸ��Ż�� �����մϴ�...");
				dao.deleteStu(vo);
				System.out.println("ȸ��Ż��Ϸ�!");
			}
			else if(act==4) {
				System.out.println("�л���ȣ�Է�");
				int num = sc.nextInt();
				vo.setNum(num);
				vo = dao.selectOne(vo);
				
				if(vo==null) {
					System.out.println("�˻��������!");
					vo = new StudentVO(); 
					// ����� ���� ������ nulló���� �Ǿ� ���� ����� �������߻��ϴ� ���ʱ�ȭ
					continue;
				}

				System.out.println("�˻����: "+vo);*/
				
				//�̷��Դ� �� ������ ->���� ����ϴ°������ø����� �ҿ���
				// 2) ������-�����ͻ���(��������) ���� ��
				System.out.println("������ �л��� ��ȣ�Է�");
				int num = sc.nextInt();
				vo.setNum(num);
				dao.deleteStu(vo);
				// delete()�� �������� ��ȯ�������־���Ѵ�!!
			}
			else if(act==5) {
				System.out.println("==�л����==");
				ArrayList<StudentVO> datas = dao.selectAll(vo);
				for(StudentVO v: datas) {
					System.out.println(v);
				}
				System.out.println("===============");
						
			}
			else if(act==6) {
				break;
			}
			else {
				System.out.println("�������Է�!");
			}
		}



	}//main

}


