import java.util.Scanner;

public class lru {
	Scanner x=new Scanner(System.in);
	public int num;
	public int[] value;
	public int[][] queue;
	int faults;

	public lru()
	{
		System.out.println("Enter total number of pages :");
		num=x.nextInt();
		value=new int[num];
		queue=new int[4][2];
		for(int i=0;i<4;i++)
		{
			queue[i][0]=-1;
			queue[i][1]=0;
		}
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
		System.out.println(queue[0][0]+" - "+queue[1][0]+" - "+queue[2][0]+" - "+queue[3][0]);
	}
	public int search(int n)
	{
		for(int i=0;i<4;i++)
		{
			if(queue[i][0]==n)
			{
				queue[i][1]=0;
				return i;
			}
		}
		return -1;
	}
	public void increment()
	{
		for(int i=0;i<4;i++)
		{
			queue[i][1]=queue[i][1]+1;
		}
	}
	public int max()
	{
		int max=0;
		for(int i=1;i<4;i++)
		{
			if(queue[i][1]>queue[max][1])
				max=i;
		}
		return max;
	}
	public void algo()
	{
		int i;
		for(i=0;i<num;i++)
		{
			increment();
			int u=search(-1);
			if(u==-1)
			{
				int y=search(value[i]);
				if(y==-1)
				{	
					int replace=max();
					queue[replace][0]=value[i];
					queue[replace][1]=0;
					faults=faults+1;
				}
				else
				{
					queue[y][1]=0;
				}
			}
			else
			{
				int y=search(value[i]);
				if(y==-1)
				{
					queue[u][0]=value[i];
					queue[u][1]=0;
					faults=faults+1;
				}
				else
				{
					queue[y][1]=0;
				}
			}
			print();
		}	
	}
}