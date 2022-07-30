import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyConnection {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/oop_db?&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "mypassword";
	
	static void getCredentials(String query) {
		try {
			Class.forName(driver);
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				if(rs.next()) {
					Account.username = rs.getString(2);
					Account.password = rs.getString(3);
				}
				
				con.close();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	
	static Data getQuery(String query, JFrame frame) {
		
		try {
			
			Class.forName(driver);
			
			try {
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				ResultSetMetaData md = rs.getMetaData();
				
				int colNum = getColumnNames(rs);
				ArrayList<String> cols = new ArrayList<>();
				ArrayList<ArrayList<Object>> entries = new ArrayList<>();
				
				for(int i = 1; i <= md.getColumnCount(); i++) {
					
					cols.add(md.getColumnName(i));
				}
				
				String[] newCols = new String[cols.size()];
				
				for(int i = 0; i < newCols.length; i++) {
					
					newCols[i] = cols.get(i);
				}
				
				if(colNum > 0) {
					
					while(rs.next()) {
						
						ArrayList<Object> temp = new ArrayList<>();
						
						for(int i = 0; i < colNum; i++) {
							
							temp.add(rs.getString(i+1));
						}
						
						entries.add(temp);
					}
				}
				
				if(entries.size() <= 0){
					
					message("Empty Data", frame);
					return new Data(null, null);
				}
				
				Object[][] newEntries = new Object[entries.size()][entries.get(0).size()];
				
				for(int i = 0; i < entries.size(); i++) {
					
					Object[] temp = new Object[entries.get(0).size()];
					
					for(int j = 0; j < temp.length; j++) {
						
						temp[j] = entries.get(i).get(j);
					}
					
					newEntries[i] = temp;
				}
				
				con.close();
				
				return new Data(newCols, newEntries);
			}
			catch(SQLException e) {
				
				message(e.getMessage(), frame);
			}
		}
		catch(ClassNotFoundException e) {
			
			message(e.getMessage(), frame);
		}
		
		message("Empty Data", frame);
		return new Data(null, null);
	}
	
	private static int getColumnNames(ResultSet rs) throws SQLException {
		
		int numberOfColumns = 0;
		
		if (rs != null) {
			ResultSetMetaData rsMetaData = rs.getMetaData();
			numberOfColumns = rsMetaData.getColumnCount();

			for (int i = 1; i < numberOfColumns + 1; i++) {
				String columnName = rsMetaData.getColumnName(i);
			}
		}
		return numberOfColumns;
	}
	
	static void addQuery(String query, JFrame frame) {
		
		try {
			
			Class.forName(driver);
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				st.execute(query);
			}
			catch(SQLException e) {
				
				message(e.getMessage(), frame);
			}
		}
		catch(ClassNotFoundException e) {
			
			message(e.getMessage(), frame);
		}
	}
	
	static private void message(String mssg, JFrame frame) {
		
		JOptionPane.showMessageDialog(frame, mssg, "Connection", JOptionPane.WARNING_MESSAGE);
	}
}
