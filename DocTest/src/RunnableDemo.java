class TestThread implements Runnable
{
	
	private Thread t;
	private String threadName;
	
	TestThread(String name)
	{
		this.threadName = name;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//business logic to be written here
		System.out.println("thread "+this.threadName);
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void start() 
	{
		// TODO Auto-generated method stub
		if(t == null)
		{
			t = new Thread(this,threadName);
			t.start();
		}
		
	}
	
	
}

public class RunnableDemo 
{
//class body started
	public static void main(String args[])
	{
		TestThread T1 = new TestThread("Thread-1");
		T1.start();
		
		TestThread T2 = new TestThread("Thread-2");
		T2.start();
	}
//classs body ended
}