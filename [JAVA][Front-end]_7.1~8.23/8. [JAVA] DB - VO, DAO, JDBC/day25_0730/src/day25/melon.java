package day25;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import day25.melonDAO;
import day25.melonVO;

public class melon {
   public static void main(String[] args) {
         String url = "https://www.melon.com/chart/index.htm";
         melonDAO dao = new melonDAO();
         ArrayList<melonVO> vo_list = new ArrayList();
         
         // Jsoup�� ũ�Ѹ��� ������ �����͸� Document�� �޾ƿ�

         Document doc = null;

         try {
            doc = Jsoup.connect(url).get();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         // select() : �±�(���, element)�� ����
         Elements elements = doc.select("div > span > a");
         // System.out.println(elements);

         Iterator<Element> itr = elements.iterator();
         int i = 0, rank = 1;
         String name = null;
         String singer = null;
         /*while (itr.hasNext()) {
            System.out.println(itr.next().attr("title"));
         }*/

         while (itr.hasNext()) {
            if (i == 0) {
               name = itr.next().attr("title");
               try {
                  name = name.substring(0, (name.lastIndexOf("��")-1));
                  i++;
               } catch (StringIndexOutOfBoundsException e) {
                  continue;
               }

            } else if (i == 1) {
               singer = itr.next().attr("title");
               try {
            	  
                  singer = singer.substring(0, (singer.lastIndexOf("-")));
                  // System.out.println(rank + "." + singer + " - " + name);
                  melonVO vo = new melonVO();
                  vo.setRank(rank);
                  vo.setName(name);
                  vo.setSinger(singer);
                  vo_list.add(vo);
                  
                  i = 0;
                  rank++;
               } catch (StringIndexOutOfBoundsException e) {
                  System.out.println("�ȵ��³༮!" + rank + "." + name + "-" + singer);
               }
            }
         }
         
         dao.insert(vo_list);
         
         ArrayList<melonVO> voList = new ArrayList();
         voList = dao.selectList();
         
         for(melonVO v : voList) {
            System.out.println(v);
         }

      }
}