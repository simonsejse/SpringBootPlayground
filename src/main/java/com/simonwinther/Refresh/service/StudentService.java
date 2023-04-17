package com.simonwinther.Refresh.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.simonwinther.Refresh.dao.StudentDao;
import com.simonwinther.Refresh.dto.StudentDTO;
import com.simonwinther.Refresh.entity.QStudent;
import com.simonwinther.Refresh.entity.Student;
import com.simonwinther.Refresh.exceptions.StudentNameCannotBeEmpty;
import com.simonwinther.Refresh.exceptions.StudentNotFound;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class StudentService {
    private static final Logger log = LoggerFactory.getLogger(StudentService.class);
    private final StudentDao studentDao;

    @Autowired
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Page<StudentDTO> getAllStudents(Pageable pageable){
        return studentDao
                .findAll(pageable)
                .map(student -> StudentDTO.builder()
                        .id(student.getId())
                        .name(student.getFullName())
                        .build()
                );
    }

    public StudentDTO getStudentById(Long id){
        var student = studentDao.findById(id).orElseThrow(StudentNotFound::new);

        return StudentDTO
                .builder()
                .id(student.getId())
                .name(student.getFullName())
                .build();
    }

    @Transactional
    public StudentDTO changeStudentName(Long id, String name){
        Student student = studentDao.findById(id)
                .orElseThrow(StudentNotFound::new);

        name = Optional.ofNullable(name)
                .filter(Predicate.not(String::isBlank))
                .filter(Predicate.not(String::isEmpty))
                .orElseThrow(StudentNameCannotBeEmpty::new);

        log.info(String.format("%s navn blev ændret til %s", student.getFullName(), name));

        student.setFullName(name);
        
        return StudentDTO.builder()
                .id(student.getId())
                .name(student.getFullName())
                .build();
    }

}
