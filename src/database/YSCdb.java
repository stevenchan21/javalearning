package database;

import java.sql.*;

/*import com.mysql.jdbc.*;*/

public class YSCdb {
	
	public void insertData() {
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String connURL ="jdbc:mysql://localhost/yscprinting?user=root&password=Apple1234";
		Connection conn =  DriverManager.getConnection(connURL); 
		PreparedStatement pStmt = conn.prepareStatement("INSERT INTO Inquiries (Product,Size,Orientation) values(?,?,?)");
		pStmt.setString(1, "poster");
		pStmt.setString(2, "A4");
		pStmt.setString(3, "Orientation");
		
		int rows = pStmt.executeUpdate();
		System.out.println("Rows impacted: " + rows);
		conn.close();
		}
		catch(Exception e){
		System.out.println(e);
		}
		
	}
}
