public class JumbleUser{
	public static int lengthLongestNDCSS1(Jumble j)
	{
		JumbleIt ji = new JumbleIt(j);

		int length = 1,longest,current = 0,nextone = 0;

		if(!ji.hasNext())
		{
			longest = 0;
		}
		else
		{
			longest = 1;
			try
			{
				current = ji.next();
			}
				catch(UsingIteratorPastEndException e)
			{

			}
			
			
				while(ji.hasNext())
				{
					//System.out.print("value at k:"+j.val[k]+"\n");
					try
					{
						nextone = ji.next();
					}
					catch(UsingIteratorPastEndException e)
					{

					}
					
					//System.out.print("value at l:"+j.val[l]+"\n");
					if((current < nextone) || (current == nextone))
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
			
			//}
		}
		return longest;
	}

	public static int lengthLongestNDCSS2(Jumble j)
	{
		JumbleIt ji = new JumbleIt(j);

		int length = 1,longest,current = 0,nextone = 0;
		boolean loop = true;

		
		try
		//else
		{
			//ji.next();

			longest = 1;
			//try
			//{
				current = ji.next();
			//}
			//	catch(UsingIteratorPastEndException e)
			//{

			//}
			
			
				while(loop)
				{
					//System.out.print("current value:"+current+"\n");
					try
					{
						nextone = ji.next();
					
					
					//System.out.print("next value :"+nextone+"\n");
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
					catch(UsingIteratorPastEndException e)
					{
						loop = false;
					}			
				}

				if(length > longest)
				{
					longest = length;
					//System.out.print("longest:"+ longest + "\n");
				}
			
				
			//}
		}
		catch (UsingIteratorPastEndException e)
		{

			longest = 0;
		
		}
		return longest;
	}
	
}