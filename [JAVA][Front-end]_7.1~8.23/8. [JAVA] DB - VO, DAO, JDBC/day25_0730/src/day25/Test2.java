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

		// Jsoup�� �̿��ؼ� naver���� ũ�Ѹ�
		// ũ�Ѹ��� url����
		// URL : ������?������   (?ǥ���� ������ �ǹ� ,  ?ǥ���� ������ �ǹ�)
		String url = "https://www.naver.com/";
		// http ��űԾ�(��ȣ��) ���׷��̵� �� ���� -> https
		
		// Document == ������
		// Jsoup�� ũ�Ѹ��� ������ �����͸� Document�� �޾ƿ�
		Document doc = null; // == (StudentVO vo = null �� ��������)
		
		try {// doc<-��ȯ
			doc = Jsoup.connect(url).get(); // ũ�Ѹ������� conn�� �ȴݾ��൵ �Ǳ� ������ �ٷ� �޼��� �����(���ǻ� conn�� Ŭ������ ����)
		} catch (IOException e) {
			e.printStackTrace();
		} //Ŀ�ؼǰ�ü
		
		
		//System.out.println(doc);
		
		// select() : �±�(���, element)�� ���� , �����ε� �Ǿ���
		Elements elements =  doc.select("img.news_logo");
		System.out.println(elements+"��");
		
		// iterator ��ȯ -> iterator<Element> ���׸����� �Ǿ��ִ�.
		Iterator<Element> itr = elements.select("alt").iterator(); // alt�׸� ����
		//Elements elements =doc.select("img.news_logo").select("alt");
		
		// elements.select("alt");
		
		while(itr.hasNext()) { // �������ִٸ�
			System.out.println(itr.next());
		}
		
		
		
		
	}//main����

}
