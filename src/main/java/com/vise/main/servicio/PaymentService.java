package com.vise.main.servicio;

import com.vise.main.model.Payment;
import java.util.List;

/**
 *
 * @author Gonzalo Moreno
 */
public interface PaymentService {

    public List<Payment> findByConceptoGreaterThan(double concepto);
}
