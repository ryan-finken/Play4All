package org.launchcode.Play4All.data;

import org.launchcode.Play4All.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    //String findByEmail(String email);
}
