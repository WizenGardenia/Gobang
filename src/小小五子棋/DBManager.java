package 小小五子棋;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
	private Connection con;
	private Statement sta;
	private ResultSet rs;
	/********************静态块可以提高效率***********/
	static {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 加载驱动程序
	 */
	
	public Connection getConnection(){

		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Gobang";
		try {

			con = DriverManager.getConnection(url, "sa", "20001016");
			sta = con.createStatement();
			System.out.println("链接成功");
		} catch (SQLException e) {
			System.out.println("连接失败");
			e.printStackTrace();
		}
		
		return con;
	}
	
	/*public DBManager() {
		List<Connection> list = new ArrayList<Connection>();
		for (int i = 0; i < 5; i++) {
			list.add(this.getConnection());
		}
		this.con = list.get(0);
	}*/
	public int update(String sql){
		int row = -1;
		con = getConnection();
		try {
			row = sta.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.close();
		}
		return row;
	}
	
	public ResultSet query(String sql){
		con = getConnection();
		try {
			rs = sta.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close(){
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (sta != null) {
				sta.close();
				sta = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ResultSet query(){
		con = getConnection();
		try {
			String sql="select * from result ";
			rs = sta.executeQuery(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
}
