package org.launchcode.Play4All.data;

import org.launchcode.Play4All.models.Venue;
import org.springframework.data.repository.CrudRepository;

public interface VenueRepository extends CrudRepository<Venue, Integer> {
}
