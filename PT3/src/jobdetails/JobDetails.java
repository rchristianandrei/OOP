package jobdetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JobDetails {

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/hr?&serverTimezone=UTC";
	private static String user = "root";
	private static String password = "mypassword";
	
	public static void main(String[] args) {
	
		jobsTable();
		System.out.println();
		departmentsTable();
		System.out.println();
		historyTable();
	}
	
	private static void jobsTable() {
		
		try{
			
			Class.forName(driver);
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from jobs;");
				
				System.out.println("Jobs Table");
				System.out.println("Job ID\tJOB Title\tMin Salary\tMax Salary"); 
				
				while(rs.next()) {
					
					System.out.println(rs.getString(1) + "\t" 
					        + rs.getString(2) + "\t" 
							+ rs.getString(3) + "\t"
							+ rs.getString(4));
				}
				
				rs.close();
				st.close();
			}
			catch(SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		catch(ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
	}

	private static void departmentsTable() {
		
		try{
			
			Class.forName(driver);
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from departments;");
				
				System.out.println("Departments Table");
				System.out.println("DEPARTMENT_ID\tDEPARTMENT_NAME\tMANAGER_ID\tLOCATION_ID"); 
				
				while(rs.next()) {
					
					System.out.println(rs.getString(1) + "\t" 
					        + rs.getString(2) + "\t" 
							+ rs.getString(3) + "\t"
							+ rs.getString(4));
				}
				
				rs.close();
				st.close();
			}
			catch(SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		catch(ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	private static void historyTable() {
		
		try{
			
			Class.forName(driver);
			
			try {
				
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from job_history;");
				
				System.out.println("Job History Table");
				System.out.println("EMPLOYEE_ID\tSTART_DATE\tEND_DATE\tJOB_ID\tDEPARTMENT_ID"); 
				
				while(rs.next()) {
					
					System.out.println(rs.getString(1) + "\t" 
					        + rs.getString(2) + "\t" 
							+ rs.getString(3) + "\t"
							+ rs.getString(4) + "\t"
							+ rs.getString(5));
				}
				
				rs.close();
				st.close();
			}
			catch(SQLException e) {
				
				System.out.println(e.getMessage());
			}
		}
		catch(ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
