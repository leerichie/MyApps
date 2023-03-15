package todo.list;

import java.util.Date;

public class ToDoItems {
    private int priority;
    private String description;
    private boolean isDone;
    private Date date;


    public ToDoItems(int priority, String description, boolean isDone, Date date) {
        this.priority = priority;
        this.description = description;
        this.isDone = isDone;
        this.date = date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}