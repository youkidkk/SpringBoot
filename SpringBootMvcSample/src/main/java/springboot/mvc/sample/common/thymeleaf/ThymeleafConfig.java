package springboot.mvc.sample.common.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;

/**
 * Thymeleaf設定（ダイアレクト追加）
 */
@Configuration
public class ThymeleafConfig {

    /** テンプレートエンジン */
    @Autowired
    public TemplateEngine templateEngine;

    /**
     * ダイアレクト追加
     * @return テンプレートエンジン
     */
    @Bean
    public TemplateEngine addDialect() {
        this.templateEngine.addDialect(new CustomExpressionDialect());
        return this.templateEngine;
    }
}