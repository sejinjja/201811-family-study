package com.study.todo.todo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	@Autowired
	TodoRepository todoRepository;

	@Transactional
	public Todo update(Todo updateTodo) {
		if (updateTodo.getCreateDate() == null || updateTodo.getCreateDate() == 0)
			updateTodo.setCreateDate(System.currentTimeMillis());
		return this.todoRepository.save(updateTodo);
	}

	@Transactional
	public void delete(Todo deleteTodo) {
		if (deleteTodo == null)
			throw new NullPointerException();
		this.todoRepository.deleteById(deleteTodo.getTodoId());
	}

	public List<Todo> updateList(List<Todo> updateTodoList) {
		updateTodoList.stream().forEach(updateTodo -> {
			if (updateTodo.getCreateDate() == null || updateTodo.getCreateDate() == 0)
				updateTodo.setCreateDate(System.currentTimeMillis());
		});

		return this.todoRepository.saveAll(updateTodoList);
	}

	public void deleteList(List<Todo> deleteTodoList) {
		if (deleteTodoList == null)
			throw new NullPointerException();
		this.todoRepository.deleteAll(this.todoRepository.findAllById(deleteTodoList.stream().map(deleteTodo -> {
			return deleteTodo.getTodoId();
		}).collect(Collectors.toList())));
	}

	public List<Todo> getList() {
		return this.todoRepository.findAll();
	}

}
