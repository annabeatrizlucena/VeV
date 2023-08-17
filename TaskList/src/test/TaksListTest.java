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
        taskManager.createTask(task);

        taskManager.setTaskPriority(task.getId(), Priority.MEDIUM);

        assertEquals(Priority.MEDIUM, task.getPriority());
    }
	//@Test
	//void testUpdateCreatedTask() {
	//	Task newTask = new Task("Test Task List", "Implement tests for the task list manager", "2023-08-21", Priority.HIGH);
	//	taskList.createTask(newTask);	
	//}

	
	
}
