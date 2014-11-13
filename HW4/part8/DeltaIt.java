public class DeltaIt implements SeqIt{
	DeltaIt(Delta s)
	{
		d = s;
	}

	public boolean hasNext()
	{
		if(counter < d.number)
		{
			return true;
		}

		return false;

	}

	public int next() throws UsingIteratorPastEndException
	{
		if(hasNext() == false)
		{
			//System.err.print("ERROR in DeltaIt");
			throw new UsingIteratorPastEndException("DeltaIt called past end\n");
			//System.exit(1);
		}
		counter++;
		int index = counter-1;
		return d.init+index*d.del;
	}

	protected Delta d;
	protected int counter = 0;
	protected int temp;
}