package day14_0715_2;
// �����

abstract class Phone{ // == smartphone
	Watch2 watch;
	String name;
	// ��� �ڵ�������...
	// ������� �̸� or ������� �̸�+��ġ �� �����־�ߵ�!! ��
	Phone(String name){ //��ġ�� ���� ���
		this(null, name);
	}
	Phone(Watch2 watch, String name){
		this.watch = watch;
		this.name = name;
		System.out.println(this.name+"��, �� ��ϿϷ�!");
	}
	void show() {
		System.out.print(this.name+"���� ��ġ: ");
		if(watch==null) {
			System.out.println("��Ͼȵ�");
		}
		else {
			System.out.println(watch.name);
		}
		System.out.println(); // [����/����Ʈ/��Ͼȵ�]
	}
	abstract void call();
}
class IPhone2 extends Phone{
	IPhone2(String name) {
		this(null,name);
	}
	IPhone2(Watch2 watch, String name) {
		super(watch, name);
	}

	@Override
	void call() {
		System.out.println("�ø���~~~");
		
	}
	
}
class Galaxy2 extends Phone{

	Galaxy2(String name) {
		this(null,name);
	}
	Galaxy2(Watch2 watch, String name) {
		super(watch, name);
	}

	@Override
	void call() {
		// TODO Auto-generated method stub
		
	}
	
}
abstract class Watch2 implements useWatch2{ 
	// Watch2 �� �߻�Ŭ������ �����ϸ�, �ڽ�Ŭ��������
	//  �߻� �޼ҵ带 �����ؾ��Ѵ�.
	String name;

//	@Override
//	public void soundUp() {
//		System.out.println("�Ҹ�++");
//		
//	}
//
//	@Override
//	public void soundDown() {
//		System.out.println("�Ҹ�--");
//		
//	}
	
}
interface useWatch2{
	// ��ü�� ���� ������ �߻�޼ҵ尡 �Ʊ⶧����
	void soundUp();
	void soundDown();
}
class AppleWatch2 extends Watch2{ 
	//�θ�޼��尡 �߻�޼ҵ带 �����߱� ������ �ڽĿ����� ����xxx
	// �θ�޼��带 �߻�Ŭ������ �ٲ�� �ڽ��� ��� �߻�޼ҵ带 �Է��ؾ��Ѵ�. ��
	AppleWatch2(){
		this.name = "����";
	}
	public void soundDown() { //���� �ٿ� �������̵�
		System.out.println(this.name+"--");
	}
	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println(this.name+"++");
	}
}
class SmartWatch2 extends Watch2{ //�θ�޼��尡 �߻�޼ҵ带 �����߱� ������ �ڽĿ����� ����xxx
	SmartWatch2(){
		this.name = "����Ʈ";
	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("�Ҹ� �ö󰩴ϴ�.");
	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("�Ҹ� �������ϴ�.");
	}
}


//�����ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
interface useWatch{
	void soundUp();
	void soundDown();
}
abstract class Watch implements useWatch{
	String name;
	Watch(){
		this("��Ͼȵ�");
	}
	Watch(String name){
		this.name = name;
	}
	@Override
	public void soundUp() {
		System.out.println("���� ��!");
	}

	@Override
	public void soundDown() {
		System.out.println("���� �ٿ�!");
	}
}
class AppleWatch extends Watch {
	AppleWatch() {
		super("����");
	}
}
class SmartWatch extends Watch{
	SmartWatch() {
		super("����Ʈ");
	}	
}
abstract class SmartPhone{
	SmartPhone(String name){
		//this(name, watch); // ?????????????
	}
	SmartPhone(String name, Watch watch){
		this.name = name;
		this.watch = watch;
	}
	String name;
	Watch watch;
	void show() {
		System.out.println(this.name+"���� ��ġ: "+this.watch); // ����/����Ʈ/��Ͼȵ�
	}
	abstract void call();
}
class IPhone extends SmartPhone {
	IPhone(String name) {
		super(name);
		System.out.println(this.name+"�� ȯ���մϴ�! ������ ����");
	}

	void call() {
		System.out.println("�ø���!!");
	}
}
class Galaxy extends SmartPhone{
	
	Galaxy(String name) {
		super(name);
		System.out.println(this.name+"�� ȯ���մϴ�! ������ ����");
	}

	void call() {
		System.out.println("���� �򽺺�!");
	}
}

public class Test1 {

	public static void main(String[] args) {
		//����
	/*	����Ʈ��-> watch�� ����, �̸��Է��� �ʼ�!
	    -Watch  watch;
	    -String name;
	    -void show()
	   _____���� ��ġ: [����/����Ʈ/��Ͼȵ�]
	    -void call() �ݵ�� �������̵��ؾ���
	������    ������
	call() �ø�    call() �򽺺�

	Watch
	   String name
	   void soundUp()
	   void soundDown()

	AppleWatch        SmartWatch
	name=����   name=����Ʈ.*/
		
		// �����
		IPhone2 p1 = new IPhone2("ȫ�浿");
		p1.call();
		p1.watch = new AppleWatch2();
		p1.show();
		
		Galaxy2 p2 = new Galaxy2(new SmartWatch2(),"�ƹ���");
		p2.show();
	
		// ���� ������ ������ Ŭ������ �޼��尡 �ƴ�,
		// ���� ������ ��ü�� �޼��带 ã�Ƽ� �����Ѵ�!!!!!
		p1.watch.soundUp();
		// ���� Phone�� soundUp �޼ҵ� �������ѵ� ����� ��ü�� ã�ư���. 
		p2.watch.soundUp();
		// "���������� ����(����)�Ǿ���." 
		// ����ڴ� watch��� ��ü���� soundUp()�� ȣ���ߴµ�,
		// ������ ���۵Ȱ��� appleWatch�� soundUp()�϶�!
		// "�������ε�"�� �Ͼ��!!! == �������� �����ƴ�.
	
		
		
		
		
	}
	
	
	

}
