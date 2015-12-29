

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserVerify {
	
	public boolean validate(String uname,String pass)
	{
		try{
			Connection con =DriverConnection.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from userdetails where uname="
					+ "\'"+uname+"\' and pass=\'"+pass+"\'");
			return rs.next();
		}
		catch(Exception e)
		{
			
		}
		return false;
	}

}
