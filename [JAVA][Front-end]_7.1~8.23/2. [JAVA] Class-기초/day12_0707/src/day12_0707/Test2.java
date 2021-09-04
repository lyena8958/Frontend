package day12_0707;

public class Test2 {
// 클래스는 Test1 클래스에 저장된 Book을 끌고 온다.
	public static void main(String[] args) {
		
		//int[] arr = new int[3];
		
		Book[] data = new Book[3];
		// "붕어빵을 만든다."
		//  == 객체를 생성
		//  == 객체화, 인스턴스화
		//  == new 생성자()  호출
		
		Book book=new Book("기반기반 크로스 플랫폼 개발자 양성과정");
		
		// 1번 방식 -> 단체
		for(int i = 0; i < data.length;i++) {
			data[i] = new Book("책"); 
		}
		data[0] = book; // 2번 방식 -> 개인 ....직접 초기화(객체를 만들어놓고 직접대입)
		for(Book v:data) {
			// System.out.println(v); : 주소값이 나온다.
			v.show();
		}
		

	}

}
