class TestExtendThread extends Thread
{
	private Thread t;
	private String threadName;
	
	TestExtendThread(String name)
	{
		this.threadName = name;
	}
	@Override
	public void run()
	{
		//business logic
		System.out.println("thread "+this.threadName);
	}
	@Override
	public void start()
	{
		if(t == null)
		{
			t = new Thread(this,threadName);
			t.start();		
		}
	}
}


public class ExtendThread 
{
	public static void main(String args[])
	{
		TestExtendThread t1 = new TestExtendThread("Thread - 1");
		t1.start();
		TestExtendThread t2 = new TestExtendThread("Thread - 2");
		t2.start();
	}
}
