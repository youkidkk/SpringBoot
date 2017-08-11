package springboot.task.sample.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@SuppressWarnings("javadoc")
public class AsyncTaskSample {

    @Async("threadPoolTaskExecutor")
    public void run(int i) {
        System.out.println(MessageFormat.format("Task {0} Start!!!", i));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(MessageFormat.format("Task {0} End!!!", i));
    }

}
