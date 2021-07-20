package todoapp.business;

import todoapp.service.TodoService;

import java.util.List;
import java.util.stream.Collectors;

//I want to test this class = System under test
public class TodoBusinessImpl {

    // dependency
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user) {
        return todoService.retrieveTodos(user).stream().filter(s -> s.contains("Spring")).collect(Collectors.toList());
    }
}
