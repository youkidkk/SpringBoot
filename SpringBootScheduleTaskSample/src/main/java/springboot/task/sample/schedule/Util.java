package springboot.task.sample.schedule;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("javadoc")
public class Util {

    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void print(String message) {
        System.out.println(MessageFormat.format("{0} {1}",
                LocalDateTime.now().format(DATETIME_FORMAT), message));
    }

}
