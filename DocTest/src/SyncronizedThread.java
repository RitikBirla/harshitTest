class printDemo
{
	public void printNumber()
	{
		for(int i=1;i<=5;i++)
		{
			System.out.println("counter "+i);
		}
	}
}
class SynchThread extends Thread
{
	private Thread t;
	private String threadName;
	printDemo PD;
	
	SynchThread(String name,printDemo PD)
	{
		this.threadName = name;
		this.PD = PD;
	}
	public void run()
	{
		synchronized (PD) {
			PD.printNumber();
		}
		System.out.println("Exit thread "+this.threadName);
	}
	public void start()
	{
		if(t == null)
		{
			t = new Thread(this,threadName);
			t.start();
		}
	}
}
public class SyncronizedThread 
{
	public static void main(String args[])
	{
		printDemo PD = new printDemo();
		
		SynchThread S1 = new SynchThread("Thread -1",PD);
		S1.start();
		SynchThread S2 = new SynchThread("Thread -2",PD);
		S2.start();
	}
}
