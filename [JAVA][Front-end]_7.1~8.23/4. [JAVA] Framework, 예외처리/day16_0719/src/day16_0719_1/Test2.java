package day16_0719_1;
import java.util.ArrayList;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		// 컬렉션 프레임워크
		// 컬렉션 ArrayList
		// : 배열의 확장판
		ArrayList al = new ArrayList(3); 
		al.add(new Point(1,2));
		al.add(new Point(10,20));
		al.add(new Point(11,22));
//		al.add(4); // 크기 제한이 없다.
		System.out.println(al); // toString 오버라이딩
		
		al.add(10);
		for(Object obj:al) {
			System.out.println(obj);
		}
		// 별도의 설정이 없다면, ArrayList는 자신의 요소들을 Object로 판단함
		
		
	}// main종료

}
