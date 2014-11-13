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

	public int next() throws UsingIteratorPastEndException
	{
		if(hasNext() == false)
		{
			//System.err.print("ERROR in ConstantIt");
			throw new UsingIteratorPastEndException("ConstantIt called past end\n");
			//System.exit(1);
		}
		counter++;
		return con.val;
	}

	protected Constant con;
	protected int counter = 0;
}