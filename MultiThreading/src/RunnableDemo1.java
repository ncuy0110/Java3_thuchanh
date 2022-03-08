
public class RunnableDemo1 {
	public static void main(String[] args) throws InterruptedException {
		Runnable printNumber = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread t1 = new Thread(printNumber);
		t1.start();
		t1.join();

		Thread t2 = new Thread(printNumber);
		t2.start();
		t2.join();

		Thread t3 = new Thread(printNumber);
		t3.start();
		t3.join();
	}
}
