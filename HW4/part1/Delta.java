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
	protected int number, init, del;
}