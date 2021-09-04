package day25;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
// -> ojdbc6.jar

public class Test2 {

	public static void main(String[] args) {

		// Jsoup을 이용해서 naver에서 크롤링
		// 크롤링한 url지정
		// URL : 페이지?데이터   (?표이전 페이지 의미 ,  ?표이후 데이터 의미)
		String url = "https://www.naver.com/";
		// http 통신규약(신호등) 업그레이드 된 버전 -> https
		
		// Document == 페이지
		// Jsoup은 크롤링할 페이지 데이터를 Document로 받아옴
		Document doc = null; // == (StudentVO vo = null 와 같은형식)
		
		try {// doc<-반환
			doc = Jsoup.connect(url).get(); // 크롤링에서는 conn을 안닫아줘도 되기 때문에 바로 메서드 사용함(편의상 conn는 클래스도 있음)
		} catch (IOException e) {
			e.printStackTrace();
		} //커넥션객체
		
		
		//System.out.println(doc);
		
		// select() : 태그(요소, element)를 선택 , 오버로딩 되었음
		Elements elements =  doc.select("img.news_logo");
		System.out.println(elements+"★");
		
		// iterator 반환 -> iterator<Element> 제네릭으로 되어있다.
		Iterator<Element> itr = elements.select("alt").iterator(); // alt항목 선택
		//Elements elements =doc.select("img.news_logo").select("alt");
		
		// elements.select("alt");
		
		while(itr.hasNext()) { // 다음이있다면
			System.out.println(itr.next());
		}
		
		
		
		
	}//main종료

}
