package com.vise.main.repository;

import com.vise.main.model.Worker;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gonzalo Moreno
 */
@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

    public List<Worker> findByEdad(int edad);
}
