package todoapp.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todoapp.service.TodoService;
import todoapp.stub.TodoServiceStub;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoBusinessImplStubTest {

    // System under Test
    private TodoBusinessImpl todoBusinessImpl;

    // Dependency
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        // stubbed service
        todoService = new TodoServiceStub();
        todoBusinessImpl = new TodoBusinessImpl(todoService);
    }

    @Test
    void retrieveTodosRelatedToSpringFromAStub() {
        String dummyUser = "Alper";

        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring(dummyUser);

        assertEquals(Arrays.asList("Learn Spring MVC", "Learn Spring"), todos);

    }

    @Test
    void retrieveNothingFromAStub() {
        String dummyUser = "Null";

        List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring(dummyUser);

        // have to add user specific scenarios to the stub. difficult to manage
        assertNull(todos);

    }

}
