package springboot.task.sample.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import springboot.task.sample.schedule.Util;

import java.io.File;

@Configuration
@EnableScheduling
@SuppressWarnings("javadoc")
public class EndMonitorTask {

    private Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
    ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    ApplicationContext context;

    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void monitor() {
        File endFile = new File("end");
        if (endFile.exists()) {
            endFile.delete();
            this.logger.info("Shutdown!!!");
            this.taskScheduler.shutdown();

            Util.sleep(1000);
            if (this.taskScheduler.getActiveCount() > 1) {
                this.logger.error("Forced termination!!!");
                SpringApplication.exit(this.context);
            }
        }
    }

}
