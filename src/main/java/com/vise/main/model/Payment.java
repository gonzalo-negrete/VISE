package com.vise.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Gonzalo Moreno
 */
@Entity
@Table(name = "payments")
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "concepto",nullable = false, length = 50)
    private double concepto;
    
    @Column(name = "idEmpleado",nullable = false, length = 50)
    private int idEmpleado;
    
    @Column(name = "fecha",nullable = false, length = 50)
    private String fecha;

    public Payment() {
    }

    public Payment(Long id, double concepto, int idEmpleado, String fecha) {
        this.id = id;
        this.concepto = concepto;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getConcepto() {
        return concepto;
    }

    public void setConcepto(double concepto) {
        this.concepto = concepto;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
