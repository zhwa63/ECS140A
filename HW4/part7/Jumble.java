import java.lang.*;

public class Jumble extends Seq{
	protected Jumble(int [] values)
	{
		num = values.length;
		val = new int[num];
		System.arraycopy(values,0,val,0,num);
	}

	public String toString(){
		String s = "{ "+ num +" : ";
		if(num == 0)
		{
			s = s+"";
		}
		else
		{
			int i;
			for(int a : val)
			{
				s += Integer.toString(a)+" ";
			}
		}
		s = s+"}";
		return s; 
	}

	public int min(){
		int min;
		if(num == 0)
		{
			min = 0;
		}
		else{
			min = val[0];
			int i;
			for(i=1; i<num; i++)
			{
				if(min > val[i] )
				{
					min = val[i];
				}
			}
		}
		return min;
	}

	SeqIt createSeqIt()
	{
		JumbleIt ji = new JumbleIt(this);
		return ji;
	}
	
	protected int num;
	protected int[] val;
}