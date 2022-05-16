package org.matsim.analysis;

import com.sun.istack.localization.NullLocalizable;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.LinkLeaveEvent;
import org.matsim.api.core.v01.events.handler.LinkLeaveEventHandler;
import org.matsim.api.core.v01.network.Link;

import java.util.HashMap;
import java.util.Map;

public class LinkEventHandler implements LinkLeaveEventHandler {

    public Map<Integer, Integer> volume = new HashMap<>();
    private final Id<Link> link_id = Id.createLinkId("908198570000f");

    @Override
    public void handleEvent(LinkLeaveEvent linkLeaveEvent) {
        if (linkLeaveEvent.getLinkId().equals(link_id)) {
            int time = (int) (linkLeaveEvent.getTime() / 3600);
            volume.putIfAbsent(time, 0);
            int curr_volume = volume.get(time);
            volume.put(time, curr_volume + 1);
            //System.out.println(volume.size());
        }
    }
}
