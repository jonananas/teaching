package se.jonananas.teaching.patterns.observable;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

public class ObservableTest {

	class StringObservable extends Observable implements Runnable {
	    public void notify(String notification) {
	            setChanged();
	            notifyObservers(notification);
	        }

		@Override
		public void run() {
			throw new RuntimeException("Not Implemented");
		}
	}
	
	class StoringObserver implements Observer {

    	public List<String> notifications = new ArrayList<>();
    	
    	@Override
        public void update(Observable obj, Object arg) {
        	notifications.add((String)arg);
        }
	}
	
	StringObservable eventSource = new StringObservable();
	StoringObserver observer1 = new StoringObserver();

	@Test
	public void shouldNotifyObserver() {
		

			eventSource.addObserver(observer1);
			eventSource.notify("1st notification");
	        
	        assertThat(observer1.notifications).containsExactly("1st notification");
	}
	
	@Test
	public void shouldNotifyObserversOnlyAfterAdded() {
		
		StoringObserver observer2 = new StoringObserver();
		
		eventSource.addObserver(observer1);
		eventSource.notify("1st notification");
		
		eventSource.addObserver(observer2);
		eventSource.notify("2nd notification");
		
		assertThat(observer1.notifications).containsExactly("1st notification", "2nd notification");
		assertThat(observer2.notifications).containsExactly("2nd notification");
	}
}
