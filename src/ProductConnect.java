import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;


public class ProductConnect {

	public Collection getProducts()
	{
		try{
			Connection con=DriverConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from products");
			
			ArrayList products=new ArrayList();
			while(rs.next())
			{
				Product p=new Product();
				p.code=rs.getString(1);
				p.name=rs.getString(2);
				p.qty=rs.getDouble(3);
				products.add(p);
				
			}
			return products;
		}
		catch(Exception e)
		{
			
		}
		return null;
	}
	
}
