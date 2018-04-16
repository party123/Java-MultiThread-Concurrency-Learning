package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolWithRunnable {
	
	public static void main(String[] args){
		//创建线程池
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i = 1; i < 5;i ++){
			pool.execute(new Runnable(){		//提交任务
				@Override
				public void run(){
					System.out.println("Thread name:" + Thread.currentThread().getName());
					try{
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			});
		}
		pool.shutdown();
	}

}
