package com.vise.main.servicio;

import com.vise.main.model.Payment;
import com.vise.main.repository.PaymentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gonzalo Moreno
 */
@Service
public class PaymentServiceImplement implements PaymentService{

    @Autowired
    private PaymentRepository repo;
    
    @Override
    public List<Payment> findByConceptoGreaterThan(double concepto) {
        return repo.findByConceptoGreaterThan(concepto);
    }
    
}
