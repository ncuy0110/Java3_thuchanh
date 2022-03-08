
public class ThreadDemo extends Thread{
	private int number;
	public ThreadDemo(int k) {
		number = k;
	}
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
	
	public static void main(String[] args) throws InterruptedException {
		ThreadDemo td1 = new ThreadDemo(1);
		ThreadDemo td2 = new ThreadDemo(2);
		ThreadDemo td3 = new ThreadDemo(3);
		
		td1.start();
		td1.join();

		td2.start();
		td2.join();

		td3.start();
		td3.join();
		
		
	}
}
