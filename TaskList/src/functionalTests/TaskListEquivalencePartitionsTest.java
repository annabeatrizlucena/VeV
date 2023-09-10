package functionalTests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import main.Priority;
import main.Task;
import main.TaskList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TaskListEquivalencePartitionsTest {

	private TaskList taskList;

	@BeforeEach
	public void setUp() {
		taskList = new TaskList();
	}

	@Test
	public void testAddValidTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(newTask);
		assertEquals(1, taskList.getNumberOfTasks());
	}

	// ta criando
	@Test
	public void testAddTaskWithInvalidAttribute() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager", LocalDate.now(), null);
		String taskId = taskList.addTask(task);
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@Test
	public void testDeleteExistingTask() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		taskList.deleteTask(task.getId());
		assertEquals(0, taskList.getNumberOfTasks());
	}

	@Test
	public void testDeleteNonexistentTask() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		assertEquals(1, taskList.getNumberOfTasks());
		taskList.deleteTask("2");
		assertEquals(1, taskList.getNumberOfTasks());
	}

	@Test
	public void testGetExistingTask() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		Task retrievedTask = taskList.getTask(task.getId());
		assertEquals(task, retrievedTask);
	}

	@Test
	public void testGetNonexistentTask() {
		TaskList taskList = new TaskList();
		Task retrievedTask = taskList.getTask("1");
		assertNull(retrievedTask);
	}

	@Test
	public void testSetPriorityValidTask() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		assertEquals(Priority.HIGH, task.getPriority());
		taskList.setTaskPriority(task.getId(), Priority.MEDIUM);
		assertEquals(Priority.MEDIUM, task.getPriority());
	}

	@Test
	public void testSetPriorityInvalidPriority() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		Assertions.assertThrows(IllegalArgumentException.class, () -> taskList.setTaskPriority(task.getId(), null));
	}

	@Test
	public void testSetPriorityNonexistentTask() {
		TaskList taskList = new TaskList();
		Assertions.assertThrows(IllegalArgumentException.class, () -> taskList.setTaskPriority("1", Priority.LOW));

	}

	@Test
	public void testUpdateTaskExistingValidAttributes() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		Task updatedTask = new Task("Updated Task", "New Description", LocalDate.now(), Priority.LOW);
		taskList.updateTask(task.getId(), updatedTask);
		assertEquals("Updated Task", task.getTitle());
		assertEquals("New Description", task.getDescription());
		assertEquals(Priority.LOW, task.getPriority());
	}

	@Test
	public void testUpdateTaskExistingInvalidAttributes() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		Task updatedTask = new Task(null, "New Description", LocalDate.now(), Priority.LOW);
		Assertions.assertThrows(IllegalArgumentException.class, () -> taskList.updateTask(task.getId(), updatedTask));
	}

	@Test
	public void testUpdateTaskNonexistentTask() {
		TaskList taskList = new TaskList();
		Task updatedTask = new Task("Updated Task", "New Description", LocalDate.now(), Priority.LOW);
		Assertions.assertThrows(IllegalArgumentException.class, () -> taskList.updateTask("1", updatedTask));
	}

	@Test
	public void testListEmptyTasks() {
		TaskList taskList = new TaskList();
		String result = taskList.listTasks();
		assertEquals("", result);
	}

	@Test
	public void testListMultipleTasks() {
		Task task1 = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.LOW);
		String taskId1 = taskList.addTask(task1);
		Task task2 = new Task("Test Task", "Implement tests for the task entity",
				LocalDate.parse("2023-08-30", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		String taskId2 = taskList.addTask(task2);
		assertEquals(taskList.listTasks(),
				"Title: Test Task List\n" + "Description: Implement tests for the task list manager\n"
						+ "Due date: 2023-08-21\n" + "Priority: LOW,\n" + "Title: Test Task\n"
						+ "Description: Implement tests for the task entity\n" + "Due date: 2023-08-30\n"
						+ "Priority: HIGH,\n");
	}
}
