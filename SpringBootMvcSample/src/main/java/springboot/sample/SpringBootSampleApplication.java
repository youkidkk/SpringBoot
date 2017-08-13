package springboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootサンプル・アプリケーション
 */
@SpringBootApplication
public class SpringBootSampleApplication {

    /**
     * メインメソッド
     * @param args パラメータ
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSampleApplication.class, args);
    }

}
