//子线程循环执行10次，主线程循环执行100次，再子线程10次，主线程100次，如此往复执行50次
public class TraditionalthreadCommunication {
	static class Business{//内部类 两种线程方法  要用到共同数据。算法（包括同步锁）的若干方法应该归在同一个类身上
		private boolean bShouldSub = true;			//建立锁
		public synchronized void sub(int i){
			while(bShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 1; j <= 10; j++){
				System.out.println("Sub Thread sequece of" + j + ", loop of "+ i);
			}
			bShouldSub = false;
			this.notify();    //唤醒等待线程
		}
		
		public synchronized void main(int i){
			while(!bShouldSub){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 1; j <= 100; j++){
				System.out.println("Main Thread sequece of" + j +", loop of "+ i);
			}
			bShouldSub = true;
			this.notify();    //唤醒等待线程
		}
	}

	
	public static void main(String[] args){
		 final Business business = new Business();
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i = 1; i <= 50; i++){
					business.sub(i);
					}
				}
					
			}).start();
		
		for(int j =1; j<=50; j++){
			business.main(j);
		}
	}

}
