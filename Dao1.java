package com.project.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.project.Bean.StudentBean;
import com.project.Bean.User1;


public class Dao1
{
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/javadb";
	String user="root";
	String password="Paripurna@28";
	Connection conn=null;
	Statement s=null;
	ResultSet rs=null;
	PreparedStatement ps=null;
	String query="insert into user(name,email,password)values(?,?,?)";
	String query1="select email,password from user";
	public boolean insert(User1 u)
	{
		boolean stutus=false;

		try {
			//loding driver
			Class.forName(driver);
			//esatblishing the connection
			conn=DriverManager.getConnection(url, user, password);
			ps=conn.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.executeUpdate();
			stutus=true;
			//System.out.println("Data Inserted Scussessfull");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}

			}
			if(conn!=null)
			{
				try {
					conn.close();
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}

			}
		}
		return stutus;
	}
	public boolean dataInsert(User1 u)
	{
		boolean stutus=true;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			s=conn.createStatement();
			rs=s.executeQuery("select * from user");
			while(rs.next())
			{
				if((rs.getString("email")).equals(u.getEmail()))
				{
					stutus=false;
					return stutus;
				}
			}
			ps=conn.prepareStatement(query);
			ps.setString(1,u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3,u.getPassword());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try
				{
					ps.close();
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}

			}
			if(conn!=null)
			{
				try 
				{
					conn.close();
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
			}

			if(s!=null)
			{
				try 
				{
					s.close();
				}
				catch(SQLException e)
				{
					System.out.println(e);
				}
			}


		}
		return stutus;

	}
	public boolean UserVarify(User1 u)
	{
		boolean ustatus=false;

		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
			s=conn.createStatement();
			rs=s.executeQuery(query1);
			while(rs.next())
			{
				String email=rs.getString("email");
				String password=rs.getString("password");
				if(email.equals(u.getEmail()) && password.equals(u.getPassword()))
				{
					ustatus=true;
				}
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn!=null||s!=null||rs!=null)
			{	
				try 
				{
					s.close();
					rs.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return ustatus;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean studentInsert(StudentBean s) {
	    boolean b = true;
	    try {
	        Class.forName(driver);
	        conn = DriverManager.getConnection(url, user, password);

	        // Check for duplicates
	        ps = conn.prepareStatement("SELECT COUNT(*) FROM student WHERE mobile = ? OR email = ?");
	        ps.setLong(1, s.getMobile());
	        ps.setString(2, s.getEmail());
	        rs = ps.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	            b = false;
	        }

	        // Insert if no duplicates
	        if (b) {
	            ps = conn.prepareStatement("INSERT INTO student(sname, age, mobile, address, email, course) VALUES (?, ?, ?, ?, ?, ?)");
	            ps.setString(1, s.getName());
	            ps.setInt(2, s.getAge());
	            ps.setLong(3, s.getMobile());
	            ps.setString(4, s.getAddress());
	            ps.setString(5, s.getEmail());
	            ps.setString(6, s.getCourse());
	            ps.executeUpdate();
	        }
	    } catch (ClassNotFoundException e) {
	        System.out.println("Driver Class not found: " + e.getMessage());
	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            System.out.println("Resources not closed: " + e.getMessage());
	        }
	    }
	    return b;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean getDelete(StudentBean s)
	{
		boolean stutus=false;
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			ps=conn.prepareStatement("select mobile from student where mobile=?");
			ps.setLong(1, s.getMobile());
			rs=ps.executeQuery();
			if(rs.next())
			{
				stutus=true;
			}
			if(stutus)
			{
				ps=conn.prepareStatement("delete from student where mobile=?");
				ps.setLong(1,s.getMobile());
				ps.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null&&conn!=null)
			{
				try
				{
					ps.close();
					conn.close();
				}
				catch(SQLException e)
				{
					System.out.println("Resourse Are not Closed");
				}
			}
		}
		return stutus;


	}
	
	public ArrayList<StudentBean> getDisplay()
	{
		ArrayList<StudentBean> al=new ArrayList<StudentBean>();
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
	    	s=conn.createStatement();
	    	rs=	s.executeQuery("select * from student");
		
		while(rs.next())
		{
			        int id=rs.getInt("sid");
					String name=rs.getString("sname");
					int age=rs.getInt("age");
					long mobile=rs.getLong("mobile");
					String address=rs.getString("address");
					String email=rs.getString("email");
					String course=rs.getString("course");
					StudentBean s1= new StudentBean(id,name,age,mobile,address,email,course);
					al.add(s1);
		}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null&&conn!=null&&rs!=null)
			{
				try
				{
					ps.close();
					conn.close();
					rs.close();
				}
				catch(SQLException e)
				{
					System.out.println("Resourse Are not Closed");
				}
			}
			
		}
		return al;
		
	}
	public StudentBean DisplayData(StudentBean sb) 
	{
		StudentBean s1=null;
	
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
				ps=conn.prepareStatement("select * from student where mobile=?");
				ps.setLong(1, sb.getMobile());
				rs=ps.executeQuery();
			    if(rs.next())
			    {   
			    	int id=rs.getInt("sid");
					String name=rs.getString("sname");
					int age=rs.getInt("age");
					long mobile=rs.getLong("mobile");
					String address=rs.getString("address");
					String email=rs.getString("email");
					String course=rs.getString("course");
					s1= new StudentBean(id,name,age,mobile,address,email,course);
					
			    }
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null&&conn!=null&&rs!=null)
			{
				try
				{
					ps.close();
					conn.close();
					rs.close();
				}
				catch(SQLException e)
				{
					System.out.println("Resourse Are not Closed");
				}
			}
		}
		return s1;
		
	}
	public boolean getDataUpdate(StudentBean sb)
	{
		boolean stutus=true;
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,user,password);
			
			s=conn.createStatement();
			rs=s.executeQuery("select mobile,email from student");
			while(rs.next())
			{
				long mobile=rs.getLong("mobile");
				String email=rs.getString("email");
				if(mobile==sb.getMobile()||email.equals(sb.getEmail()))
				{
					stutus=false;
					break;
				}
				
			}
			
			
			if(stutus)
			{
				ps=conn.prepareStatement("update student set sname=?,age=?,mobile=?,address=?,email=?,course =? where sid=?");
				ps.setString(1, sb.getName());
				ps.setInt(2,sb.getAge());
				ps.setLong(3, sb.getMobile());
				ps.setString(4, sb.getAddress());
				ps.setString(5, sb.getEmail());
				ps.setString(6,sb.getCourse());
				ps.setLong(7, sb.getId());
			    ps.executeUpdate();
			}
			
           
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null&&conn!=null)
			{
				try
				{
					ps.close();
					conn.close();
				}
				catch(SQLException e)
				{
					System.out.println("Resourse Are not Closed");
				}
			}
		}
		return false;
		
		

	}
	
	
}
