package com.example.springData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springData.POJO.student;
import com.example.springData.Repository.studentJdbcDAO;

@RestController
public class controller1 {
    
	@Autowired
	studentJdbcDAO repo;
	
	@GetMapping("/")
	public String startApp(){
        return "App. started...enter correct URL";  		
	}
	
	@GetMapping("/students")
	public List<student> findAll(){
        return repo.findAllStudents();  		
	}
	
	@GetMapping("/students/{id}")
	public student findById( @PathVariable int id){
        return repo.findById(id);  		
	}
	
	
	@PostMapping("/students")
	public void addStudents(@RequestBody student stu1 ) {
		repo.AddStud(stu1);
	}
	
	
}
