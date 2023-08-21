package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

	private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

	public int getNumberOfTasks() {
		return this.tasks.size();
	}
	
	private List<Task> getTasksOrderedByDueDateAndPriority() {
        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(TaskComparators.DUE_DATE_AND_PRIORITY_COMPARATOR);
        return sortedTasks;
    }
	
	public String listTasks() {
		String listTasks = "";
		for (Task task : this.getTasksOrderedByDueDateAndPriority()) {
			listTasks = listTasks + task.toString() + ",\n";
		}
		return listTasks;
	}

	public String addTask(Task newTask) {
		this.tasks.add(newTask);
		return newTask.getId();
	}

	public void deleteTask(String taskId) {
		this.tasks.removeIf(task -> task.getId().equals(taskId));
	}

	public Task getTask(String taskId) {
        return tasks.stream().filter(task -> task.getId().equals(taskId)).findFirst().orElse(null);
    }

    public void setTaskPriority(String taskId, Priority priority) {
        Task taskToUpdate = getTask(taskId);
        if (taskToUpdate != null) {
        	if (priority == null) {
        		throw new IllegalArgumentException("Invalid Priority");
        	}
            taskToUpdate.setPriority(priority);
        }
    }

	public void updateTask(String taskId, Task updatedTask) {
        Task taskToUpdate = getTask(taskId);
        if (taskToUpdate != null) {
        	if (updatedTask.getTitle() == null || updatedTask.getDescription() == null || updatedTask.getDueDate() == null || updatedTask.getPriority() == null) {
        		throw new IllegalArgumentException("Invalid value");
        	}
            taskToUpdate.setTitle(updatedTask.getTitle());
            taskToUpdate.setDescription(updatedTask.getDescription());
            taskToUpdate.setDueDate(updatedTask.getDueDate());
            taskToUpdate.setPriority(updatedTask.getPriority());
        }
    }
}
