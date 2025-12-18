package StudentCRUD;

import java.sql.*;
import java.util.Scanner;

public class StudentCrud {
	
	//DATABASE details
	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String USER ="root";
	static final String PASSWORD ="root";
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static Scanner sc = new Scanner(System.in);
	
	//DB connection
	public static void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	//For INSERT 
	public static void insertStudent() {
		try {
			String sql = "INSERT INTO student VALUES (?, ?, ?, ?)";
			ps = con.prepareStatement(sql);
			
			System.out.println("Enter ID: ");
			ps.setInt(1, sc.nextInt());
			
			System.out.println("Enter name: ");
			ps.setString(2, sc.next());
			
			System.out.println("Enter age: ");
			ps.setInt(3, sc.nextInt());
			
			System.out.println("Enter course Name: ");
			ps.setString(4, sc.next());
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "Student inserted successfully..");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//For UPDATE
	public static void updateStudent() {
		try {
			String sql = "UPDATE student SET name=?, age=?, course=? WHERE id=?";
			ps = con.prepareStatement(sql);
			
			System.out.println("Enter new name: ");
			ps.setString(1, sc.next());
			
			System.out.println("Enter new age: ");
			ps.setInt(2, sc.nextInt());
			
			System.out.println("Enter new course: ");
			ps.setString(3, sc.next());
			
			System.out.println("Enter ID to update: ");
			ps.setInt(4, sc.nextInt());
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "Student updated successfully..");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//For Delete
	public static void deleteStudent() {
		try {
			String sql = "DELETE FROM student WHERE id=?";
			ps = con.prepareStatement(sql);
			
			System.out.println("Enter ID to delete: ");
			ps.setInt(1, sc.nextInt());
			
			int rows = ps.executeUpdate();
			System.out.println(rows + "Student Deleted successfully..");
		}
		catch(Exception ex){
			ex.printStackTrace();		
		}
	}

	//For Display
	public static void displayStudent() {
		try {
			String sql = "SELECT * from student";
			ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("ID \t Name \t Age \t Course");
			System.out.println("---------------------------------");
			
			while (rs.next()) {
				System.out.println(
						rs.getInt("id")+ "\t" +
					    rs.getString("name")+ "\t" +
					    rs.getInt("age")+ "\t" +
					    rs.getString("course"));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Close resources
	public static void closeResources() {
		try {
			if(ps != null) ps.close();
			if(con != null) con.close();
			sc.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Main method
	public static void main(String[] args) {
		connect();
		int choice;
		
		do {
			System.out.println("\n---STUDENT MENU---");
			System.out.println("1. Insert Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Display Student");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choice: ");
			choice = sc.nextInt();
			
			switch(choice) {
			case 1: insertStudent(); break;
			case 2: updateStudent(); break;
			case 3: deleteStudent(); break;
			case 4: displayStudent(); break;
			case 5: closeResources();
				System.out.println("Application closed");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}
		while(choice != 5);
	}
}
