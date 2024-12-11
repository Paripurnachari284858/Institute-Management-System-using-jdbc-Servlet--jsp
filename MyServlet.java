package com.project.backend;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.Bean.StudentBean;
import com.project.Bean.User1;
import com.project.model.Dao1;



@WebServlet("/")
public class MyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String path=request.getServletPath();
		switch(path)
		{
		case "/reg":registerUser(request,response);
		break;
		case "/login":userValidation(request,response);
		break;
		case"/homepage":
			String action=request.getParameter("action");
			switch(action)
			{
			case "AddStudent":insertData(request,response);
			break;
			case "Display":getDisplayData(request,response);
			break;
			case "Update":getUpdateJsp(request,response);
			break;
			case "Delete":deleteData(request,response);
			break;
			}
			break;

		case "/savedata":saveData(request,response);
		break;
		case"/deletedata":deleteSData(request,response);
		break;
		case"/updatedata":updateStudentData(request,response);
		break;
		case"/dataupdate":dataUpdate(request,response); 
		break;
		}

	}


	private void dataUpdate(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String course=request.getParameter("course");
		StudentBean s2=new StudentBean(id,name,age,mobile,address,email,course);
		Dao1 d=new Dao1();
		boolean stutus=d.getDataUpdate(s2);
		if(stutus)
		{
			request.setAttribute("messege", "Data Updated Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			try {
				rd.forward(request, response);
			} 
			catch (ServletException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else
		{

			request.setAttribute("messege", "Mobile/Email is alaredy Existed");
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			try {
				rd.forward(request, response);
			} 
			catch (ServletException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	private void updateStudentData(HttpServletRequest request, HttpServletResponse response) {
		long mobile=Long.parseLong(request.getParameter("mobile"));
		StudentBean sb=new StudentBean(mobile);
		Dao1 d=new Dao1();
		StudentBean alist=d.DisplayData(sb);
		if(sb!=null)
		{
			request.setAttribute("studentdata", alist);
			RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		


	}

	private void getUpdateJsp(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("update.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getDisplayData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dao1 d=new Dao1();
		ArrayList<StudentBean> data=d.getDisplay();
		if(data!=null)
		{
			request.setAttribute("studentdata", data);
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("studentdata", "Invalid Mobile Number");
			RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
			rd.forward(request, response);
		}


	}

	private void deleteSData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long mobile=Long.parseLong(request.getParameter("mobile"));
		StudentBean s=new StudentBean(mobile);
		Dao1 d=new Dao1();
		boolean stutus=d.getDelete(s);
		if(stutus)
		{
			request.setAttribute("delete","Data is Deleted Succesfully");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);

		}
		else
		{
			request.setAttribute("delete","Data is Not Exists");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			rd.forward(request, response);
		}

	}

	private void deleteData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("delete.jsp");

	}
	
	
	
	
	
	
	private void saveData(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        String name = request.getParameter("name");
	        int age = Integer.parseInt(request.getParameter("age"));
	        long mobile = Long.parseLong(request.getParameter("mobile"));
	        String address = request.getParameter("address");
	        String email = request.getParameter("email");
	        String course = request.getParameter("course");

	        StudentBean sb = new StudentBean(name, age, mobile, address, email, course);
	        Dao1 d = new Dao1();
	        boolean dataInsert = d.studentInsert(sb);

	        if (dataInsert) {
	            request.setAttribute("result", "Data Inserted Successfully");
	        } else {
	            request.setAttribute("result", "Email or Mobile  is exists");
	        }
	        RequestDispatcher rd = request.getRequestDispatcher("studentform.jsp");
	        rd.forward(request, response);

	    } catch (NumberFormatException e) {
	        request.setAttribute("result", "Invalid number format for age or mobile");
	        try {
	            RequestDispatcher rd = request.getRequestDispatcher("studentform.jsp");
	            rd.forward(request, response);
	        } catch (ServletException | IOException ex) {
	            ex.printStackTrace();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

	private void insertData(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("studentform.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void userValidation(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException 
	{
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		User1 u=new User1(email,password);
		Dao1 d=new Dao1();
		boolean status=d.UserVarify(u);
		if(status)
		{
			response.sendRedirect("Home.jsp");
		}
		else
		{
			request.setAttribute("status", "User Entered invalid Data");
			RequestDispatcher rd=request.getRequestDispatcher("login1.jsp");
			rd.forward(request, response);
		}


	}

	/*out.println(name);
	out.println(email);
	out.println(password);*/


	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException 
	{

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		User1 u=new User1(name,email,password);
		Dao1 d=new Dao1();
		//boolean b=d.insert(u);
		boolean b=d.dataInsert(u);
		if(b)
		{
			response.sendRedirect("login1.jsp");
			//out.println("Data Inserted Successfully");
		}
		else
		{
			//out.println("Email is alredy existed");
			//response.sendRedirect("reg1.jsp");
			request.setAttribute("status", "Email is alredy existed");
			RequestDispatcher rd=request.getRequestDispatcher("reg1.jsp");
			rd.forward(request, response);

		}
	}

}
