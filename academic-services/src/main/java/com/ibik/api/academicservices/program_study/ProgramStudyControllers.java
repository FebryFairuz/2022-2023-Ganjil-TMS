package com.ibik.api.academicservices.program_study;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.api.academicservices.dto.ResponseData;

@RestController
@RequestMapping("/api/program-study")
public class ProgramStudyControllers {

    @Autowired
    private ProgramStudyServices programStudyServices;

    @PostMapping
    public ResponseEntity<ResponseData<ProgramStudy>> postProgramStudy(@Valid @RequestBody ProgramStudy programStudy,
            Errors errors) {
        // ResponseData<Students> responseData = new ResponseData<>();
        ResponseData<ProgramStudy> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<ProgramStudy> value = new ArrayList<>();
        value.add(programStudyServices.save(programStudy));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<ProgramStudy>> fetchProgramStudy() {
        ResponseData<ProgramStudy> responseData = new ResponseData<>();
        try {
            Iterable<ProgramStudy> values = programStudyServices.findAll();
            responseData.setResult(true);
            responseData.setMessage(null);
            responseData.setData(values);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseData<ProgramStudy>> fetchProgramsById(@PathVariable("id") int id) {
        ResponseData<ProgramStudy> responseData = new ResponseData<>();
        try {
            ProgramStudy value = programStudyServices.findOne(id);
            List<ProgramStudy> result = new ArrayList<>();
            result.add(value);
            responseData.setData(result);
            responseData.setResult(true);
            responseData.setMessage(null);
            return ResponseEntity.ok(responseData);
        } catch (Exception e) {
            List<String> message = new ArrayList<>();
            message.add(e.getMessage());
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @PutMapping
    public ResponseEntity<ResponseData<ProgramStudy>> updatePrograms(@Valid @RequestBody ProgramStudy programStudy, Errors errors) {
        ResponseData<ProgramStudy> responseData = new ResponseData<>();

        if (programStudy.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }

                responseData.setResult(false);
                responseData.setData(null);

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<ProgramStudy> value = new ArrayList<>();
            value.add(programStudyServices.save(programStudy));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<ProgramStudy> value = new ArrayList<>();
            value.add(programStudyServices.save(programStudy));
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData<ProgramStudy>> deleteProgramsById(@PathVariable("id") int id) {
        //programStudyServices.removeOne(id);
        ResponseData<ProgramStudy> responseData = new ResponseData<>();
        if(id != 0){
            try {
                programStudyServices.removeOne(id);
                List<String> message = new ArrayList<>();
                message.add("Successfully removed");
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(true);
                return ResponseEntity.ok(responseData);
            } catch (Exception e) {
                List<String> message = new ArrayList<>();
                message.add(e.getMessage());
                responseData.setMessage(message);
                responseData.setData(null);
                responseData.setResult(false);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
        }else{
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            responseData.setData(null);
            responseData.setResult(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}
