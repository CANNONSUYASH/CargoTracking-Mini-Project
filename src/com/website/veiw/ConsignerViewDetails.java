package com.website.veiw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSetMetaData;
import com.website.Controller.ConsigneeController;
import com.website.Controller.ConsignerController;
import com.website.Controller.Dbhelper;

/**
 * Servlet implementation class ConsignerViewDetails
 */
@WebServlet("/ConsignerViewDetails")
public class ConsignerViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsignerViewDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

	
		
		PrintWriter out=response.getWriter();
		out.println("<script src='filesa/jquery-2.2.1.min.js'></script>");
        out.println("<script src='filesa/countrycitystate.js'></script>");
        out.println("<script src='filesa/passwordcheck.js'></script>");
      
        
        
        try
		{
		ResultSet rs=ConsignerController.displayTracking();
		if(rs.next())
		{
		
		out.println("<html>");
         
        
        out.println("<html>");
         
        out.println("<form action=EmployeeSubmit method=post enctype='multipart/form-data'>");
        out.println("<table border=1 width=200 height=50>");
        out.println("<caption>Consigner Item Tracking Details</caption>");
        out.println("<tr>");
        out.println("<td>TrackingTransactionid:</td><td>"+rs.getString(1)+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>TrackingID:</td><td>"+rs.getString(2)+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>EmployeeID:</td><td>"+rs.getString(3)+"</td>");
        out.println("</tr>");
         
        out.println("<tr>");
        out.println("<td>TransactionDate:</td><td>"+rs.getString(4)+"</td>");
        out.println("</tr>");
        
        
        out.println("<tr>");
        out.println("<td>Transactiontime:</td><td>"+rs.getString(5)+"</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>Detailed Description:</td><td>"+rs.getString(6)+"</td>");
        out.println("</tr>");
        
       
       
        out.println("</table></form></html>");
        out.flush();
		
//        do
//		{
//			out.println("<tr><td></td><td>"+rs.getString(1)+"/<br>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"/<br>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"<br>"+rs.getString(2)+"<br>"+rs.getString(2)+","+rs.getString(2)+"<br>"+rs.getString(2)+"<br>"+rs.getString(8)+"<br>Mob:"+rs.getString(6)+" Ph:"+rs.getString(7)+"</td><td>"+rs.getString(2)+"</td><td><img src=images/"+rs.getString(2)+" width=45 height=45><br><a href="+rs.getString(2)+">"+rs.getString(2)+"</a></td><td><a href=ConsigneeDisplayById?cid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
////			sn++;
//		}
        while(rs.next());
		out.println("</table></html>");
	}
	else
	{
	out.println("Record Not Found");	
	}
		}catch(Exception e){
			out.println(e);
			
		}
        
        

}


	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String aid=request.getParameter("aid");  
		int aid1=Integer.valueOf(aid);  
		          
		try{  
	
	  Connection cn=(Connection) Dbhelper.openConnection();
	  PreparedStatement ps=cn.prepareStatement("select trackingtransactionid,trackingid,employeeid,tdate,ttime,lat,lng,id from tracking,consigner where tracking.trackingid=?");
	  
	 
		              
		
		ps.setInt(1,aid1);  
		              
		out.print("<table width=50% border=1>");  
		out.print("<caption>Result:</caption>");  
  
		ResultSet rs=ps.executeQuery();  
		              
		/* Printing column names */  
		ResultSetMetaData rsmd=(ResultSetMetaData) rs.getMetaData();  
		int total=rsmd.getColumnCount();  
		out.print("<tr>");  
		for(int i=1;i<=total;i++)  
		{  
		out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
		}  
		  
		out.print("</tr>");  
		              
		/* Printing result */  
		  
		while(rs.next())  
		{  
		out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getInt(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td></tr>"+rs.getString(5)+"</td></tr>"+rs.getString(6)+"</td></tr>"+rs.getString(7)+"</td></tr>");  
                   
		}  
 
		out.print("</table>");  
		              
		}catch (Exception e2) {e2.printStackTrace();}  
		          
		finally{out.close();}  
	}

}
