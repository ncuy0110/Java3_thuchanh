
public class RunnableDemo implements Runnable{
	private int number;
	
	public RunnableDemo(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("Thread " + number + " index: "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableDemo(1));
		t1.start();
		
		Thread t2 = new Thread(new RunnableDemo(2));
		t2.start();
	}


}
