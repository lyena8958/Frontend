package day24_0729;
// DAO : Data Access Object , DB�� �����ϴ� ��ü
// �� VO�� ����Ǵ� Ŭ���� ��

//MODEL
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// jdbc�κ��� ���� 
public class TestDAO {
	
	static String sql_SELECT_ONE = "select * from test where a=?";
	static String sql_SELECT_ALL = "select * from test where b like '%?%' order by a asc";
	static String sql_INSERT = "insert into test values (?, ?)";
	static String sql_UPDATE = 	"update test set b=?, c=? where a=?";
	static String sql_DELETE = 	"delete from test where a=?";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;

	// CRUD �׻� ������ �Ǿ���Ѵ�! --> Ư���� ��찡 �ƴ϶�� (id/pw��)
	// insert select(���ϰ�ü),select(���) update delete


	// select(����)��ü�� �޴´� --> object..?
	//  �׷��� --> ��ü?? VO���� ���̺��� "��ü"�� �����ϴ� ����Ÿ���� TestVo�� ���ش�!!
	
	// select(����)
	// Ŭ���� ���� select �̳�, �ش� ����� ���� �������⶧���� getTest�� Ŭ�����������Ѵ�.
	
	//������ ���ڸ� vo�� �����ִ°� ��Ģ�̴�!��
	public TestVO getTest(TestVO vo) { // int a : ����ڰ� select�� �ѹ��� ����
		//String sql = "select * from test where a=?"; // ? : ������ pk�� �־�����Ѵ�.
		conn=JDBC.getConnection(); // jdbc �޼��忡�� ����̹����� �� db�����Ѵ�.		
		
		//������ ������ ������ �̸� ������ش�.
		//TestVO vo = new TestVO(); //TestVo Ŭ������ ��ü����
		TestVO data= null; //���� �˻������ ���ٸ� null�� ���ϵ�! To.view
		//������ data, ������ �����͸� datas
		
		try {
			pstmt = conn.prepareStatement(sql_SELECT_ONE); //db����
			pstmt.setInt(1, vo.getA());
			ResultSet rs =  pstmt.executeQuery();
			
			if(rs.next()) {// ���� ã�� �����Ͱ� ������ ���� �޸𸮸� �Ѱ��ش�. 
				data = new TestVO(); // �޸𸮰������� new�� ��������.
				data.setA(rs.getInt("a"));
				data.setB(rs.getString("b"));
				vo.setC(rs.getInt("c"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC.close(conn, pstmt);// DB���� ��ü����
		}
		System.out.println("getTest() ����Ϸ�"); // ������ �˷��ִ� Ȯ������
		return data;
	}
	
	// select ���
	// ���̹� �˻�â '�Ƹ�'��� �˻��ϸ� ���� �˻�� �ߵ��� ���Ȱ� ���!!
	// �˻��ϰ���� ������ ��üȭ �ϴ°� == vo
	public ArrayList<TestVO> getTestList(TestVO vo){//int, str ��� ���� �� ������ ��ü��ü��
		//	String sql = "select * from test order by a asc"; // ��ü���(aĮ���� ��������!!)  // desc
	//String sql = "select * from test where b like '%?%' order by a asc";
		
		conn=JDBC.getConnection(); // db����
		ArrayList<TestVO> datas = new ArrayList(); // ������ �־���ϹǷ� ��üȭ����
		
		try {//-> �����ؾ���
	         pstmt=conn.prepareStatement(sql_SELECT_ALL);
	         pstmt.setString(1, vo.getB());  // '%Ƽ%'// ?�� 10�� �ְڽ��ϴ�. (?�ڸ���: 1)
	         ResultSet rs=pstmt.executeQuery();
	         while(rs.next()) {
	            TestVO data=new TestVO(); // �⺻������->��������� ��xxx
	            data.setA(rs.getInt("a"));
	            data.setB(rs.getString("b"));
	            data.setC(rs.getInt("c"));
	            datas.add(data);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("getTestList() ����Ϸ�"); // ������ �˷��ִ� Ȯ������
		return datas;
	}
	
	// insert
	public void insertTest(TestVO vo){ // int a, String b
		//String sql = "insert into test values (?, ? ,?)";
		conn = JDBC.getConnection();
		try {
	         pstmt=conn.prepareStatement(sql_INSERT); //sql
	         pstmt.setInt(1, vo.getA());
	         pstmt.setString(2, vo.getB());
	         pstmt.setInt(3, vo.getC());
	         pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("insertTest() ����Ϸ�"); // ������ �˷��ִ� Ȯ������
	}
	
	// update ����
	public void updateTest(TestVO vo, String b){
		
		String sql = "update test set b = ? where a = ?";
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, b); // ������ b
			pstmt.setInt(2, vo.getA()); // ����� ã�� pk
			pstmt.executeUpdate();
			vo.setB(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("updateTest() ����Ϸ�");
	}
	
	// delete ����
	public void daleteTest(int a){
		String sql = "delete from test where a = ?";
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, a);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		
		System.out.println("deleteTest() ����Ϸ�");

	}
	
	// ����� update
	public void updateTest(TestVO vo) { // ������������ ȸ�������������� �����غ���!
		//�Ϲ������� ��� Į���� �ٲ۴�. ����������-> ��й�ȣ �ٲٸ� ��� ������Ʈ�� �ȴ���
		//�ѹ��� ó������������ ��ȭ��ȣ����, �̸�����, �������� ������ Ȯ���ؾ��ϴϱ�.
		//String sql = "update test set sname=?,score=?,phont=?  where id = ?";
		
		//String sql = "update test set b=?, c=? where a=?";
		conn = JDBC.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql_UPDATE); // sql
			pstmt.setString(1, vo.getB());
			pstmt.setInt(2, vo.getC());
			pstmt.setInt(3, vo.getA());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("updateTest ����Ϸ�!");
		
	}
	
	// ����� delete
	public void deleteTest(TestVO vo) { // getTest�� ���

		//String sql = "delete from test where a=?";
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(sql_DELETE); //sql
			pstmt.setInt(1, vo.getA());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBC.close(conn, pstmt);
		}
		System.out.println("deleteTest ����Ϸ�!");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
