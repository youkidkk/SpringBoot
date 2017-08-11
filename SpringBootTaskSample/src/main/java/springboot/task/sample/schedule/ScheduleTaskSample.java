package springboot.task.sample.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("javadoc")
@SpringBootApplication
@EnableScheduling
public class ScheduleTaskSample {

    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    // initialDelay で初回のディレイを指定
    // fixedRate で間隔を指定
    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void task() {
        System.out.println(MessageFormat.format("{0} Schedule task running...",
                LocalDateTime.now().format(DATETIME_FORMAT)));
    }

    public static void main(String[] args) {
        SpringApplication.run(ScheduleTaskSample.class, args);
    }

}
