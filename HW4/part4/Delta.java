public class Delta extends Seq{
	protected Delta(int num, int initial, int delta)
	{
		number = num;
		if(number == 0)
		{
			init = 0;
			del = 0;
		}
		else
		{
		init = initial;
		del = delta;
		}
	}

	public String toString(){
		return "< "+ number + " : " + init +" &"+ del+ " >";
	}

	public int min(){
		int i;
		int min = init;
		int next = init + del;
		for(i = 1; i < number; i++)
		{	 
			if(min>(next))
			{
				min = next;
				next = next + del;
			}
		}
		return min;

	}
	protected int number, init, del;
}