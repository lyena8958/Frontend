package day25;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test3 {

	public static void main(String[] args) {
		String url = "https://comic.naver.com/index";
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();//전체페이지
		} catch (IOException e) {
			e.printStackTrace();
		}
		//네이버웹툰이 h6					"alt" --> 속성이라 반영안됨
		Iterator<Element> itr =  doc.select("h6 > a > span").iterator();
		// 접근 시간별로 화면 출력이 달라서 실행누를 때마다 값이바뀜
		 while(itr.hasNext()) {
			 System.out.println(itr.next());
		 }
		 
		 
		 
	}

}
