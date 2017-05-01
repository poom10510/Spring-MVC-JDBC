package com.taweesoft.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taweesoft.dao.StudentDAOImpl;
import com.taweesoft.model.Student;


@Controller
public class HomeController {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	private StudentDAOImpl studentDAOImpl = (StudentDAOImpl) context.getBean("studentDAOImpl");
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Student> students = studentDAOImpl.listStudents();
		model.addAttribute("students", students);
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("studentForm", new Student());
		return "add";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("studentForm") Student student, BindingResult result, Model model) {
		System.out.println(String.format("Create Student: [id: %d] [name:%s] [age: %d]", student.getId(), student.getName(), student.getAge()));
		studentDAOImpl.create(student);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable("id") int id, Model model) {
		Student student = studentDAOImpl.getStudent(id);
		System.out.println(String.format("Listing Student: [id: %d] [name:%s] [age: %d]", student.getId(), student.getName(), student.getAge()));
		model.addAttribute("studentForm", new Student());
		model.addAttribute("student", student);
		return "update";
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public String update(@PathVariable("id") int id, @ModelAttribute("studentForm") Student student, BindingResult result, Model model) {
		System.out.println(String.format("Update Student: [id: %d] [name:%s] [age: %d]", student.getId(), student.getName(), student.getAge()));
		studentDAOImpl.update(id, student);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model) {
		Student student = studentDAOImpl.getStudent(id);
		System.out.println(String.format("Delete Student: [id: %d] [name:%s] [age: %d]", student.getId(), student.getName(), student.getAge()));
		studentDAOImpl.delete(id);
		return "redirect:/";
	}
}
