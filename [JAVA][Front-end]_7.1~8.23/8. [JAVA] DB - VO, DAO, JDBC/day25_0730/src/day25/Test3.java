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
			doc=Jsoup.connect(url).get();//��ü������
		} catch (IOException e) {
			e.printStackTrace();
		}
		//���̹������� h6					"alt" --> �Ӽ��̶� �ݿ��ȵ�
		Iterator<Element> itr =  doc.select("h6 > a > span").iterator();
		// ���� �ð����� ȭ�� ����� �޶� ���ഩ�� ������ ���̹ٲ�
		 while(itr.hasNext()) {
			 System.out.println(itr.next());
		 }
		 
		 
		 
	}

}
