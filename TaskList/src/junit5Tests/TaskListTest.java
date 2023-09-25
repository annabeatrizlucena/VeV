package junit5Tests;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import main.Priority;
import main.Task;
import main.TaskList;

@DisplayName("Testando o Gerenciador de Tarefas")
class TaskListTest {

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("create")
	@Test
	public @interface CreateTaskTest {
	}

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("read")
	@Test
	public @interface ReadTaskTest {
	}

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("update")
	@Test
	public @interface UpdateTaskTest {
	}

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("delete")
	@Test
	public @interface DeleteTaskTest {
	}

	private TaskList taskList;

	@BeforeEach
	public void setUp() {
		taskList = new TaskList();
	}

	@DisplayName("Criar tarefa com todos os atributos válidos")
	@CreateTaskTest
	public void testCreateTask_ValidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH));
		assertEquals(1, taskList.getNumberOfTasks());
	}

	@DisplayName("Criar tarefa com título nulo")
	@CreateTaskTest
	public void testCreateTask_InvalidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task(null, "Description", LocalDate.now(), Priority.HIGH));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@DisplayName("Criar tarefa com descrição nula")
	@CreateTaskTest
	public void testCreateTask_ValidTitle_InvalidDescription_ValidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", null, LocalDate.now(), Priority.HIGH));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@DisplayName("Criar tarefa com data nula")
	@CreateTaskTest
	public void testCreateTask_ValidTitle_ValidDescription_InvalidDueDate_ValidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", "Description", null, Priority.HIGH));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@DisplayName("Criar tarefa com prioridade nula")
	@CreateTaskTest
	public void testCreateTask_ValidTitle_ValidDescription_ValidDueDate_InvalidPriority() {
		String taskId = taskList.addTask(new Task("Sample Task", "Description", LocalDate.now(), null));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@DisplayName("Criar tarefa com todos os atributos nulos")
	@CreateTaskTest
	public void testCreateTask_InvalidTitle_InvalidDescription_InvalidDueDate_InvalidPriority() {
		String taskId = taskList.addTask(new Task(null, null, null, null));
		assertEquals(0, taskList.getNumberOfTasks());
		assertNull(taskId);
	}

	@DisplayName("Atualizar tarefa com todos os atributos válidos")
	@UpdateTaskTest
	public void testUpdateTask_ValidTitle_ValidDescription_ValidDueDate_ValidPriority() {
		Task originalTask = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(originalTask);

		Task updatedTask = new Task("Updated Task", "New Description", LocalDate.now(), Priority.LOW);
		taskList.updateTask(taskId, updatedTask);

		assertEquals("Updated Task", originalTask.getTitle());
		assertEquals("New Description", originalTask.getDescription());
		assertEquals(Priority.LOW, originalTask.getPriority());
	}

	@DisplayName("Atualizar tarefa com título nulo")
	@UpdateTaskTest
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

	@DisplayName("Atualizar tarefa com descrição nula")
	@UpdateTaskTest
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

	@DisplayName("Atualizar tarefa com data nula")
	@UpdateTaskTest
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

	@DisplayName("Atualizar tarefa com prioridade nula")
	@UpdateTaskTest
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

	@DisplayName("Atualizar tarefa com todos os atributos nulos")
	@UpdateTaskTest
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

	@DisplayName("Deletar uma tarefa existente")
	@DeleteTaskTest
	public void testDeleteTask_ValidId() {
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);

		assertEquals(1, taskList.getNumberOfTasks());
		taskList.deleteTask(taskId);

		assertEquals(0, taskList.getNumberOfTasks());
	}

	@DisplayName("Deletar uma tarefa inexistente")
	@DeleteTaskTest
	public void testDeleteTask_InvalidId() {
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);

		assertEquals(1, taskList.getNumberOfTasks());

		taskList.deleteTask("2");

		assertEquals(1, taskList.getNumberOfTasks());
	}

	@DisplayName("Visualizar uma tarefa existente")
	@ReadTaskTest
	public void testGetTask_ValidId() {
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);

		Task retrievedTask = taskList.getTask(taskId);

		assertEquals(task, retrievedTask);
	}

	@DisplayName("Visualizar uma tarefa inexistente")
	@ReadTaskTest
	public void testGetTask_InvalidId() {
		TaskList taskList = new TaskList();
		Task task = new Task("Sample Task", "Description", LocalDate.now(), Priority.HIGH);
		String taskId = taskList.addTask(task);
		assertNotEquals(taskId, "2");

		Task retrievedTask = taskList.getTask("2");
		assertNull(retrievedTask);
	}

	@DisplayName("Criar uma tarefa válida")
	@CreateTaskTest
	public void testAddValidTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(newTask);
		assertEquals(1, taskList.getNumberOfTasks());
	}

	@DisplayName("Alterar prioridade (válida) de uma tarefa existente")
	@UpdateTaskTest
	public void testSetPriorityValidTask() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		assertEquals(Priority.HIGH, task.getPriority());
		taskList.setTaskPriority(task.getId(), Priority.MEDIUM);
		assertEquals(Priority.MEDIUM, task.getPriority());
	}

	@DisplayName("Alterar prioridade (inválida) de uma tarefa existente")
	@UpdateTaskTest
	public void testSetPriorityInvalidPriority() {
		TaskList taskList = new TaskList();
		Task task = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		taskList.addTask(task);
		Assertions.assertThrows(IllegalArgumentException.class, () -> taskList.setTaskPriority(task.getId(), null));
	}

	@DisplayName("Alterar prioridade de uma tarefa não existente")
	@UpdateTaskTest
	public void testSetPriorityNonexistentTask() {
		TaskList taskList = new TaskList();
		Assertions.assertThrows(IllegalArgumentException.class, () -> taskList.setTaskPriority("1", Priority.LOW));

	}

	@DisplayName("Listar tasklist sem tarefas")
	@ReadTaskTest
	public void testListEmptyTasks() {
		TaskList taskList = new TaskList();
		String result = taskList.listTasks();
		assertEquals("", result);
	}

	@DisplayName("Listar tasklist com tarefas")
	@ReadTaskTest
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

	@DisplayName("Listar tasklist com tarefas de igual prioridade e datas diferentes")
	@ReadTaskTest
	public void testListTasksByDateAndPriorityLevelEqual() {
		Task task1 = new Task("Test Task List", "Implement tests for the task list manager",
				LocalDate.parse("2023-08-21", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		String taskId1 = taskList.addTask(task1);
		Task task2 = new Task("Test Task", "Implement tests for the task entity",
				LocalDate.parse("2023-08-30", DateTimeFormatter.ISO_DATE), Priority.HIGH);
		String taskId2 = taskList.addTask(task2);
		assertEquals(taskList.listTasks(),
				"Title: Test Task List\n" + "Description: Implement tests for the task list manager\n"
						+ "Due date: 2023-08-21\n" + "Priority: HIGH,\n" + "Title: Test Task\n"
						+ "Description: Implement tests for the task entity\n" + "Due date: 2023-08-30\n"
						+ "Priority: HIGH,\n");
	}

	@DisplayName("Listar tasklist com tarefas de prioridades e datas diferentes")
	@ReadTaskTest
	public void testListTasksByDateAndPriorityLevelNotEqual() {
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
