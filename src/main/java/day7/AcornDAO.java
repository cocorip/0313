package day7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//테이블(acorntbl) 하나당 DAO(crud) 한개
public class AcornDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:testdb";
	String user="scott";
	String password="tiger";
	
	public Connection dbcon() {
		Connection con=null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			if(con != null) System.out.println("db ok");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//학생정보 조회
	public ArrayList<Acorn> selectAll(){
		ArrayList<Acorn> list = new ArrayList<>();
		//db 연결
		Connection con = dbcon();
		
		//sql 작성
		String sql = "select * from acorntbl";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				Acorn a = new Acorn(id,pw,name);
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//실행된 결과
		
		return list;
	}
	
	//등록
	public void insertMember(Acorn newAcorn) {
		//db 연결
		Connection con = dbcon();
		//sql 작성
		String sql = "insert into acorntbl values(?,?,?)";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newAcorn.getId());
			pst.setString(2, newAcorn.getPw());
			pst.setString(3, newAcorn.getName());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//한사람 조회
	public Acorn selectOne(String id) {
		Connection con = dbcon();
		String sql = "select * from acorntbl where id=?";
		Acorn acorn=null;
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				acorn = new Acorn(rs.getString(1),rs.getString(2),rs.getString(3));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acorn;
		
	}
	
	public void update(String id, String newpw) {
		Connection con = dbcon();
		String sql = "update acorntbl set pw=? where id =?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newpw);
			pst.setString(2, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(String id) {
		Connection con = dbcon();
		String sql = "delete from acorntbl where id = ?";
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		AcornDAO a = new AcornDAO();
		
		a.delete("lra");
		ArrayList<Acorn> list = a.selectAll();
		for(Acorn acorn : list) {
			System.out.println(acorn);
		}
		//Acorn ac = new Acorn("jin","0888","배기진");
		//a.insertMember(ac);
	}
}
