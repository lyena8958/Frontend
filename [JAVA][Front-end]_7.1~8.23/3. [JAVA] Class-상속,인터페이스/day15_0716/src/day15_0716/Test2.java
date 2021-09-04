package day15_0716;

import java.util.Random;

// DB����, ũ�Ѹ����� �������̽��� �̹�!


interface Plus{// ���ϸ���� ���̸� �ؾ���!
	void play();
}
interface F{
	// ���޼���� �� "�߻�޼���"
	void f1();
	void f2();
	void func();
	void attack(); 
	// ������ �����ϴ� �� �߻�Ŭ�������� �� �� ��?������ �ڽ�Ŭ�������� �����ؾ��ϴϱ�.
	// �׷� �������??
}
//class Fire implements A{
//
//	@Override
//	public void f1() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void f2() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void func() {
//		// TODO Auto-generated method stub
//		
//	}
//	
//}

abstract class Pocket {//implements Plus
	String name;
	String type; // �Ӽ�
	int level;
	int exp; // 100���� Lv+=1
	Pocket() { // ������� ��? �ڽĿ��� �����߱⶧��(�׷���������(������) ���°� ����)
		this(5);
	}

	Pocket(int level) {
		// �̸��� ��ī��, ���̸�, ���α⿡�� ����
		// �Ӽ��� �Ӽ��������� ����(��,��)
		this.name="";// �ڽĿ��� ����ű� ������ ��� ����
		this.level = level;
		this.exp = 0;
	}
	abstract boolean attack();
	void game() {
		if(this.attack()) {
			this.exp+=(new Random().nextInt(5)+1)*10;
			System.out.println("���ݼ���!");
			if(this.exp>=100) { // while���� ��밡��!
				this.exp -= 100;
				this.level++;
				System.out.println("������!!!");
			}
		}
		else {
			System.out.println("���ݽ���!");
		}
		System.out.println("�������ġ: "+this.exp);
		System.out.println();
	}
	public String toString() {
		return this.name+" Lv."+this.level+" ["+this.exp+"]";
	}
}
abstract class Water extends Pocket{
	// ��ü�� ���������ʱ����ؼ� �߻�Ŭ����ȭ
	Water(){
		this(5);
	}
	Water(int level){
		super(level);
		this.type = "�� ���ϸ�";
	}
	@Override
	boolean attack() {
		System.out.println("������--!!!!!");
		return new Random().nextBoolean();
	}
	
}
abstract class Elec extends Pocket{
	// ��ü�� ���������ʱ����ؼ� �߻�Ŭ����ȭ
	Elec(){
		this(5);
	}
	Elec(int level){
		super(level);
		this.type = "���� ���ϸ�";
	}
	@Override
	boolean attack() {
		System.out.println("!�鸸��Ʈ!");
		return new Random().nextBoolean();
	}
	
}
class A extends Water{ // ���α�
	A(){
		this(5); // �Ƚᵵ����
	}
	A(int level){
		super(level);
		this.name = "���α�";
		System.out.println("���α� �����Ϸ�"+level);
	}
}
class B extends Water{ // ������
	B(){
		this(5);
	}
	B(int level){
		super(level);
		this.name = "������";
		System.out.println("������ �����Ϸ�"+level);
	}
}
class C extends Elec{ // ��ī��
	C(){
		this(5);
	}
	C(int level){
		super(level);
		this.name = "��ī��";
		System.out.println("��ī�� �����Ϸ�"+level);
	}
}
class D extends Elec{ // ������
	D(){
		this(5);
	}
	D(int level){
		super(level);
		this.name = "������";
		System.out.println("������ �����Ϸ�"+level);
	}
}
public class Test2 {

	public static void main(String[] args) {
	/*���ϸ���
		   �̸�
		   ����
		   ����ġ 100���� Lv+=1
		   ����->���� ����ġ++
		      ���� ����ġxxx
		   boolean ����()
		�Ӽ�
		   ����: ������/�鸸��Ʈ
		��ī��
		   �̸�-��ī��/�̸�-���̸�
		   ����-1~9 // 5
		   ����ġ-0*/

		//	Pocket pocket = new Pocket(); xxx
		Pocket[] data = new Pocket[4];
		data[0] = new A();
		data[1] = new B(new Random().nextInt(9)+1);
		data[2] = new C();
		data[3] = new D(new Random().nextInt(9)+1);
		
		
		for(int i = 0; i<3;i++) {
			for(Pocket p:data) {//�迭�ε��� �����Ұ���!!
				p.game(); // 12�� ����(�迭�Ǳ���(4)*i(3))
			}
		}
		
		for(Pocket p:data) {
			System.out.println(p);
		}
		// ��ī�� Lv.5 [20]
		
	}//main����

}
