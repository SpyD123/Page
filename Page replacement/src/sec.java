import java.util.Scanner;

public class sec {
	Scanner x=new Scanner(System.in);
	public int[] value;
	public int[][] queue;
	public int num;
	public int faults;
	
	public sec()
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
				return i;
		}
		return -1;
	}
	public int find()
	{
		int r=0;
		for(int i=0;i<4;i++)
		{
			if(queue[i][1]==1)
			{
				r=i;
				break;
			}
		}
		return r;
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
					int replace=find();
					queue[replace][0]=value[i];
					queue[replace][1]=0;
					faults=faults+1;
				}
				else
				{
					queue[y][1]=(queue[y][1]+1)%2;
				}
			}
			else
			{
				int y=search(value[i]);
				if(y==-1)
				{
					int replace=find();
					queue[replace][0]=value[i];
					queue[replace][1]=0;
					faults=faults+1;
				}
				else
				{
					queue[y][1]=(queue[y][1]+1)%2;
				}
			}
			print();
		}
	}
}
