package springboot.task.sample.taskexecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SuppressWarnings("javadoc")
@SpringBootApplication
@EnableAsync
@ImportResource("TaskExecutorSample.xml")
public class TaskExecutorSample implements CommandLineRunner {

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    /**
     * (非 Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());
        this.taskExecutor.execute(new SampleTask());

        this.taskExecutor.shutdown();
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskExecutorSample.class, args);
    }

}
