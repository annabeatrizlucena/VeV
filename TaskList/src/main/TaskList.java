package main;

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
	
	public String listTasks() {
		String listTasks = "";
		for (Task task : this.tasks) {
			listTasks = listTasks + task.toString() + ",\n";
		}
		return listTasks;
	}

	public String addTask(Task newTask) {
		this.tasks.add(newTask);
		return newTask.getId();
	}
}
