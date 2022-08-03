package com.vise.main.controller;

import com.vise.main.model.Payment;
import com.vise.main.servicio.PaymentService;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Gonzalo Moreno
 */
@Controller
public class PaymentController {

    private static final Logger logger = LogManager.getLogger(WorkerController.class.getName());

    @Autowired
    private PaymentService service;

    @RequestMapping("/workers/payments/{concepto}")
    @ResponseBody
    public List<Payment> findByConceptoGreaterThan(@PathVariable double concepto, Model model) {
        try {
            return service.findByConceptoGreaterThan(concepto);
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
    }
}
