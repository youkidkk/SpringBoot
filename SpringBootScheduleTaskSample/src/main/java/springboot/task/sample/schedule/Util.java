package springboot.task.sample.schedule;

@SuppressWarnings("javadoc")
public class Util {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
