package springboot.ajax.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * SpringBoot Ajaxサンプル・アプリケーション
 */
@SpringBootApplication
public class SpringBootAjaxSampleApplication {

    /**
     * メインメソッド
     * @param args パラメータ
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAjaxSampleApplication.class, args);
    }

    /**
     * メッセージソース設定
     * @return メッセージソース
     */
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
        bean.setBasename("classpath:ValidationMessages");
        bean.setDefaultEncoding("UTF-8");
        return bean;
    }

}
