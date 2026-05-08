package com.gurung.Student_Management.service;

import com.gurung.Student_Management.Repository.StudentRepository;
import com.gurung.Student_Management.exceptions.StudentNotFoundException;
import com.gurung.Student_Management.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    //constructor
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //add student
    public Student addStudent(Student student){
        return studentRepository.addStudent(student);
    }

    //remove student
    public Student removeStudent(int id){
        Student student = studentRepository.findStudent(id);
        if(student == null){
            throw new StudentNotFoundException("Student with "+id+" not found");
        }
        studentRepository.removeStudent(id);
        return student;
    }

    //update student
    public Student updateStudent(int id, Student student){
        Student existingStudent = studentRepository.findStudent(id);
        if(existingStudent == null){
            throw new StudentNotFoundException("Student with "+id+" not found to update");
        }

        studentRepository.updateStudent(id,student);
        return student;
    }

    //getAllStudent
    public List<Student> getAllStudent(){
        return studentRepository.getAllStudent();
    }

    //get student by name
    public List<Student> getStudentByName(String name){
        return studentRepository.getAllStudent();
    }
}
