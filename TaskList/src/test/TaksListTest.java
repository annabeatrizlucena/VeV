package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TaksListTest {

	private TaskList taskList;

    @BeforeEach
    public void setUp() {
        taskList = new TaskList();
    }
	
	@Test
	void testEmptyTaskListSize() {
		assertEquals(taskList.getNumberOfTasks(), 0);
	}
	
	@Test
	void testListTasksEmptyTaskList() {
		assertEquals(taskList.listTasks(), "");
	}
	
	@Test
	void testTaskListSizeAfterCreateTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
		int taskId = taskList.createTask(newTask);
		assertEquals(taskList.getNumberOfTasks(), 1);
	}
	
	@Test
	void testListTasksAfterCreateTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
		int taskId = taskList.createTask(newTask);
		assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: HIGH,\n");
	}
	
	@Test
	void testTaskListSizeAfterDeleteTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
		int taskId = taskList.createTask(newTask);
		assertEquals(taskList.getNumberOfTasks(), 1);
		taskList.deleteTask(taskId);
		assertEquals(taskList.getNumberOfTasks(), 0);
	}
	
	@Test
	void testListTasksAfterDeleteTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
		int taskId = taskList.createTask(newTask);
		assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: HIGH,\n");
		taskList.deleteTask(taskId);
		assertEquals(taskList.listTasks(), "");
	}
	
	@Test
    public void testSetTaskPriority() {
        Task task = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
        taskList.createTask(task);

        taskList.setTaskPriority(task.getId(), Priority.MEDIUM);

        assertEquals(task.getPriority(), Priority.MEDIUM);
    }
	
	@Test
	void testUpdateCreatedTask() {
		Task newTask = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
		int taskId = taskList.createTask(newTask);
		assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: HIGH,\n");
		
		taskList.updateTask(taskId, "New Test task list", "Upgrade tests for the task list manager\n", "2023-08-20", Priority.LOW);
		assertEquals(taskList.listTasks(), "New Test task list\n"
				+ "Description: Upgrade tests for the task list manager\n"
				+ "Due date: 2023-08-20\n"
				+ "Priority: LOW,\n");
	}
	
	@Test
	public void testListTasksByDateAndPriorityLevelEqual() {
		Task task1 = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
		int taskId1 = taskList.createTask(task1);
        Task task2 = new Task("Test Task", "Implement tests for the task entity", "2023-08-30", Priority.HIGH);
        int taskId2 = taskList.createTask(task2);
        assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: HIGH,\n"
				+ "Title: Test Task\n"
				+ "Description: Implement tests for the task entity\n"
				+ "Due date: 2023-08-30\n"
				+ "Priority: HIGH,\n");
	}
	
	@Test
	public void testListTasksByDateAndPriorityLevelNotEqual() {
		Task task1 = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.LOW);
		int taskId1 = taskList.createTask(task1);
        Task task2 = new Task("Test Task", "Implement tests for the task entity", "2023-08-30", Priority.HIGH);
        int taskId2 = taskList.createTask(task2);
        assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: HIGH,\n"
				+ "Title: Test Task\n"
				+ "Description: Implement tests for the task entity\n"
				+ "Due date: 2023-08-30\n"
				+ "Priority: HIGH,\n");
	}
	
	@Test
	public void testSetTaskPriority() {
		Task task = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.LOW);
		int taskId = taskList.createTask(task);
		assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: LOW,\n");
		taskList.setTaskPriority(taskId, Priority.HIGH);
		assertEquals(taskList.listTasks(), "Title: Test Task List\n"
				+ "Description: Implement tests for the task list manager\n"
				+ "Due date: 2023-08-21\n"
				+ "Priority: HIGH,\n");
		
		
	}
}
