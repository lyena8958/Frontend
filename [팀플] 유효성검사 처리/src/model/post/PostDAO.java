package model.post;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.common.DBCP;

public class PostDAO {
	
	// 기본 CRUD
	private static String sql_SELECT_ALL = "SELECT * FROM post";
	private static String sql_SELECT_ONE = "SELECT * FROM post WHERE pnum=?";
	private static String sql_INSERT = 
			"INSERT INTO post (pnum, category, title, content, writer, p_user, path)"
			+ " VALUES((SELECT NVL(MAX(pnum),0) + 1 FROM post), ?, ?, ?, ?, ?, ?)";
	private static String sql_DELETE = "DELETE FROM post WHERE pnum=?";
	private static String sql_UPDATE = "UPDATE post SET category=?, title=?, content=?, writer=?, path=?, pdate=sysdate WHERE pnum=?";
	
	// 사용자 정의 함수
	// 조회수 업, 좋아요 업 다운
	private static String sql_ViewsUp = "UPDATE post SET views=views+1 WHERE pnum=?";
	private static String sql_LikesUp = "UPDATE post SET plike=plike+1 WHERE pnum=?";
	private static String sql_LikesDown = "UPDATE post SET plike=plike-1 WHERE pnum=?";
	// 검색
	private static String sql_SearchPostTitle = "SELECT * from post WHERE title like %?%";
	private static String sql_SearchPostWriter = "SELECT * from post WHERE writer like %?%";
	private static String sql_SearchPostContent = "SELECT * from post WHERE content like %?%";
	// 종류별 정렬
	private static String sql_SELECT_CATEGORY = "SELECT * FROM post WHERE category=?";
	private static String sql_SELECT_VIEWS = "SELECT * FROM post ORDER BY views DESC";
	
