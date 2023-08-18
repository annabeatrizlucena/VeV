package main;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Task {
	
	private String id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Priority priority;

    public Task(String title, String description, LocalDate dueDate, Priority priority) {
    	this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
    }

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public LocalDate getDueDate() {
		return this.dueDate;
	}

	public Priority getPriority() {
		return this.priority;
	}

	public String getId() {
		return this.id;
	}

}
