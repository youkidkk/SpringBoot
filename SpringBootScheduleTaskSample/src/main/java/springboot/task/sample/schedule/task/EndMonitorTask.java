package springboot.task.sample.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.io.File;

@Configuration
@EnableScheduling
@SuppressWarnings("javadoc")
public class EndMonitorTask {

    private Logger logger = LoggerFactory.getLogger(ScheduleTask.class);

    @Autowired
    ThreadPoolTaskScheduler taskScheduler;

    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void monitor() {
        File endFile = new File("end");
        if (endFile.exists()) {
            endFile.delete();
            this.logger.info("Shutdown!!!");
            this.taskScheduler.shutdown();
        }
    }

}
