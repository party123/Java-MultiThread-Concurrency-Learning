//���߳�ѭ��ִ��10�Σ����߳�ѭ��ִ��100�Σ������߳�10�Σ����߳�100�Σ��������ִ��50��
public class TraditionalthreadCommunication {
	static class Business{//�ڲ��� �����̷߳���  Ҫ�õ���ͬ���ݡ��㷨������ͬ�����������ɷ���Ӧ�ù���ͬһ��������
		private boolean bShouldSub = true;			//������
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
			this.notify();    //���ѵȴ��߳�
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
			this.notify();    //���ѵȴ��߳�
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
