import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Timer().schedule(new TimerTask(){
				@Override
				public void run(){
					System.out.println("boom");
				}
			}, 100,200); 
			
	}

}
