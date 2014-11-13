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

	public static Seq plus(Constant c, Delta d)
	{
		int initial,length=0,delta;
		if(c.number < d.number)
		{
			length = c.number;
		}
		else
		{
			length = d.number;
		}

		initial = c.val + d.init;
		delta = d.del;

		Delta newD = new Delta(length,initial,delta);
		return newD;
	}

	public static Seq plus(Delta d, Constant c)
	{
		int initial,length=0,delta;
		if(c.number < d.number)
		{
			length = c.number;
		}
		else
		{
			length = d.number;
		}

		initial = c.val + d.init;
		delta = d.del;

		Delta newD = new Delta(length,initial,delta);
		return newD;
	}

	public static Seq plus(Constant c,Jumble j)
	{
		int length=0;
		if(c.number < j.num)
		{
			length = c.number;
		}
		else
		{
			length = j.num;
		}

		int[] value = new int[length];
		for(int i = 0; i < length; i++)
		{
			value[i] = c.val + j.val[i];
		}

		Jumble newJ = new Jumble(value);
		return newJ;
	}

	public static Seq plus(Jumble j,Constant c)
	{

		int length=0;
		if(c.number < j.num)
		{
			length = c.number;
		}
		else
		{
			length = j.num;
		}

		int[] value = new int[length];
		for(int i = 0; i < length; i++)
		{
			value[i] = c.val + j.val[i];
		}

		Jumble newJ = new Jumble(value);
		return newJ;
	}

	public static Seq plus(Delta d, Jumble j)
	{

		int length=0;
		if(d.number < j.num)
		{
			length = d.number;
		}
		else
		{
			length = j.num;
		}

		int[] value = new int[length];
		for(int i = 0; i < length; i++)
		{
			value[i] = (d.init + i*d.del) + j.val[i];
		}

		Jumble newJ = new Jumble(value);
		return newJ;
	}

	public static Seq plus(Jumble j, Delta d)
	{	
		int length=0;
		if(d.number < j.num)
		{
			length = d.number;
		}
		else
		{
			length = j.num;
		}

		int[] value = new int[length];
		for(int i = 0; i < length; i++)
		{
			value[i] = (d.init + i*d.del) + j.val[i];
		}

		Jumble newJ = new Jumble(value);
		return newJ;
	}
}