package day21_0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test6 {

   public static void main(String[] args) {
// db - SQL File 7
	   // 자바 -> db 
      String DName="com.mysql.cj.jdbc.Driver";

      String url="jdbc:mysql://localhost:3308/leedb";
      String user="root";
      String password="8958";

      Connection conn=null;
      Statement stmt=null;
      // ResultSet의 경우에는 select문으로 검색한 데이터들의 집합
      // CUD(insert, update, delete) 결과가 없음(기능만) == RS가 필요하지 않다.
      String sqlC="insert into student values(1003, '아리',10,3,'C')";
      
   // 아무무번호 1002 -> 점수 80, 등급 B로 변경!!
      String sqlU="update student set score=80,grade='B' where snum=1002"; 
      String sqlD="delete from student where snum=1003";
      
      try {
         Class.forName(DName);

         conn=DriverManager.getConnection(url, user, password);
      
         stmt=conn.createStatement();
        // stmt.executeUpdate(sqlC); // insert
         //  stmt.executeUpdate(sqlD); // delete
       stmt.executeUpdate(sqlU);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            stmt.close();
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }

   }

}