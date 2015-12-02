import java.util.Scanner;

public class fifo {
	Scanner x=new Scanner(System.in);
	public int num;
	public int[] value;
	public int[] queue;
	int faults;

	public fifo()
	{
		System.out.println("Enter total number of pages :");
		num=x.nextInt();
		value=new int[num];
		queue=new int[4];
		for(int i=0;i<4;i++)
			queue[i]=-1;
		faults=0;
	}
	public void input()
	{
		System.out.println("Enter page ids :");
		for(int i=0;i<num;i++)
		{
			value[i]=x.nextInt();
		}
	}
	public void print()
	{
		System.out.println(queue[0]+" - "+queue[1]+" - "+queue[2]+" - "+queue[3]);
	}
	public int search(int n)
	{
		for(int i=0;i<4;i++)
		{
			if(queue[i]==n)
				return 0;
		}
		return 1;
	}
	public void algo()
	{
		int i;
		int replace=0;
		for(i=0;i<num;i++)
		{
			int u=search(-1);
			if(u==1)
			{
				int y=search(value[i]);
				if(y==1)
				{	
					queue[replace]=value[i];
					faults=faults+1;
					replace=replace+1;
				}
			}
			else
			{
				int y=search(value[i]);
				if(y==1)
				{
					queue[replace]=value[i];
					faults=faults+1;
					replace=(replace+1)%4;
				}
			}
			print();
		}	
	}
}