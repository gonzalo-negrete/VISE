package com.vise.main.controller;

import com.vise.main.model.Worker;
import com.vise.main.servicio.WorkerService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Gonzalo Moreno
 */
@Controller
public class WorkerController {

    private static final Logger logger = LogManager.getLogger(WorkerController.class.getName());

    @Autowired
    private WorkerService service;

    @GetMapping({"/workers", "/"})
    public String getWorkers(Model model) {
        try {
            model.addAttribute("lstWorkers", service.getAllWorkers());
        } catch (Exception e) {
            logger.error(e);
        }
        return "workers";
    }

    @GetMapping("/workers/new")
    public String formWorker(Model model) {
        try {
            Worker worker = new Worker();
            model.addAttribute("worker", worker);
        } catch (Exception e) {
            logger.error(e);
        }
        return "newWorker";
    }

    @PostMapping("/workers")
    public String addWorker(@ModelAttribute("worker") Worker worker) {
        try {
            service.addWorker(worker);
        } catch (Exception e) {
            logger.error(e);
        }
        return "/workers";
    }

    @GetMapping("/workers/update/{id}")
    public String formWorkerUpdate(@PathVariable Long id, Model model) {
        try {
            model.addAttribute("worker", service.getWorkerFindId(id));
        } catch (Exception e) {
            logger.error(e);
        }
        return "updateWorker";
    }

    @PostMapping("/workers/{id}")
    public String updateWorker(@PathVariable Long id, @ModelAttribute("worker") Worker worker, Model model) {
        try {
            Worker workerExist = service.getWorkerFindId(id);
            workerExist.setId(id);
            workerExist.setNombre(worker.getNombre());
            workerExist.setApellidos(worker.getApellidos());
            workerExist.setEdad(worker.getEdad());

            service.updateWorker(workerExist);
        } catch (Exception e) {
            logger.error(e);
        }
        return "redirect:/workers";
    }

    @GetMapping("/workers/{id}")
    public String deleteWorker(@PathVariable Long id) {
        try {
            service.deleteWorker(id);
        } catch (Exception e) {
            logger.error(e);
        }
        return "redirect:/workers";
    }

    @RequestMapping("/workers/age/{edad}")
    @ResponseBody
    public List<Worker> findByAge(@PathVariable int edad, Model model) {
        try {
            return service.findByEdad(edad);
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }
}
