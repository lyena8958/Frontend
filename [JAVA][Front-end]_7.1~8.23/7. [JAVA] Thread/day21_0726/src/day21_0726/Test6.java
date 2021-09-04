package day21_0726;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test6 {

   public static void main(String[] args) {
// db - SQL File 7
	   // �ڹ� -> db 
      String DName="com.mysql.cj.jdbc.Driver";

      String url="jdbc:mysql://localhost:3308/leedb";
      String user="root";
      String password="8958";

      Connection conn=null;
      Statement stmt=null;
      // ResultSet�� ��쿡�� select������ �˻��� �����͵��� ����
      // CUD(insert, update, delete) ����� ����(��ɸ�) == RS�� �ʿ����� �ʴ�.
      String sqlC="insert into student values(1003, '�Ƹ�',10,3,'C')";
      
   // �ƹ�����ȣ 1002 -> ���� 80, ��� B�� ����!!
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