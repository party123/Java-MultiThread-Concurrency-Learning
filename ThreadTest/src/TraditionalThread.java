
public class TraditionalThread {
	public static void main(String args[]){
		Thread thread = new Thread(){
			@Override
			public void run(){
				while(true){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			}
		};
		thread.start();
		Thread thread2 = new Thread(new Runnable(){
			@Override
			public void run(){
				
			}
		});
	}

}
