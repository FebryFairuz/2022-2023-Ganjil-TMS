package com.ibik.api.academicservices.program_study;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramStudyServices {
    
    @Autowired
    private ProgramStudyRepo programStudyRepo;

    public ProgramStudy save(ProgramStudy programStudy){
        return programStudyRepo.save(programStudy);
    }

    public ProgramStudy findOne(int id){
        return programStudyRepo.findById(id).get();
    }

    public Iterable<ProgramStudy> findAll(){
        return programStudyRepo.findAll();
    }

    public void removeOne(int id){
        programStudyRepo.deleteById(id);
    }
}
