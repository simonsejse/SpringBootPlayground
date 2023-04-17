package com.simonwinther.Refresh.controller;

import com.simonwinther.Refresh.dto.StudentDTO;
import com.simonwinther.Refresh.service.StudentService;
import io.vavr.control.Option;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE },
            path="/api/students"
    )
    public Page<StudentDTO> getAllStudents(Pageable pageable){
        return studentService.getAllStudents(pageable);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            path="/api/student/{id}"
    )
    public StudentDTO getStudent(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            path="/api/student/{id}/changename"
    )
    public StudentDTO changeName(@PathVariable Long id, @RequestParam String newName){
        return studentService.changeStudentName(id, newName);
    }

}
