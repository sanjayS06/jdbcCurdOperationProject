package jdbcproject_curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbcproject {
	public static void main(String[] args) {
		Employee e=new Employee();
		//e.create();
		//e.insert("suresh", 50000);
		//e.update(1, 60000);
		//e.selectRow(2);
		//e.insert("ajith", 40000);
		e.select();
		
}
}
class Employee{
	public String url="jdbc:mysql://localhost:3306/jdbcdb";
	public String name="root";
	public String password="sanjay";
	Connection con=null;
	Statement st=null;
	PreparedStatement ps=null;
	
		public void create() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(url,name,password);
			 st=con.createStatement();
			st.executeUpdate("create table employee(eid int primary key auto_increment,ename varchar(40) not null,esalary int not null)");
			 }
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
			}
		
	  finally {
		  try {
			  if(st!=null) {
					st.close();
				} 
				if(con!=null) {
					con.close();
				} 
				
		} catch (SQLException e) {
		     e.printStackTrace();
		}
		 
		  
		     
				
			}
		}
	
		public void insert(String ename,int esalary) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,name,password);
				ps=con.prepareStatement("insert into employee (ename,esalary) values(?,?)");
				ps.setString(1, ename);
				ps.setInt(2, esalary);
				int res=ps.executeUpdate();
				if(res>0) {
					System.out.println("Data Insert Sucessfully");
					}
				else {
					System.out.println("Invalid Data");
				}
				 }
			catch (ClassNotFoundException e) {
			    e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			 finally {
				  try {
					  if(ps!=null) {
							ps.close();
						} 
						if(con!=null) {
							con.close();
						} 
						
				} catch (SQLException e) {
				     e.printStackTrace();
				}
		}
		
		}
		public void update(int updeid,int updesalary) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,name,password);
			    ps=con.prepareStatement("update employee set esalary=? where eid=?");
				ps.setInt(1, updesalary);
				ps.setInt(2,updeid);
				int res=ps.executeUpdate();
				if(res>0) {
					System.out.println("Data Update Sucessfully");
					}
				else {
					System.out.println("Invalid Data");
				}
				}
			
			
			catch (ClassNotFoundException e) {
			    e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			 finally {
				  try {
					if(ps!=null) {
						ps.close();
					} 
					if(con!=null) {
						con.close();
					} 
					} catch (SQLException e) {
				     e.printStackTrace();
				}
				
		}
		
		}
		public void delete(int deid) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,name,password);
			    ps=con.prepareStatement("delete from empolyee where eid=?");
				ps.setInt(1, deid);
				int res=ps.executeUpdate();
				if(res>0) {
					System.out.println("Data Deleted Sucessfully");
					}
				else {
					System.out.println("Invalid Data");
				}
				
				 }
			catch (ClassNotFoundException e) {
			    e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			 finally {
				  try {
					if(ps!=null) {
						ps.close();
					} 
					if(con!=null) {
						con.close();
					} 
					}
				  catch (SQLException e) {
				     e.printStackTrace();
				}
		}
	}
		public void select() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,name,password);
			    st=con.createStatement();
			   ResultSet rs= st.executeQuery("select * from employee");
			     while(rs.next()) {
			    	 int id=rs.getInt("eid");
			    	 String name=rs.getString("ename");
			    	 int salary=rs.getInt("esalary");
			    	 System.out.println("Id :"+ id);
			    	 System.out.println("Name :"+ name);
			    	 System.out.println("Salary :"+ salary);
			    	 System.out.println("=========================================================");
			     }
				
				 }
			catch (ClassNotFoundException e) {
			    e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			 finally {
				  try {
					if(st!=null) {
						st.close();
					} 
					if(con!=null) {
						con.close();
					} 
					}
				  catch (SQLException e) {
				     e.printStackTrace();
				}
		}
	}
		public void selectRow(int eid) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,name,password);
			    ps=con.prepareStatement("select * from employee where eid=?");
			    ps.setInt(1, eid);
			   ResultSet rs= ps.executeQuery();
			     while(rs.next()) {
			    	 int id=rs.getInt("eid");
			    	 String name=rs.getString("ename");
			    	 int salary=rs.getInt("esalary");
			    	 System.out.println("Id :"+ id);
			    	 System.out.println("Name :"+ name);
			    	 System.out.println("Salary :"+ salary);
			    	 System.out.println("=========================================================");
			     }
				
				 }
			catch (ClassNotFoundException e) {
			    e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			 finally {
				  try {
					if(ps!=null) {
						ps.close();
					} 
					if(con!=null) {
						con.close();
					} 
					}
				  catch (SQLException e) {
				     e.printStackTrace();
				}
		}
	}
		



}


