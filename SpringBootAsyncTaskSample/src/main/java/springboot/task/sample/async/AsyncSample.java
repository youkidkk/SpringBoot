package springboot.task.sample.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.stream.IntStream;

@SpringBootApplication
@Configuration
@EnableAsync
@SuppressWarnings("javadoc")
public class AsyncSample implements CommandLineRunner {

    @Autowired
    AsyncTaskSample asyncTaskSample;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    /**
     * (非 Javadoc)
     * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
     */
    @Override
    public void run(String... args) throws Exception {
        IntStream.range(1, 10).forEach(i -> {
            this.asyncTaskSample.run(i);
        });
        this.threadPoolTaskExecutor.shutdown();
    }

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        return executor;
    }

    public static void main(String[] args) {
        SpringApplication.run(AsyncSample.class, args);
    }

}
