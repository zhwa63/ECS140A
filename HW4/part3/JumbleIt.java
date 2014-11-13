public class JumbleIt implements SeqIt{
	JumbleIt(Jumble s)
	{
		j = s;
	}

	public boolean hasNext()
	{
		if(counter < j.num)
		{
			return true;
		}
		return false;
	}

	public int next()
	{
		if(hasNext() == false)
		{
			System.err.print("JumbleIt called past end\n");
			System.exit(1);
		}
		counter++;
		return j.val[counter-1];
	}

	protected Jumble j;
	protected int counter=0;
}