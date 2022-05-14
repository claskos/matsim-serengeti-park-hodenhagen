package org.matsim.analysis;

import org.matsim.core.events.EventsUtils;

public class SimpleAnalysis {
    public static void main(String[] args) {
        var handler = new SimplePersonEventHandler();
        var manager = EventsUtils.createEventsManager();
        manager.addHandler(handler);
        String filename = "serengeti-park-v1.0-run1.output_events.xml.gz";
        EventsUtils.readEvents(manager, filename);
    }
}
