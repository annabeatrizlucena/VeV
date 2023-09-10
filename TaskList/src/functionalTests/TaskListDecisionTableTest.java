package functionalTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Priority;
import main.Task;
import main.TaskList;

class TaskListDecisionTableTest {

	private TaskList taskList;

	@BeforeEach
	public void setUp() {
		taskList = new TaskList();
	}

	@Test
	public void testCreateTask_ValidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH));
		assertEquals(1, taskList.getNumberOfTasks());
	}

	@Test
	public void testCreateTask_InvalidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task(null, "Description", LocalDate.now(), Priority.HIGH));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@Test
	public void testCreateTask_ValidTitle_InvalidDescription_ValidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", null, LocalDate.now(), Priority.HIGH));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@Test
	public void testCreateTask_ValidTitle_ValidDescription_InvalidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", "Description", null, Priority.HIGH));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@Test
	public void testCreateTask_ValidTitle_ValidDescription_ValidDueDate_InvalidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", "Description", LocalDate.now(), null));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@Test
	public void testCreateTask_InvalidTitle_InvalidDescription_InvalidDueDate_InvalidPriority() {
		String taskId = taskList.addTask(new Task(null, null, null, null));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@Test
	public void testUpdateTask_ValidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		Task updatedTask = new Task("Updated Task", "New Description", LocalDate.now(), Priority.LOW);
		taskList.updateTask(taskId, updatedTask);

		assertEquals("Updated Task", originalTask.getTitle());
		assertEquals("New Description", originalTask.getDescription());
		assertEquals(Priority.LOW, originalTask.getPriority());
	}

	@Test
	public void testUpdateTask_InvalidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Task updatedTask = new Task(null, "New Description", LocalDate.now(), Priority.LOW);
			taskList.updateTask(taskId, updatedTask);
		});
		assertEquals("Invalid value", exception.getMessage());

		assertEquals("Sample Task", originalTask.getTitle());
		assertEquals("Description", originalTask.getDescription());
		assertEquals(Priority.HIGH, originalTask.getPriority());
	}

	@Test
	public void testUpdateTask_ValidTitle_InvalidDescription_ValidDueDate_ValidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Task updatedTask = new Task("Updated Task", null, LocalDate.now(), Priority.LOW);
			taskList.updateTask(taskId, updatedTask);
		});

		assertEquals("Invalid value", exception.getMessage());

		assertEquals("Sample Task", originalTask.getTitle());
		assertEquals("Description", originalTask.getDescription());
		assertEquals(Priority.HIGH, originalTask.getPriority());
	}

	@Test
	public void testUpdateTask_ValidTitle_ValidDescription_InvalidDueDate_ValidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Task updatedTask = new Task("Updated Task", "New Description", null, Priority.LOW);
			taskList.updateTask(taskId, updatedTask);
		});

		assertEquals("Invalid value", exception.getMessage());

		assertEquals("Sample Task", originalTask.getTitle());
		assertEquals("Description", originalTask.getDescription());
		assertEquals(Priority.HIGH, originalTask.getPriority());
	}

	@Test
	public void testUpdateTask_ValidTitle_ValidDescription_ValidDueDate_InvalidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Task updatedTask = new Task("Updated Task", "New Description", LocalDate.now(), null);
			taskList.updateTask(taskId, updatedTask);
		});

		assertEquals("Invalid value", exception.getMessage());

		assertEquals("Sample Task", originalTask.getTitle());
		assertEquals("Description", originalTask.getDescription());
		assertEquals(Priority.HIGH, originalTask.getPriority());
	}

	@Test
	public void testUpdateTask_InvalidTitle_InvalidDescription_InvalidDueDate_InvalidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
			Task updatedTask = new Task(null, null, null, null);
			taskList.updateTask(taskId, updatedTask);
		});

		assertEquals("Invalid value", exception.getMessage());

		assertEquals("Sample Task", originalTask.getTitle());
		assertEquals("Description", originalTask.getDescription());
		assertEquals(Priority.HIGH, originalTask.getPriority());
	}

	@Test
	public void testDeleteTask_ValidId() {
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);

		assertEquals(1, taskList.getNumberOfTasks());
		taskList.deleteTask(taskId);

		assertEquals(0, taskList.getNumberOfTasks());
	}

	@Test
	public void testDeleteTask_InvalidId() {
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);

		assertEquals(1, taskList.getNumberOfTasks());

		taskList.deleteTask("2");

		assertEquals(1, taskList.getNumberOfTasks());
	}

	@Test
	public void testGetTask_ValidId() {
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);

		Task retrievedTask = taskList.getTask(taskId);

		assertEquals(task, retrievedTask);
	}

	@Test
	public void testGetTask_InvalidId() {
		TaskList taskList = new TaskList();
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);
		assertNotEquals(taskId, "2");

		Task retrievedTask = taskList.getTask("2");
		assertNull(retrievedTask);
	}
}
