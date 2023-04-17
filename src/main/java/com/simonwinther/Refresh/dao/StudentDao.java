package com.simonwinther.Refresh.dao;

import com.simonwinther.Refresh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.ListQuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Long>, ListQuerydslPredicateExecutor<Student> {
}
