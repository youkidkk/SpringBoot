package springboot.di.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("javadoc")
@SpringBootApplication
public class Main {

    /**
     * ※ 重要
     * Autowired する場合、対象は SpringBootApplication のクラスの配下に配置すること
     */
    @Autowired
    SampleComponent component;

    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args)) {
            Main m = ctx.getBean(Main.class);
            m.run(args);
        }
    }

    public void run(String[] args) {
        this.component.exec();
    }

}
