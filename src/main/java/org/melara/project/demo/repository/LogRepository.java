package org.melara.project.demo.repository;

import org.melara.project.demo.entidad.Log;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {

}