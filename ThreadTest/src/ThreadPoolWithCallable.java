package test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolWithCallable {
	//���߳���Ҫ֪��/�õ����߳�ִ�н��ʱ����Ҫ�õ�callable�ӿں�future
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for(int i = 0; i < 10;i++){
			Future<String> submit = pool.submit(new Callable<String>(){
				public String call() throws Exception{
					Thread.sleep(1000);
					return "b--" + Thread.currentThread().getName();
				}
			});
			//Future��get�������������ᱻ������һֱ�ȵ��߳����񷵻ؽ��
			System.out.println(submit.get());
		}
		pool.shutdown();
	}
}
