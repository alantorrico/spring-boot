package com.dh.demo.repository;

import com.dh.demo.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Alan on 10/6/2017.
 */
public interface StudentRepository extends MongoRepository<Student, String>{
}
