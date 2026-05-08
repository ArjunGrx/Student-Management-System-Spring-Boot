package com.gurung.Student_Management.dbConfig;

import com.gurung.Student_Management.model.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Database {
    private final Map<Integer, Student> db;

    public Database(){
        db = new HashMap<>();
    }

    public void save(Student student){
        db.put(student.getId(), student);
    }

    public void remove(int id){
        db.remove(id);
    }

    public void update(int id, Student student){
        db.put(id,student);
    }

    public Student findByID(int id){
        if(db.containsKey(id)){
            return db.get(id);
        }

        return null;
    }

    public List<Student> findAll(){
        return new ArrayList<>(db.values());
    }
}
