

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetCartDetailsServlet
 */
//@WebServlet("/GetCartDetailsServlet")
public class GetCartDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCartDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession(false);
		if(hs==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
			return;
		}
		String uname=(String)hs.getAttribute("UserName");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<head><title>kShopping Cart</title></head>"
				+ "<body><table width='100%' height='90%' border='1'>"
				+ "<tr align='center'><td height='39' colspan='2'>"
				+ "<strong><font size='5'>My kShopping Cart</font></strong>"
				+ "</td></tr><tr>"
				+ "<td width='18%' height='500' valign='top'>"
				+ "<p>&nbsp;</><blockquote><p>"
				+ "<a href='"+response.encodeUrl("getProducts")+"'>View Products</a></p>"
				+ "<p><a href='"+response.encodeUrl("getCart")+"'>View cart Details</a></p>"
				+ "<p><a href='"+response.encodeUrl("logout")+"'>Logout</a></p>"
				+ "</blockquote></td><td width='82%' align='left' valign='top'>"
				+ "<p><font size='6'>Welcome , "+uname+"</font></p>"
				+ "<center>Your cart contains the following products"
				+ "<table width='80%' border='1'><tr>"
				+ "<th width='24%'>Product Code</th>"
				+ "<th width='28%'>Product Name</th>"
				+ "<th width='20%'>Quantity</th></tr>");
		Collection products=(Collection)hs.getAttribute("products");
		if(products==null)
		{
			out.println("<tr><td colspan='3' align='center'>You have not added "
					+ "any products into cart</td></tr>");
		}
		else{
			Iterator i=products.iterator();
			while(i.hasNext())
			{
				Product p=(Product)i.next();
				out.println("<tr><td>"+p.getCode()+"</td><td>"+p.getName()+"</td>"
						+ "<td>"+p.getQty()+"</td></tr>");
				
			}
		
		}
		out.println("</table></center></td></tr>"
		+ "<tr align='center'><td colspan='2'><em>&copy; Copyrightss 2015-16"
		+ "</em></td></tr></table></body></html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
