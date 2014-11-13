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

	public int min(){
		return val;
	}

	SeqIt createSeqIt(){
		ConstantIt ci = new ConstantIt(this);
		return ci;
	}

	protected int number,val;
}