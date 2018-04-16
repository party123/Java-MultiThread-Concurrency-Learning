import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ThreadLocalTest {
	private static ThreadLocal<Integer> x = new ThreadLocal<Integer>();
	private static ThreadLocal<MyThreadScopeData> myThreadScopeData = new ThreadLocal<MyThreadScopeData>();
	public static void main(String args[]){
		for(int i = 0; i < 2; i++){
		new Thread(new Runnable(){
			@Override
			public void run(){
				int data = new Random().nextInt();
				System.out.println(Thread.currentThread().getName()+" has put data: "+ data);
				x.set(data);			//将数据存入线程,数据与线程绑定
				MyThreadScopeData myData = new MyThreadScopeData();
				myData.setName("name" + data);
				myData.setAge(data);
				myThreadScopeData.set(myData);
				new A().get();
				new B().get();
			}
		}).start();
		}
	}
	
	static class A{
		public void get(){
			int data = x.get();			//直接取与线程相关的数据
			System.out.println("A from " + Thread.currentThread().getName() + " get data: "+data);
			MyThreadScopeData myData = myThreadScopeData.get();
			System.out.println("A from " +Thread.currentThread().getName() + "Mydata: "+myData.getName());
			myData.setAge(data);
		}
	}
	
	static class B{
		public void get(){
			int data = x.get();
			System.out.println("B from " + Thread.currentThread().getName() + " get data: "+data);
		}
	}
	
	static class MyThreadScopeData{
		private String name;
		private int age;
		public String getName(){
			return name;
		}
		
		public void setName(String name){
			this.name = name;
		}
		
		public int getAge(){
			return age;
		}
		
		public void setAge(int age){
			this.age = age;
		}
	}

}
