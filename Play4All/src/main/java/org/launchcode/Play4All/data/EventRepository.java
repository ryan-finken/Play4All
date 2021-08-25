package org.launchcode.Play4All.data;

import jdk.jfr.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer> {
}
