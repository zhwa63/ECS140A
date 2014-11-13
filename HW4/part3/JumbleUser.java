public class JumbleUser{
	public static int lengthLongestNDCSS1(Jumble j)
	{
		JumbleIt ji = new JumbleIt(j);

		int length = 1,longest,i=0,k,l;
		/*
		if(j.num == 0)
		{
			longest = 0;
		}
		else
		{
			longest = 1;
			*/

		if(!ji.hasNext())
		{
			longest = 0;
		}
		else
		{
			longest = 1;
			int current = ji.next();
			
			

		//System.out.print("array length:"+ j.num +"\n");
			//while(i<j.num)
			//{
				while(ji.hasNext())
				//for(k = i; k<(j.num-1);k++)
				{
					//System.out.print("value at k:"+j.val[k]+"\n");
					int nextone = ji.next();
					//l = k+1;
					//System.out.print("value at l:"+j.val[l]+"\n");
					if(((current < nextone) || (current == nextone)))
					{
						length++;
						//System.out.print("length:"+length+ "\n");
					}
					else{
						if(length > longest)
						{
							longest = length;
							//System.out.print("longest:"+ longest + "\n");
						}
						length = 1;
					}
					current = nextone;				
				}
				if(length > longest)
				{
					longest = length;
					//System.out.print("longest:"+ longest + "\n");
				}
			
				
				//i += length;

				//i++;
			//}
		}
		return longest;
	}
}