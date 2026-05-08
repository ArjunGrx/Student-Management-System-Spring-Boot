package com.gurung.Student_Management.controller;

import com.gurung.Student_Management.model.Student;
import com.gurung.Student_Management.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudent();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student createdStudent = studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        Student removedStudent = studentService.removeStudent(id);
        return ResponseEntity.ok(removedStudent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        Student updatedStudent = studentService.updateStudent(id,student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name){
        List<Student> students = studentService.getStudentByName(name);
        return ResponseEntity.ok(students);
    }

}
