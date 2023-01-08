package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {
	private static List<Connection> freeDbConnections; 
	
	static {
		freeDbConnections =new LinkedList<Connection>(); 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		}catch(ClassNotFoundException e) {
			System.out.println(e);;
		}
	}	
	
	private static Connection createDBConnection() throws SQLException{
		Connection con= null; 
		String db= "game_Over"; 
		String user="root"; 
		String pass="1234"; 
		
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db, user, pass);
		
		con.setAutoCommit(true);
		
		return con;
	}
	
	public static synchronized Connection getConnection() throws SQLException{
		Connection con; 
		
		if(!freeDbConnections.isEmpty()) {
			con= (Connection) freeDbConnections.get(0); 
			DriverManagerConnectionPool.freeDbConnections.remove(0); 
			
			try {
				if(con.isClosed())
					con=DriverManagerConnectionPool.getConnection(); 
			}catch(SQLException e) {
				con.close();
				con= getConnection(); 
			} 	
		}else con= DriverManagerConnectionPool.createDBConnection(); 
		return con; 
	}
	
	public static synchronized void releaseConnection(Connection con) {
		if(con !=null) DriverManagerConnectionPool.freeDbConnections.add(con); 
	}
}
