package com.study.todo.todo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_todo")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "todo_id", nullable = false)
	private Long todoId;

	@Column(name = "todo_text", nullable = false)
	private String todoText;

	@Column(name = "create_date", nullable = false)
	private Long createDate;
	
	@Column(name = "done")
	private int done;
	

}
