package springboot.task.sample.taskexecutor;

import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("javadoc")
public class SampleTask implements Runnable {

    /**
     * (非 Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.println("Task Start!!!");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task End!!!");
    }

}
