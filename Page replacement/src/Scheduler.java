import java.util.Scanner;

public class Scheduler {
	public static void main(String[] args)
	{
		Scanner u=new Scanner(System.in);
		int choice=2;
		while(choice!=4)
		{
			System.out.println("Enter choice :");
			System.out.println("1)FIFO\n2)LRU\n3)OPT\n4)SecondChance\n5)QUIT");
			choice =u.nextInt();
			if(choice==1)
			{
				fifo f=new fifo();
				f.input();
				f.algo();
			}
			if(choice==2)
			{
				lru s=new lru();
				s.input();
				s.algo();
			}
			if(choice==3)
			{
				opt sc=new opt();
				sc.input();
				sc.algo();
			}
			if(choice==4)
			{
				sec sch=new sec();
				sch.input();
				sch.algo();
			}
		}
	}

}
