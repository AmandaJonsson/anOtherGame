package event;

public class Event {

   //List of possible events
    public enum Tag {
        PLAYER_FLIPMARKER,
        PLAYER_BALANCE,
        PLAYER_POSITION,
        LOSTKITTEN_NEXT,
    }

    private final Tag tag;
    private final Object value;

    public Event(Tag tag, Object value) {
        this.tag = tag;
        this.value = value;
    }

    public Tag getTag() {
        return tag;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Event [tag=" + tag + ", value=" + value + "]";
    }
}
