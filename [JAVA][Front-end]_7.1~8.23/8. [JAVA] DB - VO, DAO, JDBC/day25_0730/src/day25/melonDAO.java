package day25;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.JDBC;

public class melonDAO {

   private Connection conn=null;
   private PreparedStatement pstmt=null;
   static String sql_INSERT = "insert into MELONCHART values(?,?,?)";
   static String sql_SELECT_ALL="select * from MELONCHART order by rank asc";
   public void insert(ArrayList<melonVO> vo_list) {
      melonVO vo;
      conn=JDBC.getConnection();
      try {

         pstmt=conn.prepareStatement(sql_INSERT);
         
         for(int i = 0; i < vo_list.size(); i++) {
            vo = vo_list.get(i);
            pstmt.setInt(1, vo.getRank());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getSinger());
            pstmt.executeUpdate();
         }

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
   }
   public ArrayList<melonVO> selectList() {

      conn=JDBC.getConnection();
      ArrayList<melonVO> datas=new ArrayList();
      try {
         pstmt=conn.prepareStatement(sql_SELECT_ALL);
         ResultSet rs = pstmt.executeQuery();
         while(rs.next()) {
            melonVO vo=new melonVO();
            vo.setRank(rs.getInt("rank"));
            vo.setName(rs.getString("name"));
            vo.setSinger(rs.getString("singer"));
            datas.add(vo);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         JDBC.close(conn, pstmt);
      }
      return datas;
   }
}