package springboot.property.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@PropertySource("classpath:sample.properties") // PropertySource でプロパティファイルを指定する
@SuppressWarnings("javadoc")
public class PropertySampleService {

    // Value を使用することで、プロパティ値をフィールドに設定できる
    @Value("${test1}")
    private String test1;

    // Environment を Autowired することで、プロパティファイルの内容を設定できる
    @Autowired
    private Environment env;

    public void run() {
        System.out.println(MessageFormat.format("Test1 = {0}", this.test1));
        System.out.println(MessageFormat.format("Test2 = {0}", this.env.getProperty("test2")));
    }

}
