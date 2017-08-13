package springboot.property.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.text.MessageFormat;

@SpringBootApplication
@PropertySource("classpath:sample.properties")
@SuppressWarnings("javadoc")
public class PropertySample implements CommandLineRunner {

    @Value("${test1}")
    private String test1;

    @Autowired
    private Environment env;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(MessageFormat.format("Test1 = {0}", this.test1));
        System.out.println(MessageFormat.format("Test2 = {0}", this.env.getProperty("test2")));
    }

    public static void main(String[] args) {
        SpringApplication.run(PropertySample.class, args);
    }

}
