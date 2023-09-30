package exception;

public class TaskNotFoundException extends Exception {

    private final int id;


    public TaskNotFoundException(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "задача с " + id + " не найдена!";
    }
}
