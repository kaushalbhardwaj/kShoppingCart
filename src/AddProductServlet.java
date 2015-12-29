

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddProductServlet
 */
//@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession hs=request.getSession(false);
		if(hs==null)
		{
			
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
			return;
		}
		String uname=(String)hs.getAttribute("UserName");
		ArrayList products=(ArrayList)hs.getAttribute("products");
		if(products==null)
		{
			
			products=new ArrayList();
			hs.setAttribute("products", products);
		}
		String [] pcodes=request.getParameterValues("products");
		for(int i=0;i<pcodes.length;i++)
		{
			if(request.getParameter(pcodes[i]).equals(""))
				continue;
				Product p=new Product();
				p.code=pcodes[i];
				p.name=request.getParameter(pcodes[i]+"Name");
				int j=products.indexOf(p);
				if(j!=-1)
				{
					
					p=(Product)products.get(j);
					p.qty+=Double.parseDouble(request.getParameter(pcodes[i]));
					
				}
				else
				{
					
					p.qty=Double.parseDouble(request.getParameter(pcodes[i]));
					products.add(p);
					
				}
				
		}
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
				+ "</blockquote></td>"
				+ "<td width='82%' align='left' valign='top'>"
				+ "<p><font size='6'>Welcome , "+uname+"</font> </p>"
				+ "Products Added successfully to your cart</td></tr>"
				+ "<tr align='center'><td colspan='2'><em>&copy; Copyrightss 2015-16"
				+ "</em></td></tr></table></body></html>");
	}

}
