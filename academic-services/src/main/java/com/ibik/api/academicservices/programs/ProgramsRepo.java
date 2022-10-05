package com.ibik.api.academicservices.programs;

import org.springframework.data.repository.CrudRepository;

public interface ProgramsRepo extends CrudRepository<Programs, Integer> {
    //function query JPAQL atau Mysql QUERY
}
