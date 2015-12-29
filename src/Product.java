
public class Product {
	
	String code,name;
	double qty;
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code=code;
		
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
		
	}
	public double getQty()
	{
		return qty;
	}
	public void setQty(double qty)
	{
		this.qty=qty;
		
	}
	public boolean equals(Object o)
	{
		if(o instanceof Product)
			return ((Product)o).code.equals(code);
		return false;
	}

}
