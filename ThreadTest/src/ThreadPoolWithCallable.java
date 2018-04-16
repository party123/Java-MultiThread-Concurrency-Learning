package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolWithCallable {
	//主线程需要知道/拿到子线程执行结果时，需要用到callable接口和future
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for(int i = 0; i < 10;i++){
			Future<String> submit = pool.submit(new Callable<String>(){
				public String call() throws Exception{
					Thread.sleep(1000);
					return "b--" + Thread.currentThread().getName();
				}
			});
			//Future中get结果，这个方法会被阻塞，一直等到线程任务返回结果
			System.out.println(submit.get());
		}
		pool.shutdown();
	}
}
