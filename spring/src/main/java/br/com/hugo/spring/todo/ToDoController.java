package br.com.hugo.spring.todo;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import app.ToDo;
import app.ToDoDAO;

@Controller
@RequestMapping("/todos")
public class ToDoController {
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.GET)
	public ResponseEntity<Collection<ToDo>> getAll() throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		return new ResponseEntity<Collection<ToDo>>(dao.buscarTodos(), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<ToDo> getOne(@PathVariable(value="id")String id) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		return new ResponseEntity<ToDo>(dao.buscar(id), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.PATCH)
	public ResponseEntity<Integer> update(@RequestBody ToDo todo) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		return new ResponseEntity<Integer>(dao.atualizar(todo), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.POST)
	public ResponseEntity<Integer> create(@RequestBody ToDo todo) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		return new ResponseEntity<Integer>(dao.inserir(todo), HttpStatus.OK);
	}
	
	@ResponseBody
	@RequestMapping(value="/{id}", method = RequestMethod.POST)
	public ResponseEntity<Integer> delete(@PathVariable String id) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		dao.apagar(id);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
}
