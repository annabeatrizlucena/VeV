package test;
import org.junit.jupiter.api.Test;

import main.Priority;
import main.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
        assertEquals("Test Task List", task.getTitle());
        assertEquals("Implement tests for the task list manager", task.getDescription());
        assertEquals("2023-08-21", task.getDueDate().toString());
        assertEquals(Priority.HIGH, task.getPriority());
    }
  
    @Test
    public void testTaskIdUniqueness() {
        Task task1 = new Task("Title", "Description", LocalDate.parse("2023-08-31", DateTimeFormatter.ISO_DATE), Priority.MEDIUM);
        Task task2 = new Task("Title", "Description", LocalDate.parse("2023-08-31", DateTimeFormatter.ISO_DATE), Priority.MEDIUM);

        assertNotEquals(task1.getId(), task2.getId());
    }

    @Test
    public void testTaskPriorityUpdate() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.MEDIUM);

        assertEquals(Priority.MEDIUM, task.getPriority());

        task.setPriority(Priority.HIGH);

        assertEquals(Priority.HIGH, task.getPriority());
    }

    @Test
    public void testTaskGetters() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.MEDIUM);

        assertEquals("Test Task List", task.getTitle());
        assertEquals("Implement tests for the task list manager", task.getDescription());
        assertEquals("2023-08-21", task.getDueDate().toString());
        assertEquals(Priority.MEDIUM, task.getPriority());
    }

//    @Test
//    public void testTaskSetters() {
//    	Task task = new Task("Test Task List", "Implement tests for the task list manager", LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.MEDIUM);
//
//        task.setTitle("Updated Test Task List");
//        assertEquals("Updated Test Task List", task.getTitle());
//
//        task.setDescription("Updated Implement tests for the task list manager");
//        assertEquals("Updated Implement tests for the task list manager", task.getDescription());
//
//        task.setDueDate(LocalDate.parse("2023-09-15", DateTimeFormatter.ISO_DATE));
//        assertEquals("2023-09-15", task.getDueDate());
//
//        task.setPriority(Priority.HIGH);
//        assertEquals(Priority.HIGH, task.getPriority());
//    }
//    
}
