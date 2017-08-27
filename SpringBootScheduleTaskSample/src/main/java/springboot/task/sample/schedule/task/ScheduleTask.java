package springboot.task.sample.schedule.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springboot.task.sample.schedule.Util;

/**
 * Configuration,EnableSchedulingアノテーションを付与すること。
 */
@Configuration
@EnableScheduling
@SuppressWarnings("javadoc")
public class ScheduleTask {

    // initialDelay で初回のディレイを指定
    // fixedRate で間隔を指定
    @Scheduled(initialDelay = 3000, fixedRate = 10000)
    public void task() {
        Util.print("Schedule task running...");
        Util.sleep(5000);
        Util.print("Schedule task end!!!");
    }

}
