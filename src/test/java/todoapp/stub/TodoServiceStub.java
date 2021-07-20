package todoapp.stub;

import todoapp.service.TodoService;

import java.util.Arrays;
import java.util.List;

//This is a stub: hardcode the values
public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}
