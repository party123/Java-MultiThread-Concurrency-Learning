
public class MultiThreadShareData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShareData1 data1 = new ShareData1();
		new Thread(data1).start();
		new Thread(data1).start();
	}
	

}
class ShareData1 implements Runnable{
	@Override
	public void run(){
		
	}
	private int j = 0;
	public synchronized void increment(){
		j++;
	}
	
	public synchronized void decrement(){
		j--;
	}
}
