package com.ibik.api.academicservices.courses;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CoursesServices {

    @Autowired
    private CoursesRepo coursesRepo;

    public Courses save(Courses courses){
        return coursesRepo.save(courses);
    }

    public Courses findOne(int id){
        return coursesRepo.findById(id).get();
    }

    public Iterable<Courses> findAll(){
        return coursesRepo.findAll();
    }

    public void removeOne(int id){
        coursesRepo.deleteById(id);
    }
    
}
