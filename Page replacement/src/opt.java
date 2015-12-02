import java.util.Scanner;

public class opt {
	Scanner x=new Scanner(System.in);
	public int num;
	public int[] value;
	public int[] queue;
	int faults;

	public opt()
	{
		System.out.println("Enter total number of pages :");
		num=x.nextInt();
		value=new int[num];
		queue=new int[4];
		for(int i=0;i<4;i++)
		{
			queue[i]=-1;
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
		System.out.println(queue[0]+" - "+queue[1]+" - "+queue[2]+" - "+queue[3]);
	}
	public int search(int n)
	{
		for(int i=0;i<4;i++)
		{
			if(queue[i]==n)
				return i;
		}
		return -1;
	}
	public int closest(int a,int b)
	{
		int flag=1000000000;
		for(int i=a;i<num;i++)
		{
			if(value[i]==queue[b])
			{
				flag=i;
				break;
			}
		}
		return flag;
	}
	public int farthest(int n)
	{
		int max=0;
		for(int i=1;i<4;i++)
		{
			if(closest(n,max)<closest(n,i))
				max=i;
		}
		return max;
	}
	public void algo()
	{
		int i;
		for(i=0;i<num;i++)
		{
			int u=search(-1);
			if(u==-1)
			{
				int y=search(value[i]);
				if(y==-1)
				{	
					int replace=farthest(i);
					queue[replace]=value[i];
					faults=faults+1;
				}
			}
			else
			{
				int y=search(value[i]);
				if(y==-1)
				{
					int replace=farthest(i);
					queue[replace]=value[i];
					faults=faults+1;
				}
			}
			print();
		}	
	}
}