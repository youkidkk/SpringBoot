package springboot.task.sample.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    // initialDelay で初回のディレイを指定
    // fixedRate で間隔を指定
    @Scheduled(initialDelay = 3000, fixedRate = 10000)
    public void task() {
        this.logger.info("Schedule task running...");
        Util.sleep(5000);
        this.logger.info("Schedule task end!!!");
    }

}
