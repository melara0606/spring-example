package org.melara.project.demo.repository;

import java.io.Serializable;

import org.melara.project.demo.entidad.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
  public abstract User findByUsername(String username);
}