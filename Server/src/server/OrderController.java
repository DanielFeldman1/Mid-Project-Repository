package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderController {

	protected Connection conn;
	public int successFlag;

	public OrderController(String dbname, String pass) {
		String connectPath = "jdbc:mysql://localhost/" + dbname + "?serverTimezone=IST";
		connectToDB(connectPath, pass);
	}

	public void connectToDB(String path, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver definition succeed");
		} catch (Exception ex) {
			/* handle the error */
			System.out.println("Driver definition failed");
		}

		try {
			conn = DriverManager.getConnection(path, "root", pass);
			System.out.println("SQL connection succeed");
			successFlag = 1;
		} catch (SQLException ex) {/* handle any errors */
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			successFlag = 2;
		}
	}

	public ResultSet importOrderDB() {
		Statement stmt;
		ResultSet rs = null;
		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM orders;"); // tble called order
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public ResultSet importRestaurants() {
		Statement stmt;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT DISTINCT Restaurant_Name FROM dbrestuarant");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public String returnSpecificOrder(String orderNum) {
		Statement stmt;
		ResultSet rs = null;
		String str = "";
		String qry = "select * from orders where Order_number=" + orderNum + ";";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(qry);
			if (rs.next()) {
				str = "SpecificOrderSuccess: " + rs.getString(1) + " " + rs.getString(3) + " " + rs.getString(4) + " "
						+ rs.getString(5);
			} else {
				str = "SpecificOrderFail";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}

	public int UpdatePrice(String orderNum, String newPrice) {
		PreparedStatement stmt;
		int check = 0;
		try {
			stmt = conn.prepareStatement("update orders set Total_price=? where Order_number=?; ");
			stmt.setString(1, newPrice);
			stmt.setString(2, orderNum);
			check = stmt.executeUpdate();
			if (check == 0) {
				return 2; // no fitting order
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

	public int UpdateAddress(String orderNum, String newAddress) {
		PreparedStatement stmt = null;
		int check = 0;
		try {
			stmt = conn.prepareStatement("update orders set Order_address=? where Order_number=?; ");
			stmt.setString(1, newAddress);
			stmt.setString(2, orderNum);
			check = stmt.executeUpdate();
			System.out.println("here? " + check);
			if (check == 0) {
				return 2; // no fitting order
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}

		return 1;
	}

}
