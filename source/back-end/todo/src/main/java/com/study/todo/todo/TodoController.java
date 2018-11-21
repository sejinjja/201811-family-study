package com.study.todo.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.todo.StdResponse;

@RestController
@RequestMapping("/todo/v1")
public class TodoController {
	@Autowired
	private TodoService todoService;

	@GetMapping("getList")
	public StdResponse<List<Todo>> getGallery() {
		List<Todo> todoList = null;

		StdResponse<List<Todo>> res = new StdResponse<>();

		try {
			todoList = this.todoService.getList();
		} catch (Exception e) {
			res.setMessage(e.toString());
			return res;
		}

		if (todoList != null) {
			res.setCode(200);
			res.setMessage("success");
			res.setPayload(todoList);
		} else {
			res.setCode(404);
			res.setMessage("not found");
		}

		return res;
	}

	@PostMapping("update")
	public StdResponse<Todo> update(@RequestBody Todo updateTodo) {
		Todo ret = null;
		StdResponse<Todo> res = new StdResponse<>();

		try {
			ret = this.todoService.update(updateTodo);
		} catch (Exception e) {
			res.setMessage(e.toString());
			return res;
		}

		if (ret != null) {
			res.setCode(200);
			res.setMessage("success");
			res.setPayload(ret);
		} else {
			res.setCode(404);
			res.setMessage("not found");
		}

		return res;
	}

	@PostMapping("delete")
	public StdResponse<Todo> delete(@RequestBody Todo deleteTodo) {
		StdResponse<Todo> res = new StdResponse<>();

		try {
			this.todoService.delete(deleteTodo);
		} catch (Exception e) {
			res.setMessage(e.toString());
			return res;
		}

		res.setCode(200);
		res.setMessage("success");

		return res;
	}

	@PostMapping("updateList")
	public StdResponse<List<Todo>> update(@RequestBody List<Todo> updateTodoList) {
		List<Todo> ret = null;
		StdResponse<List<Todo>> res = new StdResponse<>();

		try {
			ret = this.todoService.updateList(updateTodoList);
		} catch (Exception e) {
			res.setMessage(e.toString());
			return res;
		}

		if (ret != null) {
			res.setCode(200);
			res.setMessage("success");
			res.setPayload(ret);
		} else {
			res.setCode(404);
			res.setMessage("not found");
		}

		return res;
	}

	@PostMapping("deleteList")
	public StdResponse<List<Todo>> deleteList(@RequestBody List<Todo> deleteTodoList) {
		StdResponse<List<Todo>> res = new StdResponse<>();

		try {
			this.todoService.deleteList(deleteTodoList);
		} catch (Exception e) {
			res.setMessage(e.toString());
			return res;
		}

		res.setCode(200);
		res.setMessage("success");

		return res;
	}

}
