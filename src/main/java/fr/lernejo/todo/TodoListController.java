package fr.lernejo.todo;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoListController{

    private final TodoRepository todoRepository;

    public TodoListController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }


    @GetMapping(value="/api/todo")
    public Iterable<TodoEntity> findAll(){

        return todoRepository.findAll();
    }

    @PostMapping(value = "/api/todo")
    public TodoEntity add(@RequestBody TodoEntity todo){

        return todoRepository.save(todo);
    }

}
 /*
@RestController
public class TodoListController{
    @GetMapping("/String")
    public String getString(){
        return "Spring";
    }
}*/
