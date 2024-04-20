/*
Event Listener
Extends Thread
Takes in a message to listen for and a reply to respond with
Optionally can take in a custom tracker. Defaults to the EventTracker singleton class
The run method should use a while loop that continues to run as long as "readyToQuit" returns false
ready to quit should return true if there is a "quit" event in the event tracker
The should reply method should return true if the event tracker has a message the listener is listening for
In the while loop, if should reply returns true, the Tracker should have its "handle" method called passing in an instance of EventHandler.
The Handler should print out the reply
 */


public class EventListener {

    private String messageToListenFor;
    private String messageToReplyWith;
    private Tracker eventTracker;

    public EventListener(String message, String reply) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = EventTracker.getInstance();
    }

    public EventListener(String message, String reply, Tracker tracker) {
        this.messageToListenFor = message;
        this.messageToReplyWith = reply;
        this.eventTracker = tracker;
    }

    @Override
    public void run() {
    }

    public Boolean readyToQuit() {
        return null;
    }

    public Boolean shouldReply() {
        return null;
    }

    public void reply() {
    }
}