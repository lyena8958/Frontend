package test;

class Person{
   Person(String name){
      this.name=name;
   }
   String name;
   void hello() {
      System.out.println("�ȳ��ϼ���~");
   }
}
class Student extends Person{
   Student(String name,int num) {
      super(name);
      this.num=num;
   }
   int num;
   void study() {
      System.out.println("������!!!!!");
   }
   void hello() { // �������̵�
      System.out.println("��������!");
      System.out.println("�ȳ�!");
   }
}
class Teacher extends Person{
   Teacher(String name) {
      super(name);
      this.subject="�ڵ�";
   }
   String subject;
   void teach() {
      System.out.println("�⼮üũ�� �����ϰڽ��ϴ�~~!");
   }
}
public class Test5_1 {

   public static void main(String[] args) {
      
      Student s=new Student("ȫ�浿",11);
      s.hello();
      s.study();
      Teacher t=new Teacher("�ƹ���");
      t.hello();
      t.teach();
      
      
      
      
      
   }

}