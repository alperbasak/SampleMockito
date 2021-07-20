package todoapp.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todoapp.service.TodoService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TodoBusinessImplMockTest {

    // System under Test
    private TodoBusinessImpl todoBusinessImpl;

    // Dependency
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        todoService = mock(TodoService.class);
        todoBusinessImpl = new TodoBusinessImpl(todoService);
    }

    @Test
    void retrieveTodosRelatedToSpringFromAMock() {
        // Arrange
        String user = "Dummy";
        List<String> todos = Arrays.asList("Learn Spring", "Learn Dancing", "Fly");

        when(todoService.retrieveTodos(user)).thenReturn(todos);

        // Act
        List<String> results = todoBusinessImpl.retrieveTodosRelatedToSpring(user);

        // Assert
        assertEquals(1, results.size());
    }

    @Test
    void retrieveNullFromEmptyTodosRelatedToSpringFromAMock() {
        // Arrange
        String user = "Dummy";
        List<String> todos = Collections.emptyList();

        when(todoService.retrieveTodos(user)).thenReturn(todos);

        // Act
        List<String> results = todoBusinessImpl.retrieveTodosRelatedToSpring(user);

        // Assert
        assertEquals(0, results.size());
    }

    @Test
    void argumentMatcher() {
        when(todoService.retrieveTodos(anyString())).thenReturn(anyList());
        List<String> results = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, results.size());
        verify(todoService).retrieveTodos("Dummy");
    }

    @Test
    void exceptionThrower() {
        when(todoService.retrieveTodos(anyString())).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy"));
    }

    @Test
    void realCaseTester() {
        when(todoService.retrieveTodos(anyString())).thenCallRealMethod();
        assertThrows(RuntimeException.class, () -> todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy"));
    }
}
