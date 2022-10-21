package com.ibik.api.academicservices.courses;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibik.api.academicservices.dto.ResponseData;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    
    @Autowired
    private CoursesServices coursesServices;

    @PostMapping
    public ResponseEntity<ResponseData<Courses>> postCourses(@Valid @RequestBody Courses courses, Errors errors) {
        ResponseData<Courses> responseData = new ResponseData<>();
        
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }

            responseData.setResult(false);
            responseData.setData(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }

        responseData.setResult(true);
        List<Courses> value = new ArrayList<>();
        value.add(coursesServices.save(courses));
        responseData.setData(value);
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public ResponseEntity<ResponseData<Courses>> fetchCourses() {
        
        ResponseData<Courses> responseData = new ResponseData<>();
        
        try {
            Iterable<Courses> values = coursesServices.findAll();
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
    public ResponseEntity<ResponseData<Courses>> fetchCoursesById(@PathVariable("id") int id) {
        ResponseData<Courses> responseData = new ResponseData<>();
        try {
            Courses value = coursesServices.findOne(id);
            List<Courses> result = new ArrayList<>();
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
    public ResponseEntity<ResponseData<Courses>> updatePrograms(@Valid @RequestBody Courses courses, Errors errors) {
        ResponseData<Courses> responseData = new ResponseData<>();

        if (courses.getId() != 0) {

            if (errors.hasErrors()) {
                for (ObjectError error : errors.getAllErrors()) {
                    responseData.getMessage().add(error.getDefaultMessage());
                }

                responseData.setResult(false);
                responseData.setData(null);

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }

            responseData.setResult(true);
            List<Courses> value = new ArrayList<>();
            value.add(coursesServices.save(courses));
            responseData.setData(value);
            return ResponseEntity.ok(responseData);
        } else {
            responseData.setResult(false);
            responseData.setData(null);
            List<Courses> value = new ArrayList<>();
            value.add(coursesServices.save(courses));
            List<String> message = new ArrayList<>();
            message.add("ID is required");
            responseData.setMessage(message);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
    }

}
