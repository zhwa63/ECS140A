public class Plus{
	public static Seq plus(Constant c1, Constant c2)
	{
		int value,length=0;
		if(c1.number < c2.number)
		{
			length = c1.number;
		}
		else
		{
			length = c2.number;
		}
		value = c1.val + c2.val;

		Constant newC = new Constant(length,value);
		return newC;
	}

	public static Seq plus(Delta d1, Delta d2)
	{
		int initial,length=0,delta;
		if(d1.number < d2.number)
		{
			length = d1.number;
		}
		else
		{
			length = d2.number;
		}

		initial = d1.init + d2.init;
		delta = d1.del + d2.del;

		Delta newD = new Delta(length,initial,delta);
		return newD;
	}

	public static Seq plus(Jumble j1, Jumble j2)
	{
		int length=0;
		if(j1.num < j2.num)
		{
			length = j1.num;
		}
		else
		{
			length = j2.num;
		}

		int[] value = new int[length];
		for(int i = 0; i < length; i++)
		{
			value[i] = j1.val[i] + j2.val[i];
		}

		Jumble newJ = new Jumble(value);
		return newJ;
	}

}