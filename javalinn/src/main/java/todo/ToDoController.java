package todo;

import java.sql.SQLException;
import java.util.Collection;

import app.ToDo;
import app.ToDoDAO;
import io.javalin.Context;

public class ToDoController {

	public static void getAll(Context ctx) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		Collection<ToDo> todos = dao.buscarTodos();
		
		ctx.json(todos);
	}
	
	public static void getOne(Context ctx) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		ToDo todo = dao.buscar(ctx.pathParam("id"));
		
		ctx.json(todo);
	}
	
	public static void update(Context ctx) throws ClassNotFoundException, SQLException {
		ToDo todo = ctx.bodyAsClass(ToDo.class);
		
		ToDoDAO dao = new ToDoDAO();
		dao.atualizar(todo);
	}
	
	public static void create(Context ctx) throws ClassNotFoundException, SQLException {
		ToDo todo = ctx.bodyAsClass(ToDo.class);
		
		ToDoDAO dao = new ToDoDAO();
		dao.inserir(todo);
	}
	
	public static void delete(Context ctx) throws ClassNotFoundException, SQLException {
		ToDoDAO dao = new ToDoDAO();
		dao.apagar(ctx.pathParam("id"));
	}
}
