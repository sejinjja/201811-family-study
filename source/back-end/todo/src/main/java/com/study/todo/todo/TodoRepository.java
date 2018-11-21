package com.study.todo.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	public List<Todo> findAll();

	public Todo deleteByTodoId(Long todoId);

	public List<Todo> deleteAllByTodoIdIn(List<Long> todoIdList);

}
