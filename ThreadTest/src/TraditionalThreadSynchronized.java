
public class TraditionalThreadSynchronized {
	static class Outputer{								//内部类可以访问外部类的成员函数，意味着外部类必须有实例对象
		public synchronized void output(String name){
			int len = name.length();				//互斥一定要是同一个对象
			for(int i = 0;i<len;i++)
				System.out.print(name.charAt(i));
			
		}
		
		public void output2(String name){
			int len = name.length();
			synchronized(name){					//互斥一定要是同一个对象
			for(int i = 0;i<len;i++)
				System.out.print(name.charAt(i));
			}
		}
		
		public static synchronized void output3(String name){
			int len = name.length();
						//互斥一定要是同一个对象
			for(int i = 0;i<len;i++)
				System.out.print(name.charAt(i));
			
		}
	}
	public static void main(String args[]){
		new TraditionalThreadSynchronized().init();
		/*
		Outputer outputer = new Outputer();		//不能在static静态方法中直接创建内部类的实例对象
		new Thread(new Runnable(){
			@Override
			public void run(){
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("lalala");
				}
			}
		}).start();
		*/
	}
	
	private void init(){
		Outputer outputer = new Outputer();
		new Thread(new Runnable(){
			@Override
			public void run(){
				while(true){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("lalala");
				}
			}
		}).start();
	}
}
