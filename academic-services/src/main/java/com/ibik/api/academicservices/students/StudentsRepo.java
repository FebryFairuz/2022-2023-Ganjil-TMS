package com.ibik.api.academicservices.students;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepo extends CrudRepository<Students, Integer>{
    
    //@Query(value = "SELECT a.* FROM students a WHERE a.firstname = :name ", nativeQuery = true)
    @Query("SELECT a FROM Students a WHERE (a.firstname like %:name% or a.middlename like %:name%  or a.lastname like %:name%) or a.npm  like %:name% ")
    //@Query("SELECT a FROM Students a WHERE (a.firstname like %:name% or a.middlename like %:name%  or a.lastname like %:name%) or a.npm  like %:name% ")
    public Iterable<Students> findStudentByName(@PathParam("name") String name);

    @Query(value = "SELECT a.* FROM students a WHERE a.email = :email AND concat(DATE_FORMAT(a.birthdate, '%d%m%Y'), '@', a.npm) = :password ", nativeQuery = true)
    public Students findStudentByAuth(@PathParam("email") String email, @PathParam("password") String password);

}
