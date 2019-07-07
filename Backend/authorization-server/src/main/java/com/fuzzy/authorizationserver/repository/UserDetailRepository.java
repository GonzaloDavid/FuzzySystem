/*
Es quien conecta al almacen de los datos
 */
package com.fuzzy.authorizationserver.repository;

import com.fuzzy.authorizationserver.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ka
 */
public interface UserDetailRepository extends JpaRepository<User, Integer>{
    
    Optional<User> findByUsername(String name);
}
