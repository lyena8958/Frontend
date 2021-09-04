package TeamProject;/*
abstract class Animal{
	//[������] - �̸�,�� �� �ʼ�!! (������,���� ����)
	Animal(String name){
		this(name,"�˼�����",0); 
		// ���û���-������"�˼�����", ���� 0 ���� �ʱ�ȭ�ο�
	}
	Animal(String name, String habitat, int age){
		this.name = name;
		this.habitat = habitat;
		this.age = age;
		this.type = ""; //�����ڰ� �Է�
	}
	//[�������]
	String name; // �̸�
	String habitat; // ������
	String type; // ��(������ ��� ����)
	int age; // ����
	
	//[�޼ҵ�]
	abstract void food(); // �Ļ� ���(���, ���)
	abstract void play(); // ���� ���(��ɳ���, ��å)
	abstract void action(); // �ൿ ���(�ɾ�, �Ͼ)
	
	//[�������̵�]
	public boolean equals(Object obj) { // ���Լ� �������̵�
		Animal ani = (Animal) obj; 
		if(ani.type == this.type) { // ���� ����?
			return true;
		}
		return false;
	}
	public String toString() {//����Լ� �������̵�
		return this.name+"�̴� "+this.age+"��, "+this.type+"�̰�, "+this.habitat+"�� ��ϴ�!!";
	}
}//Animal ����
//[������]�̿���=====================================================================
abstract class TypeMal extends Animal{ // ������
	TypeMal(String name){
		super(name);
	}
	TypeMal(String name, String habitat, int age){
		super(name, habitat, age);
	}
	void Call() {
		System.out.println(this.name+"�� ");
	}
}
class Bare extends TypeMal{
	Bare(String name){
		this(name, "�˼�����", 0);
	}
	Bare(String name, String habitat, int age){
		super(name, habitat, age);
		this.type= "��(������)";
		System.out.println(this.name+"�̰� ������ ���� ���� ���ϴ�!! \\\\^������^//");
	}
	@Override
	void food() {
		this.Call();
		System.out.println("�ֺ� ����ģ���� ã�� �Խ��ϴ�. ��( ������)�� ");
	}
	@Override
	void play() {
		this.Call();
		System.out.println("��߸� ���ƴٴϸ� ����� �մϴ�!! \\\\('��')�� =33 ");
		
	}
	@Override
	void action() {
		this.Call();
		System.out.println("������ Ÿ�� �ö� ��ġ�� �����մϴ� ������\n");
	}
}
class Cat extends TypeMal{
	Cat(String name){
		this(name, "�˼�����", 0);
	}
	Cat(String name, String habitat, int age){
		super(name, habitat, age);
		this.type= "�����(������)";
		System.out.println("��~��~~ ���翷���� �ٰ��ɴϴ�! (������)__/ \n");
	}
	@Override
	void food() {
		this.Call();
		System.out.println("��Ḧ �Խ��ϴ�. (��'��'��) \n");
	}
	@Override
	void play() {
		this.Call();
		System.out.println("                        ^_^");
		System.out.println("���翡�� ����Ͽ� ��ɳ��̸� �մϴ� (+��+)_ _ } \n");
		
	}
	@Override
	void action() {
		this.Call();
		System.out.println("�ῡ ������ϴ�. . . . . zZz\n");
	}
	
}
class Seal extends TypeMal{
	Seal(String name){
		this(name,"�˼�����", 0);
	}
	Seal(String name, String habitat, int age){
		super(name, habitat, age);
		System.out.println("�˿�!!!! �ݰ���!!! >mm< // \n");
	}
	@Override
	void food() {
		this.Call();
		System.out.println("����⸦ ��ƸԽ��ϴ�. ��mm��\n");
	}
	@Override
	void play() {
		this.Call();
		System.out.println("������ ġ�� ������ ���!  ��mm�� 3 ��~��!! \n");
		
	}
	@Override
	void action() {
		this.Call();
		System.out.println("�λ縦 �մϴ�!! ��!! �ݰ��� �λ����ּ���:D  ^mm^ \n");
	}
	
}*/
public class yena_project {

	public static void main(String[] args) {

/*		Seal s1 = new Seal("����");
		s1.action();*/
		
		
	}//main����

}
//�ұԸ���������Ʈ / �߻�Ŭ����,�������̽�(�ʼ�x) ���� ���谡 �ߵǾ���?
//������ �������� �� �����ϳ�?
//toString(), equals() �������̵��� �ݵ�� �־��ּ���!!
//��Ӵܰ�� ������ 3�ܰ��̻�
//��ü�迭 ���!!
//�����ϰ� �������� ��~~���Ű�xx
// 3����(�� ����)
// 1) ��� Ŭ���� - �׸�,����,�� - ���簢��, ���簢�� 
// 2) ���� Ŭ���� - ����,  ������ - �� ��ѱ� , �� ����� - ������ ��Ʈ����  ��Ƽ�� ���� , �� �ڸ��ȼ���� ����Ƽ����Ʈ
// 3) ĳ����, �÷��̾� Ŭ���� - ���ϸ��� �����ǽ� ������ġ �� - (��)������ ž  ������ (��ġ)��Ŀ ���� ���� (����)�ֹ� �� �� �ܽ��� -  ...
/*abs ANIMAL
String name
String habitat
String aniName
int age;

abs void food
abs void play
abs void action
 equals() -> ���� ��
 toString() -> name�̴� age�� aniName �̰�, habitat�� ��ϴ�!
===============
���������	����������	����������
===============
����Ŭ����:3��

��
�����*/
