package springboot.task.sample.schedule.task;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ThreadPoolTaskScheduler taskScheduler;

    @Scheduled(initialDelay = 3000, fixedRate = 1000)
    public void monitor() {
        File endFile = new File("end");
        if (endFile.exists()) {
            endFile.delete();
            Util.print("Shutdown!!!");
            this.taskScheduler.shutdown();
        }
    }

}
