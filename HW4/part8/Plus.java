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
		Seq newObj;
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

		//check if the new seq is a constant
		//if no difference, then is constant
		if(delta == 0)
		{
			newObj = new Constant(length,initial);
		}
		else
		{
			newObj = new Delta(length,initial,delta);
		}
		return newObj;
	}

	public static Seq plus(Jumble j1, Jumble j2)
	{
		Seq newObj;
		int length=0;
		if(j1.num < j2.num)
		{
			length = j1.num;
		}
		else
		{
			length = j2.num;
		}

		//base cases
		if(j1.num == 0)
	    	return plus(new Constant(0, 0), j2);
		if(j2.num == 0)
	    	return plus(j1, new Constant(0,0));
		if(j1.num == 1 || j2.num == 1)
            return plus(new Constant(1, j1.val[0]), new Constant(1, j2.val[0]));

        //if two jumble sum up to 0, they are constant
		for(int i = 0; i< length; i++)
		{
            if(j1.val[i]+(j2.val[i]) != 0)
                break;
            if(i == length -1)
                return (new Constant(length,0));
        }

        //check for jumble length > 1
		if(canJbeD(j1))
		{
			return plus(new Delta(j1.num, j1.val[0], (j1.val[1] - j1.val[0])),j2);
		}
		else if(canJbeD(j2))
		{
			return plus(j1, new Delta(j2.num,j2.val[0],(j2.val[1] - j2.val[0])));
		}
		else if(canJbeD(j1) && canJbeD(j2))
		{
			return plus(new Delta(j1.num, j1.val[0], (j1.val[1] - j1.val[0])),new Delta(j2.num,j2.val[0],(j2.val[1] - j2.val[0])));
		}
		else
		{
			int[] value = new int[length];
		for(int i = 0; i < length; i++)
			{
				value[i] = j1.val[i] + j2.val[i];
			}
			newObj = new Jumble(value);
		}
		return newObj;
	}

	public static Seq plus(Constant c, Delta d)
	{
		Seq newObj;
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

		//since the delta wont change when add with constant, only need to check delta
		if(delta == 0)
		{
			newObj = new Constant(length,initial);
		}
		else
		{
			newObj = new Delta(length,initial,delta);
		}
		return newObj;
	}

	public static Seq plus(Delta d, Constant c)
	{
		Seq newObj;
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

		if(delta == 0)
		{
			newObj = new Constant(length,initial);
		}
		else
		{
			newObj = new Delta(length,initial,delta);
		}
		return newObj;
	}

	public static Seq plus(Constant c,Jumble j)
	{
		Seq newObj;
		int length=0;
		if(c.number < j.num)
		{
			length = c.number;
		}
		else
		{
			length = j.num;
		}

		if(j.num == 0)
	    	return plus(c, new Constant(0,0));
		if(j.num == 1 )
            return plus(c, new Constant(1, j.val[0]));

		if(canJbeD(j))
		{
			//reduce jumble to delta
			return plus(c, new Delta(j.num, j.val[0], (j.val[1] - j.val[0])));
		}
		else
		{
			int[] value = new int[length];
			for(int i = 0; i < length; i++)
			{
				value[i] = c.val + j.val[i];
			}

			newObj = new Jumble(value);
		}
		return newObj;
	}

	public static Seq plus(Jumble j,Constant c)
	{
		Seq newObj;
		int length=0;
		if(c.number < j.num)
		{
			length = c.number;
		}
		else
		{
			length = j.num;
		}

		if(j.num == 0)
	    	return plus(new Constant(0,0),c);
		if(j.num == 1 )
            return plus(new Constant(1, j.val[0]),c);
		if(canJbeD(j))
		{
			//reduce jumble to delta
			return plus(new Delta(j.num, j.val[0], (j.val[1] - j.val[0])),c);
		}
		else
		{

			int[] value = new int[length];
			for(int i = 0; i < length; i++)
			{
				value[i] = c.val + j.val[i];
			}

			newObj = new Jumble(value);
		}
		return newObj;
	}

	public static Seq plus(Delta d, Jumble j)
	{
		Seq newObj;
		int length=0;
		if(d.number < j.num)
		{
			length = d.number;
		}
		else
		{
			length = j.num;
		}

		if(j.num == 0)
	    	return plus(d, new Constant(0,0));
		if(j.num == 1 )
            return plus(d, new Constant(1, j.val[0]));
		if(canJbeD(j))
		{
			return plus(d, new Delta(j.num, j.val[0], (j.val[1] - j.val[0])));
		}
		else
		{

			int[] value = new int[length];
			for(int i = 0; i < length; i++)
			{
				value[i] = (d.init + i*d.del) + j.val[i];
			}

			newObj = new Jumble(value);
		}
		return newObj;
	}

	public static Seq plus(Jumble j, Delta d)
	{	
		Seq newObj;
		int length=0;
		if(d.number < j.num)
		{
			length = d.number;
		}
		else
		{
			length = j.num;
		}

		if(j.num == 0)
	    	return plus(new Constant(0,0),d);
		if(j.num == 1 )
            return plus(new Constant(1, j.val[0]),d);

		if(canJbeD(j))
		{
			return plus(new Delta(j.num, j.val[0], (j.val[1] - j.val[0])),d);
		}
		else
		{

			int[] value = new int[length];
			for(int i = 0; i < length; i++)
			{
				value[i] = (d.init + i*d.del) + j.val[i];
			}

			newObj = new Jumble(value);
		}
		return newObj;
	}

//function to check if a Jumble can be a Delta
	public static boolean canJbeD(Jumble j)
	{
		boolean isDelta = false;
			int del = j.val[1]-j.val[0];
			for(int i = 1; i < j.num; i++)
			{
				int diff = j.val[i]-j.val[i-1];
				if(del != diff)
				{
					isDelta = false;
					break;
				}
				else
				{
					isDelta = true;
				}

			}
		

		return isDelta;
	}
}