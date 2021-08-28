package org.launchcode.Play4All.data;


import org.launchcode.Play4All.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;



public interface EventRepository extends JpaRepository<Event, Integer> {
}
