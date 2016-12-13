package racms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminAuth{
		static final String DB_URL = "jdbc:mysql://185.111.233.24:3306/kwmbalci_racms?verifyServerCertificate=false&useSSL=false";
	    static final String USER = "kwmbalci_cs320";
	    static final String PASS = "Merhaba123";
	    
	    public static int checkID(String username, String password) {
	    	   int result = 0;
	    	   Connection conn = null;
	    	   Statement stmt = null;
	    	   try{
	    	      //STEP 3: Open a connection
	    	      System.out.println("Connecting to database...");
	    	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	    	      //STEP 4: Execute a query
	    	      System.out.println("Creating statement...");
	    	      stmt = conn.createStatement();
	    	      
	    	      String sql;
	    	    
	    	      sql = "SELECT COUNT(vendor_no) FROM Admin WHERE vendor_no="+username+" and passwd='"+password+"'";
	    	      System.out.println(sql);
	    	      
	    	      ResultSet rs = stmt.executeQuery(sql);
	    	      
	    	      //STEP 5: Extract data from result set
	    	      while(rs.next()){
	    	    	  	result = rs.getInt("COUNT(vendor_no)");
	    	            System.out.print(rs.getInt("COUNT(vendor_no)"));
	    	      }
	    	      //STEP 6: Clean-up environment
	    	      rs.close();
	    	      stmt.close();
	    	      conn.close();
	    	   }catch(SQLException se){
	    	      //Handle errors for JDBC
	    	      se.printStackTrace();
	    	   }catch(Exception e){
	    	      //Handle errors for Class.forName
	    	      e.printStackTrace();
	    	   }finally{
	    	      //finally block used to close resources
	    	      try{
	    	         if(stmt!=null)
	    	            stmt.close();
	    	      }catch(SQLException se2){
	    	      }// nothing we can do
	    	      try{
	    	         if(conn!=null)
	    	            conn.close();
	    	      }catch(SQLException se){
	    	         se.printStackTrace();
	    	      }//end finally try
	    	   }//end try
	    	   return result;
	    }
	    
	    public static ArrayList<String> getVendors() {
	    	   ArrayList<String> result = new ArrayList<String>();
	    	   Connection conn = null;
	    	   Statement stmt = null;
	    	   try{
	    	      //STEP 3: Open a connection
	    	      System.out.println("Connecting to database...");
	    	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	    	      //STEP 4: Execute a query
	    	      System.out.println("Creating statement...");
	    	      stmt = conn.createStatement();
	    	      
	    	      String sql;
	    	    
	    	      sql = "SELECT * FROM Admin";
	    	      
	    	      ResultSet rs = stmt.executeQuery(sql);
	    	      
	    	      //STEP 5: Extract data from result set
	    	      while(rs.next()){
	    	    	    result.add(rs.getString("vendor_name"));
	    	      }
	    	      //STEP 6: Clean-up environment
	    	      rs.close();
	    	      stmt.close();
	    	      conn.close();
	    	   }catch(SQLException se){
	    	      //Handle errors for JDBC
	    	      se.printStackTrace();
	    	   }catch(Exception e){
	    	      //Handle errors for Class.forName
	    	      e.printStackTrace();
	    	   }finally{
	    	      //finally block used to close resources
	    	      try{
	    	         if(stmt!=null)
	    	            stmt.close();
	    	      }catch(SQLException se2){
	    	      }// nothing we can do
	    	      try{
	    	         if(conn!=null)
	    	            conn.close();
	    	      }catch(SQLException se){
	    	         se.printStackTrace();
	    	      }//end finally try
	    	   }//end try
	    	   return result;
	    }
	
}
