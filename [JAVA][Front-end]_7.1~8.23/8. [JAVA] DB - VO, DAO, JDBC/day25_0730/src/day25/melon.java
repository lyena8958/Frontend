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
         
         // Jsoup은 크롤링할 페이지 데이터를 Document로 받아옴

         Document doc = null;

         try {
            doc = Jsoup.connect(url).get();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

         // select() : 태그(요소, element)를 선택
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
                  name = name.substring(0, (name.lastIndexOf("재")-1));
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
                  System.out.println("안들어가는녀석!" + rank + "." + name + "-" + singer);
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