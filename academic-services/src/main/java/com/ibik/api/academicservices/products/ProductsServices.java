package com.ibik.api.academicservices.products;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibik.api.academicservices.chart.Chart;
import com.ibik.api.academicservices.chart.ChartRepo;

@Service
@Transactional
public class ProductsServices {
    
    @Autowired
    private ProductsRepo productsRepo;
    private ChartRepo chartRepo;

    public Products save(Products products){
        return productsRepo.save(products);
    }

    public Products findOne(int id){
        return productsRepo.findById(id).get();
    }

    public Iterable<Products> findAll(){
        return productsRepo.findAll();
    }

    public void removeOne(int id){
        productsRepo.deleteById(id);
    }
}
