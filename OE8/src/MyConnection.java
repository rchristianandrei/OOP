import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnection {
	
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost:3306/oop_db?&serverTimezone=UTC";
	private final String user = "root";
	private final String password = "mypassword";
	
	void createQuery(String statement) {
		
		try {
			Class.forName(driver);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet result = st.executeQuery(statement);
			
			if(result.next()) {
				Account.setUsername(result.getString(2));
				Account.setPassword(result.getString(3));
			}
			
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Exception!");
		}
	}
}
