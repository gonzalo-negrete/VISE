
package com.vise.main.servicio;

import com.vise.main.model.Worker;
import java.util.List;

/**
 *
 * @author Gonzalo Moreno
 */
public interface WorkerService {
    
    public List<Worker> getAllWorkers();
    
    public Worker addWorker(Worker worker);
    
    public Worker getWorkerFindId(Long id);
    
    public Worker updateWorker(Worker worker);
    
    public void deleteWorker(Long id);
    
    public List<Worker> findByEdad(int edad);
}
