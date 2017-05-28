package event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * From Hajo's Monopoly:
 * A very simple event bus. All observers can register for events and
 * an observable can publish (send) events.
 */
public enum EventBus {

    BUS;

    private final List<IEventHandler> handlers
            = Collections.synchronizedList(new ArrayList<>());
    private boolean trace = true;

    public void register(IEventHandler handler) {
        handlers.add(handler);
    }

    public void publish(Event evt) {
        // Tracking all events
        synchronized (handlers) {
            handlers.stream().forEach((evh) -> {
                evh.onEvent(evt);
            });
        }
    }
}

