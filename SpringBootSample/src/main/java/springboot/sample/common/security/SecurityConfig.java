package springboot.sample.common.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * セキュリティ設定
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// css, js, imagesは匿名アクセスOK
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/images/**").permitAll()
				// ADMIN roleじゃないと/adminには入れない
				.antMatchers("/admin").hasRole("ADMIN")
				// それ以外は匿名アクセス禁止
				.anyRequest().authenticated();
		// ログインは/loginでおこなってパラメータはusernameとpassword
		http.formLogin().loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll().and();
		// ログアウトは/logout
		http.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login")
				.deleteCookies("JSESSIONID")
				.invalidateHttpSession(true).permitAll();
	}

}