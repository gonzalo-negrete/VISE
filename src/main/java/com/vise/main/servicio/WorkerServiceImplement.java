package com.vise.main.servicio;

import com.vise.main.model.Worker;
import com.vise.main.repository.WorkerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gonzalo Moreno
 */
@Service
public class WorkerServiceImplement implements WorkerService {
    
    @Autowired
    private WorkerRepository repo;
    
    @Override
    public List<Worker> getAllWorkers() {
        return repo.findAll();
    }
    
    @Override
    public Worker addWorker(Worker worker) {
        return repo.save(worker);
    }
    
    @Override
    public Worker getWorkerFindId(Long id) {
        return repo.findById(id).get();
    }
    
    @Override
    public Worker updateWorker(Worker worker) {
        return repo.save(worker);
    }
    
    @Override
    public void deleteWorker(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Worker> findByEdad(int edad) {
        return repo.findByEdad(edad);
    }
}
