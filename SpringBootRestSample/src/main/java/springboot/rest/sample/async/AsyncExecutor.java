package springboot.rest.sample.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import springboot.rest.sample.domain.SampleData;
import springboot.rest.sample.mapper.SampleDataMapper;

@Service
@SuppressWarnings("javadoc")
public class AsyncExecutor {

    @Autowired
    SampleDataMapper sampleDataMapper;

    @Async("threadPoolTaskExecutor")
    public void add(SampleData sampleData) {
        System.out.println("Task {0} Start!!!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.sampleDataMapper.insert(sampleData);

        System.out.println("Task {0} End!!!");
    }

}
