package test;

class Person{
   Person(String name){
      this.name=name;
   }
   String name;
   void hello() {
      System.out.println("안녕하세요~");
   }
}
class Student extends Person{
   Student(String name,int num) {
      super(name);
      this.num=num;
   }
   int num;
   void study() {
      System.out.println("공부중!!!!!");
   }
   void hello() { // 오버라이딩
      System.out.println("하이하이!");
      System.out.println("안녕!");
   }
}
class Teacher extends Person{
   Teacher(String name) {
      super(name);
      this.subject="코딩";
   }
   String subject;
   void teach() {
      System.out.println("출석체크를 시작하겠습니다~~!");
   }
}
public class Test5_1 {

   public static void main(String[] args) {
      
      Student s=new Student("홍길동",11);
      s.hello();
      s.study();
      Teacher t=new Teacher("아무무");
      t.hello();
      t.teach();
      
      
      
      
      
   }

}