package com.ibik.api.academicservices.chart;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ibik.api.academicservices.products.Products;
import com.ibik.api.academicservices.students.Students;

@Entity
@Table(name="student_rel_product")
public class Chart {
    private static final long serialVersionUID = 1L;
    
    @Id 
    private String invoice_code;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    //@JsonManagedReference
    private Students students;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    //@JsonManagedReference
    private Products products;

    private int total;

    public Chart() {
    }

    public Chart(String invoice_code, Students students, Products products, int total) {
        this.invoice_code = invoice_code;
        this.students = students;
        this.products = products;
        this.total = total;
    }

    public String getInvoice_code() {
        return invoice_code;
    }

    public void setInvoice_code(String invoice_code) {
        this.invoice_code = invoice_code;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
