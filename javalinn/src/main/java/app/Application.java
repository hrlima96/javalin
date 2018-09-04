package app;

import io.javalin.Javalin;
import todo.ToDoController;

public class Application {
	public static void main(String[] args) {
        Javalin app = Javalin.create().start(3000);
        
        app.get("/todos/:id", ToDoController::getOne);
        app.get("/todos", ToDoController::getAll);
        app.post("/todos", ToDoController::create);
        app.patch("/todos", ToDoController::update);
        app.delete("/todos/:id", ToDoController::delete);
    }
}
