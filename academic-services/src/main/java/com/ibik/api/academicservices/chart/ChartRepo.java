package com.ibik.api.academicservices.chart;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ibik.api.academicservices.products.Products;

public interface ChartRepo extends CrudRepository<Chart, Integer>{
    @Query(value = "SELECT a.* FROM student_rel_product a WHERE a.student_id  = :user_id ", nativeQuery = true)
    public List<Chart> findChartByUserID(@PathParam("user_id") int user_id);

}
