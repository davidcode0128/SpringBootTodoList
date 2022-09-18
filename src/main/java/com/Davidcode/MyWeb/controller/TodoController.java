package com.Davidcode.MyWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Davidcode.MyWeb.model.entity.Todo;
import com.Davidcode.MyWeb.service.TodoService;

@Controller
public class TodoController {

	@Autowired
	TodoService todoService;// 取得Service物件

	@GetMapping("/todos")
	public String getTodos(Model model) {
		Iterable<Todo> todoList = todoService.getTodo();
		model.addAttribute("todolist", todoList);
		Todo todo = new Todo();
		model.addAttribute("todoObject", todo);
		return "todolist";
	}

    @PostMapping("/todos")
    public String createTodo(@ModelAttribute Todo todo, Model model) {
        Iterable<Todo> allTodoList = todoService.createTodo(todo);
        Todo emptyTodo = new Todo();
        model.addAttribute("todolist", allTodoList);
        model.addAttribute("todoObject", emptyTodo);
        return "redirect:/todos";
    }
	
	@ResponseBody
	@PutMapping("/todos/{id}")
	public void upadteTodo(@PathVariable Integer id, @RequestBody Todo todo) {
		todoService.updateTodo(id, todo);
	}

	@ResponseBody
	@DeleteMapping("/todos/{id}")
	public void deleteTodo(@PathVariable Integer id) {
		todoService.deleteTodo(id);
	}
}