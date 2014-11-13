public class Constant extends Seq{
	//Constructor
	protected Constant(int num, int value)
	{
		number = num;
		if(number == 0)
		{
			val = 0;
		}
		else
			val = value;
	}

	public String toString(){
		return "[ " + number + " : " + val + " ]";
	}

	protected int number,val;
}