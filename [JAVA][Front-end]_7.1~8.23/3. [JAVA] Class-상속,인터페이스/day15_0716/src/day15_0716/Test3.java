package day15_0716;

class Point{
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	int x;
	int y;
	public String toString() {
		return "P"+"("+this.x+","+this.y+")";
	}
	//타 클래스에 오버라이딩이 여러번 일어날 수 있으니 object로 받는게 좋다
	public boolean equals(Object obj) {//오버라이딩: 문법적으론 틀리지 않았으나 Point obj해도된다. 다만, 다른클래스를 비교할수없게됨
		// 인자는  한개이나 비교가 두개인이유?? 클래스를받을때 멤버변수를 다 갖고오기때문이다.
		
		Point p=(Point)obj; //Point obj로 인자를 받으면 형변환 안해줘도됨
		// 형변환 == ☆캐스팅☆ 		//강제형변환(자료형변환)
		
		if(p.x==this.x) { // p.x==this.x && p.y==this.y
			if(p.y==this.y) {
				return true;
			}
		}
		return false;
	}
}
public class Test3 {

	public static void main(String[] args) {
		
		Point[] data = new Point[3];
		data[0]=new Point(10,11);
		data[1]=new Point(10,11);
		data[2]=new Point(10,11);
		
		for(Point p: data) {
			System.out.println(p);
		}
		
		String str; // == String extends Object -> equals()를 오버라이딩
		
		
		if(data[0]==data[1]) { // data[0]==data[1] -> 실제주소를 비교하기 때문에 다르다.
			System.out.println("1");
		}
		else {
			System.out.println("확인");
		}
		// "최상위클래스" Object 바로 호출하여 사용
		// String -> equals()를 오버라이딩
		if(data[0].equals(data[2])) {//오버라이딩 시도! 위에
			System.out.println("2");
		}
	}

}
