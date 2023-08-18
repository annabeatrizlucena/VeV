package main;

import java.util.Comparator;

public class TaskComparators {

    public static final Comparator<Task> DUE_DATE_AND_PRIORITY_COMPARATOR =
            Comparator.comparing(Task::getDueDate).thenComparing(Task::getPriority);

    public static final Comparator<Task> PRIORITY_COMPARATOR = Comparator.comparing(task -> {
        switch (task.getPriority()) {
            case HIGH:
                return 0;
            case MEDIUM:
                return 1;
            case LOW:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown priority");
        }
    });
}

