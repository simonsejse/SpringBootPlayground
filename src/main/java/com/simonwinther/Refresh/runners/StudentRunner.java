package com.simonwinther.Refresh.runners;

import com.simonwinther.Refresh.dao.StudentDao;
import com.simonwinther.Refresh.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("student-adder")
public class StudentRunner implements CommandLineRunner{

    private final StudentDao studentDao;

    @Autowired
    public StudentRunner(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    @Override
    public void run(String... args) throws Exception {
        /*List<Student> students = List.of(
                Student.builder().fullName("Simon").build(),
                Student.builder().fullName("Tommy").build(),
                Student.builder().fullName("Tugge").build(),
                Student.builder().fullName("Peter").build()
        );
        studentDao.saveAll(students);*/
    }
}
