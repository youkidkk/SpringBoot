package springboot.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * SpringBootサンプル・アプリケーション
 */
@SpringBootApplication
public class SpringBootSampleApplication extends SpringBootServletInitializer {

	/**
	 * メインメソッド
	 * @param args パラメータ
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleApplication.class, args);
	}

}