	// SELECT ALL -> 전체 글 정보 추출
	public ArrayList<PostVO> SelectAll(){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				vo.setPath(rs.getString("path"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SelectAll()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}

	// SELECT ONE -> 글 보기
	public PostVO SelectOne(PostVO vo) {
		Connection conn=DBCP.connect();
		PostVO data=null;
		PreparedStatement pstmt=null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try{
			pstmt=conn.prepareStatement(sql_SELECT_ONE);
			pstmt.setInt(1, vo.getPnum());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				data=new PostVO();
				data.setPnum(rs.getInt("pnum"));
				data.setViews(rs.getInt("views"));
				data.setPlike(rs.getInt("plike"));
				data.setCategory(rs.getString("category"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				data.setPdate(dateToStr);
				data.setP_user(rs.getString("p_user"));
				data.setPath(rs.getString("path"));
			}	
			rs.close();
		}
		catch(Exception e){
			System.out.println("PostDAO SelectOne()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return data;
	}
	
	// INSERT -> pnum, pdate, views, plike는 자동입력
	public boolean InsertDB(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res = false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			pstmt.setString(5, vo.getP_user());
			pstmt.setString(6, vo.getPath());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO InsertDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// DELETE -> 포스트 삭제
	public boolean DeleteDB(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO DeleteDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}

	// UPDATE -> 카테고리, 제목, 내용 변경
	public boolean UpdateDB(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_UPDATE);
			pstmt.setString(1, vo.getCategory());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getWriter());
			pstmt.setString(5,  vo.getPath());
			pstmt.setInt(6, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO UpdateDB()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// 조회수 ++
	public boolean ViewsUp(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_ViewsUp);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO ViewsUp()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// 좋아요 ++
	public boolean LikesUp(PostVO vo) {
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_LikesUp);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO LikesUp()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	// 좋아요 --
	public boolean LikesDown(PostVO vo) {
		
		Connection conn=DBCP.connect();
		boolean res=false;
		PreparedStatement pstmt=null;
		try{
			pstmt=conn.prepareStatement(sql_LikesDown);
			pstmt.setInt(1, vo.getPnum());
			pstmt.executeUpdate();
			res=true;
		}
		catch(Exception e){
			System.out.println("PostDAO LikesDown()에서 출력");
			e.printStackTrace();
			//res=false;
		}
		finally {
			DBCP.disconnect(pstmt,conn);
		}
		return res;
	}
	
	// 검색기능
	public ArrayList<PostVO> SearchPostTitle(String text){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SearchPostTitle);
			pstmt.setString(1, text);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SearchPostTitle()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ArrayList<PostVO> SearchPostWriter(String text){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SearchPostWriter);
			pstmt.setString(1, text);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SearchPostWriter()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	public ArrayList<PostVO> SearchPostContent(String text){
		Connection conn = DBCP.connect();
		ArrayList<PostVO> datas = new ArrayList();
		PreparedStatement pstmt = null;
		SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
		Date dateOrigin;
		String dateToStr;
		try {
			pstmt = conn.prepareStatement(sql_SearchPostContent);
			pstmt.setString(1, text);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVO vo = new PostVO();
				vo.setPnum(rs.getInt("pnum"));
				vo.setViews(rs.getInt("views"));
				vo.setPlike(rs.getInt("plike"));
				vo.setCategory(rs.getString("category"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				dateOrigin = rs.getDate("pdate");
				dateToStr = dateFix.format(dateOrigin);
				vo.setPdate(dateToStr);
				vo.setP_user(rs.getString("p_user"));
				datas.add(vo);
			}
			rs.close();
		}
		catch(Exception e) {
			System.out.println("PostDAO SearchPostContent()에서 출력");
			e.printStackTrace();
		}
		finally {
			DBCP.disconnect(pstmt, conn);
		}
		return datas;
	}
	
	// SELECT Category -> 카테고리 별 글 정보 추출
    public ArrayList<PostVO> SelectCategory(PostVO vo){
       Connection conn = DBCP.connect();
       ArrayList<PostVO> datas = new ArrayList();
       PreparedStatement pstmt = null;
       SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
       Date dateOrigin;
       String dateToStr;
       try {
          pstmt = conn.prepareStatement(sql_SELECT_CATEGORY);
          pstmt.setString(1, vo.getCategory());
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()) {
             PostVO data = new PostVO();
             data.setPnum(rs.getInt("pnum"));
             data.setViews(rs.getInt("views"));
             data.setPlike(rs.getInt("plike"));
             data.setCategory(rs.getString("category"));
             data.setTitle(rs.getString("title"));
             data.setContent(rs.getString("content"));
             dateOrigin = rs.getDate("pdate");
             dateToStr = dateFix.format(dateOrigin);
             data.setPdate(dateToStr);
             data.setP_user(rs.getString("p_user"));
             datas.add(data);
          }
          rs.close();
       }
       catch(Exception e) {
          System.out.println("PostDAO SelectCategory()에서 출력");
          e.printStackTrace();
       }
       finally {
          DBCP.disconnect(pstmt, conn);
       }
       return datas;
    }
    
    // SELECT VIEWS -> 전체 글 정보 조회수 정렬 해서 반환
    public ArrayList<PostVO> SelectViews(){
       Connection conn = DBCP.connect();
       ArrayList<PostVO> datas = new ArrayList();
       PreparedStatement pstmt = null;
       SimpleDateFormat dateFix = new SimpleDateFormat("yyyy-MM-dd");
       Date dateOrigin;
       String dateToStr;
       try {
          pstmt = conn.prepareStatement(sql_SELECT_VIEWS);
          ResultSet rs = pstmt.executeQuery();
          while(rs.next()) {
             PostVO vo = new PostVO();
             vo.setPnum(rs.getInt("pnum"));
             vo.setViews(rs.getInt("views"));
             vo.setPlike(rs.getInt("plike"));
             vo.setCategory(rs.getString("category"));
             vo.setTitle(rs.getString("title"));
             vo.setContent(rs.getString("content"));
             dateOrigin = rs.getDate("pdate");
             dateToStr = dateFix.format(dateOrigin);
             vo.setPdate(dateToStr);
             vo.setP_user(rs.getString("p_user"));
             datas.add(vo);
          }
          rs.close();
       }
       catch(Exception e) {
          System.out.println("PostDAO SelectViews()에서 출력");
          e.printStackTrace();
       }
       finally {
          DBCP.disconnect(pstmt, conn);
       }
       return datas;
    }
	
}
