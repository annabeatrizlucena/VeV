package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);

        assertEquals("Test Task List", task.getTitle());
        assertEquals("Implement tests for the task list manager", task.getDescription());
        assertEquals("2023-08-21", task.getDueDate());
        assertEquals(Priority.HIGH, task.getPriority());
    }
    
    @Test
    public void testTaskIdUniqueness() {
        Task task1 = new Task("Title", "Description", "2023-08-31", Priority.MEDIUM);
        Task task2 = new Task("Title", "Description", "2023-08-31", Priority.MEDIUM);

        assertNotEquals(task1.getId(), task2.getId());
    }

    @Test
    public void testTaskPriorityUpdate() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.MEDIUM);

        assertEquals(Priority.MEDIUM, task.getPriority());

        task.setPriority(Priority.HIGH);

        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    public void testTaskGetters() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.MEDIUM);

        assertEquals("Test Task List", task.getTitle());
        assertEquals("Implement tests for the task list manager", task.getDescription());
        assertEquals("2023-08-21", task.getDueDate());
        assertEquals(Priority.MEDIUM, task.getPriority());
    }

    @Test
    public void testTaskSetters() {
    	Task task = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.MEDIUM);

        task.setTitle("Updated Test Task List");
        assertEquals("Updated Test Task List", task.getTitle());

        task.setDescription("Updated Implement tests for the task list manager");
        assertEquals("Updated Implement tests for the task list manager", task.getDescription());

        task.setDueDate("2023-09-15");
        assertEquals("2023-09-15", task.getDueDate());

        task.setPriority(Priority.HIGH);
        assertEquals(Priority.HIGH, task.getPriority());
    }
    
}
