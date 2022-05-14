package org.matsim.analysis;

import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {
    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {
        System.out.println("Departure Time: " + personDepartureEvent.getTime() + " ID: " + personDepartureEvent.getPersonId());
    }

    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        System.out.println("Arrival Time: " + personArrivalEvent.getTime() + " ID: " + personArrivalEvent.getPersonId());
    }
}
