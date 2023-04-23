package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudController {
	@Autowired
	StudRepo repo;
	
	@GetMapping("/get")
	public List<Student> getAll()
	{
		return repo.findAll();
	}
	
	@GetMapping("/{id}")//View Database
	public Student getStudentById(@PathVariable int id)
	{
		return repo.findById(id).get();
	}
	
	@PostMapping("/create")//Insert into Database
	public Student createStudent (@RequestBody Student student)
	{
		return repo.save(student);
	}
	
	@PutMapping("/update/{id}")//Update into Database
	public String updateStudent(@RequestBody Student student,@PathVariable int id)
	{
		Student user = repo.findById(id).get();
		user.setName(student.getName());
		repo.save(user);
		return "Data Updated!!";
	}
	
	@DeleteMapping("/delete/{id}")//Delete into Database
	public String deleteStudent(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Deleted Successfully!!";
	}
	
	
	


}
