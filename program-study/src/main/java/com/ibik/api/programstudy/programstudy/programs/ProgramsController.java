package com.ibik.api.programstudy.programstudy.programs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/programs")
public class ProgramsController {

    @Autowired
    private ProgramsServices programsServices;
    
    @PostMapping
    public Programs postPrograms(@RequestBody Programs programs) {
        return programsServices.save(programs);
    }

    @GetMapping
    public Iterable<Programs> fetchPrograms(){
        return programsServices.findAll();
    }

    @GetMapping("/{id}")
    public Programs fetchProgramsById(@PathVariable("id") int id){
        return programsServices.findOne(id);
    }

    @PutMapping
    public Programs updatePrograms(@RequestBody Programs programs){
        return programsServices.save(programs);
    }

    @DeleteMapping("/{id}")
    public void deleteProgramsById(@PathVariable("id") int id){
        programsServices.removeOne(id);
    }
    

}
