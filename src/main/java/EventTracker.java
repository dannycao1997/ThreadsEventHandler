import java.util.HashMap;
import java.util.Map;

/*Event Tracker
Singleton class that is synchronized between threads
Implements the Tracker interface
Should store the number of times a string has been sent into it
Push should increment the integer associated to the string passed in
Has should return true if there is an integer asssociated with the string passed in and if the integer is greater than 0
handle should take in an event handler. After running the event handler's handle function it should decrement the integer associated with the message passed in.
Handle should be the only way to decrement an integer in the map/
*/

public class EventTracker implements Tracker {

    private static EventTracker INSTANCE = new EventTracker();

    private Map<String, Integer> tracker;

    private EventTracker() {
        this.tracker = new HashMap<>();
    }

    synchronized public static EventTracker getInstance() {
        return INSTANCE; //
    }

    synchronized public void push(String message) {
        tracker.put(message, tracker.getOrDefault(message, 0) + 1 );
    }

    synchronized public Boolean has(String message) {
        return tracker.getOrDefault(message, 0) > 0;
    }

    synchronized public void handle(String message, EventHandler e) {
        if(has(message)) {
            e.handle();
            tracker.put(message, tracker.get(message) -1);
        }
    }

    // Do not use this. This constructor is for tests only
    // Using it breaks the singleton class
    EventTracker(Map<String, Integer> tracker) {
        this.tracker = tracker;
    }
}
