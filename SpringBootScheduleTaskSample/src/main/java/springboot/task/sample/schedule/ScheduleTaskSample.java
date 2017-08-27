package springboot.task.sample.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.io.File;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("javadoc")
@SpringBootApplication
@EnableScheduling
public class ScheduleTaskSample implements SchedulingConfigurer {

    public static final DateTimeFormatter DATETIME_FORMAT = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss:SSS");

    // initialDelay で初回のディレイを指定
    // fixedRate で間隔を指定
    @Scheduled(initialDelay = 3000, fixedRate = 10000)
    public void task() {
        this.print("Schedule task running...");
        this.sleep(5000);
        this.print("Schedule task end!!!");
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String message) {
        System.out.println(MessageFormat.format("{0} {1}",
                LocalDateTime.now().format(DATETIME_FORMAT), message));
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ScheduleTaskSample.class, args);
    }

    @Autowired
    ThreadPoolTaskScheduler taskScheduler;

    /**
     * (非 Javadoc)
     * @see org.springframework.scheduling.annotation.SchedulingConfigurer#configureTasks(org.springframework.scheduling.config.ScheduledTaskRegistrar)
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setTaskScheduler(this.taskScheduler);
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void monitorEnd() {
        File endFile = new File("end");
        if (endFile.exists()) {
            endFile.delete();
            this.taskScheduler.shutdown();
        }
    }

}
