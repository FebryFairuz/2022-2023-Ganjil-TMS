package com.ibik.api.academicservices.chart;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ChartServices {
    @Autowired
    private ChartRepo chartRepo;

    public Chart save(Chart chart){
        return chartRepo.save(chart);
    }

    public Chart findOne(int id){
        return chartRepo.findById(id).get();
    }

    public Iterable<Chart> findAll(){
        return chartRepo.findAll();
    }

    public void removeOne(int id){
        chartRepo.deleteById(id);
    }
    
    public List<Chart> findChartByUserID(int user_id) {
        return chartRepo.findChartByUserID(user_id);
    }
}
