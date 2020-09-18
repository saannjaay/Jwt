/**
 * 
 */
package com.user.system.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.system.application.model.User;

/**
 * @author sanjsingh
 *
 */



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
