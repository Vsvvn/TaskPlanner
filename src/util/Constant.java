package util;

import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Constant {

    public static final DateTimeFormatter DATA_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private Constant() {

    }
}
