package model;

import exception.IncorrectTaskParameterException;

import java.time.LocalDateTime;

import static util.Constant.DATA_TIME_FORMATTER;

public class Task {

    private static int idGenerator = 1;
    private final int id;
    private String title;
    private String description;
    private Type type;
    private LocalDateTime dateTime;
    private Repeatability repeatability;


    public Task(String title, String description, Type type, LocalDateTime dateTime, Repeatability repeatability) throws IncorrectTaskParameterException {
        id = idGenerator++;
        setTitle(title);
        setDescription(description);
        setType(type);
        setDateTime(dateTime);
        setRepeatability(repeatability);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectTaskParameterException {

        if (title == null || title.isBlank() || title.isEmpty()) {
            throw new IncorrectTaskParameterException("заголовок задачи");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectTaskParameterException {
        if (description == null || description.isBlank() || description.isEmpty()) {
            throw new IncorrectTaskParameterException("описание задачи");
        }
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        if (type == null) {
            type = Type.PERSONAL;
        }
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) throws IncorrectTaskParameterException {
        if (dateTime == null) {
            throw new IncorrectTaskParameterException("дата и время задачи");
        }
        this.dateTime = dateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        if (repeatability == null) {
            repeatability = new OneTime();
        }
        this.repeatability = repeatability;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id задачи").append(id).append("\n")
                .append("заголовок задачи ").append(title).append("\n")
                .append("описание задачи ").append(description).append("\n")
                .append("тип задачи ").append(type == Type.PERSONAL? "личная":"рабочая").append("\n")
                .append("дата и время задачи ").append(dateTime.format(DATA_TIME_FORMATTER)).append("\n")
                .append("повторяемость задачи ").append(repeatability).append("\n");

        return stringBuilder.toString();
    }
}
