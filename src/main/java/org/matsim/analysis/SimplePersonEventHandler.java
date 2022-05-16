package org.matsim.analysis;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.events.PersonArrivalEvent;
import org.matsim.api.core.v01.events.PersonDepartureEvent;
import org.matsim.api.core.v01.events.handler.PersonArrivalEventHandler;
import org.matsim.api.core.v01.events.handler.PersonDepartureEventHandler;
import org.matsim.api.core.v01.population.Person;

import java.util.HashMap;
import java.util.Map;

public class SimplePersonEventHandler implements PersonDepartureEventHandler, PersonArrivalEventHandler {
    private final Map<Id<Person>, Double> depTimes = new HashMap<>();
    @Override
    public void handleEvent(PersonDepartureEvent personDepartureEvent) {
        double dep = personDepartureEvent.getTime();
        Id<Person> id = personDepartureEvent.getPersonId();
        depTimes.put(id, dep);
        //System.out.println("Departure Time: " + personDepartureEvent.getTime() + " ID: " + personDepartureEvent.getPersonId());
    }

    @Override
    public void handleEvent(PersonArrivalEvent personArrivalEvent) {
        double arrTime = personArrivalEvent.getTime();
        double depTime = depTimes.get(personArrivalEvent.getPersonId());
        double travelTime = arrTime - depTime;
        //System.out.println("Arrival Time: " + personArrivalEvent.getTime() + " ID: " + personArrivalEvent.getPersonId());
        System.out.println("Person: " + personArrivalEvent.getPersonId() + "Travel Time: " + travelTime);
    }
}
