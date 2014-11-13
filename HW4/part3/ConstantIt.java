public class ConstantIt implements SeqIt{
	ConstantIt(Constant s)
	{
		con = s;
	}

	public boolean hasNext()
	{	
		if(counter < con.number)
		{
			//System.out.print("this is counter:" + counter + " ");
			return true;
		}
		return false;
	}

	public int next()
	{
		if(hasNext() == false)
		{
			System.err.print("ConstantIt called past end\n");
			System.exit(1);
		}
		counter++;
		return con.val;
	}

	protected Constant con;
	protected int counter = 0;
}