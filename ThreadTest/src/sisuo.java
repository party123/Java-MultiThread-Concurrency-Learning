package test;

public class sisuo extends Thread{
	public int flag = 1;
	public static Object o1 = new Object(), o2 = new Object();
	@Override
	public void run(){
		if(flag == 1){
			synchronized(o1){
				try{
					Thread.sleep(500);
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o2){
					System.out.println(1);
				}
			}
		}
		
		if(flag == 0){
			synchronized(o2){
				try{
					Thread.sleep(500);
				}catch(Exception e){
					e.printStackTrace();
				}
				synchronized(o1){
					System.out.println(0);
				}
			}
		}
	}
	
	
	public static void main(String args[]){
		sisuo s1 = new sisuo();
		sisuo s2 = new sisuo();
		s1.flag = 1;
		s2.flag = 0;
		new Thread(s1).start();
		new Thread(s2).start();
	}
}
