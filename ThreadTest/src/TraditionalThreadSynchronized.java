
public class TraditionalThreadSynchronized {
	static class Outputer{								//�ڲ�����Է����ⲿ��ĳ�Ա��������ζ���ⲿ�������ʵ������
		public synchronized void output(String name){
			int len = name.length();				//����һ��Ҫ��ͬһ������
			for(int i = 0;i<len;i++)
				System.out.print(name.charAt(i));
			
		}
		
		public void output2(String name){
			int len = name.length();
			synchronized(name){					//����һ��Ҫ��ͬһ������
			for(int i = 0;i<len;i++)
				System.out.print(name.charAt(i));
			}
		}
		
		public static synchronized void output3(String name){
			int len = name.length();
						//����һ��Ҫ��ͬһ������
			for(int i = 0;i<len;i++)
				System.out.print(name.charAt(i));
			
		}
	}
	public static void main(String args[]){
		new TraditionalThreadSynchronized().init();
		/*
		Outputer outputer = new Outputer();		//������static��̬������ֱ�Ӵ����ڲ����ʵ������
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
