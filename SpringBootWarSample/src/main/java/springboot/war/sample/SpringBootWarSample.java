package springboot.war.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@SuppressWarnings("javadoc")
public class SpringBootWarSample
        extends SpringBootServletInitializer // SpringBootServletInitializer を継承する
{

    // configure をオーバーライドし、自身のクラスを指定する
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWarSample.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWarSample.class, args);
    }

}