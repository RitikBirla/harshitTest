class Chat
{
	boolean flag = false;
	
	public synchronized void Questions(String msg)
	{
		if(flag)
		{
			try {
				System.out.println("Inside Question wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Question : "+msg);
		flag = true;
		System.out.println("Inside Question notify");
		notify();
	}
	public synchronized void Answer(String msg)
	{
		if(!flag)
		{
			try {
				System.out.println("inside Answer wait");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Answer : "+msg);
		flag = true;
		System.out.println("Inside Answer notify");
		notify();
	}
}

class T1 implements Runnable
{
	Chat m;
	String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };
	T1(Chat m1)
	{
		
		this.m = m1;
		System.out.println("Starting T1 thread");
		new Thread(this,"Questions").start();
	}
	@Override
	public void run() {
		for(int i=0; i<s1.length;i++)
		{
			System.out.println("loop for Question "+i);
			m.Questions(s1[i]);
		}
		
	}
	
}
class T2 implements Runnable
{
	Chat m;
	String[] s2 = { "Hi", "I am good, what about you?", "Great!" };
	T2(Chat m2)
	{
		this.m = m2;
		System.out.println("Starting T2 thread");
		new Thread(this,"Answer").start();
	}

	@Override
	public void run() {
		for(int j=0;j<s2.length;j++)
		{
			System.out.println("loop for Answer "+j);
			m.Answer(s2[j]);
		}
		
	}
	
}
public class interComThread 
{
	public static void main(String args[])
	{
		Chat m = new Chat();
		System.out.println("Main Method");
		new T1(m);
		System.out.println("Setting T1");
		new T2(m);
		System.out.println("Setting T2");
	}

}
