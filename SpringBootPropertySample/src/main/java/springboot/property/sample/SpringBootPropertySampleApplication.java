package springboot.property.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SuppressWarnings("javadoc")
public class SpringBootPropertySampleApplication implements CommandLineRunner {

    @Autowired
    PropertySampleService propertySampleService;

    @Override
    public void run(String... args) throws Exception {
        this.propertySampleService.run();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPropertySampleApplication.class, args);
    }

}
