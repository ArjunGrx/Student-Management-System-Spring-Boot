package com.gurung.Student_Management.Repository;

import com.gurung.Student_Management.dbConfig.Database;
import com.gurung.Student_Management.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private Database db;

    public StudentRepository(Database db){
        this.db = db;
    }

    public Student addStudent(Student student){
        db.save(student);
        return student;
    }

    public void removeStudent(int id){
        db.remove(id);
    }

    public void updateStudent(int id, Student student){
        db.update(id,student);
    }

    public Student findStudent(int id){
        Student student = db.findByID(id);
        if(student != null){
            return student;
        }

        return null;
    }

    public List<Student> getAllStudent(){
        return db.findAll();
    }

    public List<Student> findByName(String name){
        return db.findAll()
                .stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
