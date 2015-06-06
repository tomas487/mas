package mas.messages;

/**
 * With this object, agents can send messages to each other
 * 
 * @author Tomas
 *
 */
public class Message implements Comparable<Message> {

    /**
     * message code describes type of operation
     */
    private int code;
    /**
     * message receiver
     */
    private int receiver;
    /**
     * time, when message will be processed
     */
    private long time;
    /**
     * optional message content
     */
    private Object content;

    public Message(int receiver, int code, long time) {
        super();
        this.code = code;
        this.receiver = receiver;
        this.time = time;
    }

    public Message(int receiver, int code, long time, Object content) {
        super();
        this.code = code;
        this.receiver = receiver;
        this.time = time;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public Object getContent() {
        return content;
    }

    public void setCode(int message) {
        this.code = message;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    /**
     * compareTo used for order messages by message time
     */
    public int compareTo(Message o) {
        if (this.getTime() < o.getTime()) {
            return -1;
        }
        if (this.getTime() > o.getTime()) {
            return 1;
        }
        return 0;
    }

}
